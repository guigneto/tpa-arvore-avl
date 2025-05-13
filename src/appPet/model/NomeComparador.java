package appPet.model;

import java.util.Comparator;

public class NomeComparador implements Comparator<Pet> {

    @Override
    public int compare(Pet p1, Pet p2) {
        return p1.getNome().compareToIgnoreCase(p2.getNome());
    }
}