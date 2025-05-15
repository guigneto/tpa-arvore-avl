package teste;

import lib.ArvoreAVL;
import lib.IArvoreBinaria;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        // Comparador para inteiros
        Comparator<Integer> comp = Integer::compareTo;

        // Cria árvore AVL
        IArvoreBinaria<Integer> arvoreAVL = new ArvoreAVL<>(comp);

        // Inserções
        int[] valores = {30, 20, 40, 10, 25, 35, 50, 5};
        for (int val : valores) {
            arvoreAVL.adicionar(val);
        }

        System.out.println("Árvore AVL (em ordem):");
        System.out.println(arvoreAVL.caminharEmOrdem());

        System.out.println("\nÁrvore AVL (em nível):");
        System.out.println(arvoreAVL.caminharEmNivel());

        System.out.println("\nAltura da árvore: " + arvoreAVL.altura());

        // Remoção
        System.out.println("\nRemovendo 20...");
        arvoreAVL.remover(20);

        System.out.println("Árvore AVL (em ordem) após remoção:");
        System.out.println(arvoreAVL.caminharEmOrdem());

        System.out.println("\nÁrvore AVL (em nível) após remoção:");
        System.out.println(arvoreAVL.caminharEmNivel());

        System.out.println("\nNova altura da árvore: " + arvoreAVL.altura());
    }
}
