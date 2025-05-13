package appPet.model;

import java.util.Random;

public class Pet {

    private int id;
    private String nome;
    private int idade;
    private String especie;
    private String raca;

    public Pet(String nome, int idade, String especie, String raca) {
        this.id = gerarId();
        this.nome = nome;
        this.idade = idade;
        this.especie = especie;
        this.raca = raca;
    }

    private int gerarId() {
        Random random = new Random();
        return random.nextInt(9000) + 1000; // Gera ID de 4 dígitos entre 1000 e 9999
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public String getEspecie() {
        return especie;
    }

    public String getRaca() {
        return raca;
    }

    @Override
    public String toString() {
        return "#" + id + " - " + nome + " (" + raca + ", " + idade + " anos, " + especie + ")";
    }
}