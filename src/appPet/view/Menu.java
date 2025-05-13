package appPet.view;

import java.util.Scanner;

public class Menu {

    public static int exibirMenu() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n+----------------------------------+");
        System.out.println("|         MENU PET ADOÇÃO          |");
        System.out.println("+----------------------------------+");
        System.out.println("| 1 | Adicionar Pet                |");
        System.out.println("| 2 | Pesquisar Pet por ID         |");
        System.out.println("| 3 | Pesquisar Pet por Nome       |");
        System.out.println("| 4 | Remover Pet por ID           |");
        System.out.println("| 5 | Listar Pets por ID (Ordem)   |");
        System.out.println("| 6 | Listar Pets por Nível        |");
        System.out.println("| 0 | Sair                         |");
        System.out.println("+----------------------------------+");
        System.out.print("Digite sua opção: ");

        return Integer.parseInt(scanner.nextLine());
    }
}