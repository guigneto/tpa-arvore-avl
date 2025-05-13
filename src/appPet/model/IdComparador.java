package appPet.model;

import java.util.Comparator;


public class IdComparador implements Comparator<Pet> {

    @Override
    public int compare(Pet p1, Pet p2) {
        return Integer.compare(p1.getId(), p2.getId());
    }

}
