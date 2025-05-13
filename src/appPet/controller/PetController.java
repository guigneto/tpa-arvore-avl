package appPet.controller;

import lib.ArvoreBinaria;
import appPet.model.IdComparador;
import appPet.model.NomeComparador;
import appPet.model.Pet;
import appPet.view.Menu;

import java.util.Scanner;

public class PetController {

    private ArvoreBinaria<Pet> arvore;
    private Scanner scanner;

    public PetController() {
        this.arvore = new ArvoreBinaria<>(new IdComparador()); // Arvore baseada em ID
        this.scanner = new Scanner(System.in);
    }

    public void executar() {
        int opcao;
        do {
            opcao = Menu.exibirMenu();

            switch (opcao) {
                case 1 -> adicionarPet();
                case 2 -> pesquisarPetPorId();
                case 3 -> pesquisarPetPorNome();
                case 4 -> removerPet();
                case 5 -> listarPetsEmOrdem();
                case 6 -> listarPetsPorNivel();
                case 0 -> System.out.println("Encerrando o programa. Até logo!");
                default -> System.out.println("Opção inválida!");
            }

        } while (opcao != 0);
    }

    public void adicionarPet() {
        System.out.print("Nome do pet: ");
        String nome = scanner.nextLine();

        System.out.print("Idade: ");
        int idade = Integer.parseInt(scanner.nextLine());

        System.out.print("Espécie: ");
        String especie = scanner.nextLine();

        System.out.print("Raça: ");
        String raca = scanner.nextLine();

        Pet novoPet = new Pet(nome, idade, especie, raca);
        arvore.adicionar(novoPet);
        System.out.println("Pet adicionado com sucesso! (ID: " + novoPet.getId() + ")");
    }

    public void pesquisarPetPorId() {
        System.out.print("Digite o ID do pet para pesquisar: ");
        int id = Integer.parseInt(scanner.nextLine());

        // Criando um Pet "dummy" apenas com o ID (outros campos irrelevantes)
        Pet dummy = new Pet("dummy", 0, "", "");
        dummy.setId(id);

        Pet encontrado = (Pet) arvore.pesquisar(dummy);

        if (encontrado != null) {
            System.out.println("Pet encontrado: " + encontrado);
        } else {
            System.out.println("Pet não encontrado.");
        }
    }

    public void pesquisarPetPorNome() {
        System.out.print("Digite o nome do pet para pesquisar: ");
        String nome = scanner.nextLine();

        Pet dummy = new Pet(nome, 0, "", "");
        Pet encontrado = (Pet) arvore.pesquisar(dummy, new NomeComparador());

        if (encontrado != null) {
            System.out.println("Pet encontrado: " + encontrado);
        } else {
            System.out.println("Pet não encontrado.");
        }
    }

    public void removerPet() {
        System.out.print("Digite o ID do pet para remover: ");
        int id = Integer.parseInt(scanner.nextLine());

        Pet dummy = new Pet("dummy", 0, "", "");
        dummy.setId(id);

        Pet removido = (Pet) arvore.remover(dummy);

        if (removido != null) {
            System.out.println("Pet removido com sucesso.");
        } else {
            System.out.println("Pet não encontrado.");
        }
    }

    public void listarPetsEmOrdem() {
        System.out.println("Pets em ordem (por ID):");
        System.out.println(arvore.caminharEmOrdem());
    }

    public void listarPetsPorNivel() {
        System.out.println("Pets por nível (em largura):");
        System.out.println(arvore.caminharEmNivel());
    }
}
