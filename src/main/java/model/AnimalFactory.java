package model;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class AnimalFactory implements Animal {
    private String name;
    private Species species;

    public AnimalFactory getAnimal(String species, String name) {
        AnimalFactory animal;
        switch(species.toLowerCase()) {
            case "leon": animal = new AnimalLeon(Species.LEON,name);
                break;
            case "giraffe": animal = new AnimalGiraffe(Species.GIRAFFE, name);
                break;
            case "squirrel": animal = new AnimalSquirrel(Species.SQUIRREL, name);
                break;
            case "penguin": animal = new AnimalPenguin(Species.PENGUIN, name);
                break;
            default: throw new IllegalArgumentException("Type is not correct!");
        }
        return animal;
    }

    public AnimalFactory(Species species, String name) {
        this.species = species;
        this.name = name;
    }

    public AnimalFactory(String name) {
        this.name = name;
    }

    public AnimalFactory() {

    }


    @Override
    public String getName() {
        return name;
    }

    @Override
    public Species getSpecies() {
        return species;
    }


}
