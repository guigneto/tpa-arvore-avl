package lib;
import java.util.Queue;
import java.util.LinkedList;

import java.util.Comparator;

public class ArvoreBinaria<T> implements IArvoreBinaria<T>{

    protected No<T> raiz = null;
    protected Comparator<T> comparador;
    protected int quantidade;

    public ArvoreBinaria(Comparator<T> comp) {
        comparador = comp;
    }

    @Override
    public void adicionar(Object novoValor) {
        T valor = (T) novoValor;
        raiz = inserirRecursivo(raiz, valor);

    }

    protected No<T> inserirRecursivo(No<T> atual, T valor) {
        if (atual == null) {
            quantidade++;
            return new No<>(valor);
        }

        int cmp = comparador.compare(valor, atual.getValor());

        if (cmp < 0) {
            atual.setFilhoEsquerda(inserirRecursivo(atual.getFilhoEsquerda(), valor));
        } else if (cmp > 0) {
            atual.setFilhoDireita(inserirRecursivo(atual.getFilhoDireita(), valor));
        }

        return atual;
    }

    @Override
    public Object pesquisar(Object valor) {
        T val = (T) valor;
        return pesquisarRecursivo(raiz, val);
    }

    protected T pesquisarRecursivo(No<T> atual, T valor) {
        if (atual == null) return null;

        int cmp = comparador.compare(valor, atual.getValor());

        if (cmp == 0) {
            return atual.getValor();
        } else if (cmp < 0) {
            return pesquisarRecursivo(atual.getFilhoEsquerda(), valor);
        } else {
            return pesquisarRecursivo(atual.getFilhoDireita(), valor);
        }
    }

    @Override
    public Object pesquisar(Object valor, Comparator comp) {
        T val = (T) valor;
        return pesquisarComComparator(raiz, val, comp);
    }

    protected T pesquisarComComparator(No<T> atual, T valor, Comparator comp) {
        if (atual == null) return null;

        // Primeiro: tenta comparar no nó atual
        if (comp.compare(valor, atual.getValor()) == 0) {
            return atual.getValor();
        }

        // Se não encontrou, tenta no filho da esquerda
        T encontradoEsquerda = pesquisarComComparator(atual.getFilhoEsquerda(), valor, comp);
        if (encontradoEsquerda != null) {
            return encontradoEsquerda;
        }

        // Se ainda não encontrou, tenta no filho da direita
        return pesquisarComComparator(atual.getFilhoDireita(), valor, comp);
    }

    @Override
    public Object remover(Object valor) {
        T val = (T) valor;
        raiz = removerRecursivo(raiz, val);
        return val;
    }

    protected No<T> removerRecursivo(No<T> atual, T valor) {
        if (atual == null) return null;

        int cmp = comparador.compare(valor, atual.getValor());

        if (cmp < 0) {
            atual.setFilhoEsquerda(removerRecursivo(atual.getFilhoEsquerda(), valor));
        } else if (cmp > 0) {
            atual.setFilhoDireita(removerRecursivo(atual.getFilhoDireita(), valor));
        } else {
            // caso 1: sem filhos
            if (atual.getFilhoEsquerda() == null && atual.getFilhoDireita() == null) {
                return null;
            }
            // caso 2: um filho
            else if (atual.getFilhoEsquerda() == null) {
                return atual.getFilhoDireita();
            } else if (atual.getFilhoDireita() == null) {
                return atual.getFilhoEsquerda();
            }

            // caso 3: dois filhos
            T menorValor = encontrarMenorValor(atual.getFilhoDireita());
            atual.setValor(menorValor);
            atual.setFilhoDireita(removerRecursivo(atual.getFilhoDireita(), menorValor));
        }

        return atual;
    }

    private T encontrarMenorValor(No<T> no) {
        while (no.getFilhoEsquerda() != null) {
            no = no.getFilhoEsquerda();
        }
        return no.getValor();
    }

    @Override
    public int altura() {
        return calcularAltura(raiz);
    }

    public int calcularAltura(No<T> no) {
        if (no == null) return -1; // altura de árvore vazia = -1 (sem níveis)
        int alturaEsquerda = calcularAltura(no.getFilhoEsquerda());
        int alturaDireita = calcularAltura(no.getFilhoDireita());
        return 1 + Math.max(alturaEsquerda, alturaDireita);
    }

    @Override
    public int quantidadeNos() {
        return contarNos(raiz);
    }

    protected int contarNos(No<T> no) {
        if (no == null) return 0;
        return 1 + contarNos(no.getFilhoEsquerda()) + contarNos(no.getFilhoDireita());
    }

    @Override
    public String caminharEmNivel() {
        if (raiz == null) return "";

        StringBuilder resultado = new StringBuilder();
        Queue<No<T>> fila = new LinkedList<>();
        fila.add(raiz);

        while (!fila.isEmpty()) {
            No<T> atual = fila.poll();
            resultado.append(atual.getValor()).append(" ");

            if (atual.getFilhoEsquerda() != null) fila.add(atual.getFilhoEsquerda());
            if (atual.getFilhoDireita() != null) fila.add(atual.getFilhoDireita());
        }

        return resultado.toString().trim();
    }


    @Override
    public String caminharEmOrdem() {
        StringBuilder resultado = new StringBuilder();
        caminharEmOrdem(raiz, resultado);
        return resultado.toString().trim(); // remove o espaço no fim
    }

    protected void caminharEmOrdem(No<T> no, StringBuilder sb) {
        if (no != null) {
            caminharEmOrdem(no.getFilhoEsquerda(), sb);
            sb.append(no.getValor()).append(" ");
            caminharEmOrdem(no.getFilhoDireita(), sb);
        }
    }

}
