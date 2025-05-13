package appPet.view;

import java.util.Scanner;

public class Menu {

    public static int exibirMenu() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n--- Menu Pet Adocao ---");
        System.out.println("1. Adicionar Pet");
        System.out.println("2. Pesquisar Pet por ID");
        System.out.println("3. Pesquisar Pet por Nome");
        System.out.println("4. Remover Pet por ID");
        System.out.println("5. Listar Pets em Ordem (por ID)");
        System.out.println("6. Listar Pets por Nivel (em Largura)");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
        return Integer.parseInt(scanner.nextLine());
    }
}