package lib;

import java.util.Comparator;

public class ArvoreAVL <T> extends ArvoreBinaria<T>{

    public ArvoreAVL(Comparator<T> comparator) {
        super(comparator);
    }

    //Implementar métodos para efetuar o balanceamento e sobrescrever método de adicionar elemento...
    @Override
    protected No<T> inserirRecursivo(No<T> raiz, T novo){
        raiz = super.inserirRecursivo(raiz,novo);

        if(raiz.fatorBalanceamento()>1){
            if(raiz.getFilhoDireita().fatorBalanceamento()>0)
                raiz = this.rotacaoEsquerda(raiz);
            else
                raiz = this.rotacaoDireitaEsquerda(raiz);
        }
        else if(raiz.fatorBalanceamento()<-1){
            if(raiz.getFilhoEsquerda().fatorBalanceamento()<0)
                raiz = this.rotacaoDireita(raiz);
            else raiz = this.rotacaoEsquerdaDireita(raiz);
        }
        return raiz;
    }

    @Override
    protected No<T> removerRecursivo(No<T> atual, T valor) {
        atual = super.removerRecursivo(atual, valor);

        if (atual == null) return null;

        int fb = atual.fatorBalanceamento();

        if (fb > 1) { // Direita desbalanceada
            if (atual.getFilhoDireita().fatorBalanceamento() >= 0) {
                return rotacaoEsquerda(atual);
            } else {
                return rotacaoDireitaEsquerda(atual);
            }
        } else if (fb < -1) { // Esquerda desbalanceada
            if (atual.getFilhoEsquerda().fatorBalanceamento() <= 0) {
                return rotacaoDireita(atual);
            } else {
                return rotacaoEsquerdaDireita(atual);
            }
        }

        return atual;
    }
}