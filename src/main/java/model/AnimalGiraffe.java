package model;

public class AnimalGiraffe extends AnimalFactory {
    private String name;
    private Species species;

    public AnimalGiraffe(Species species, String name) {
        this.species = species;
        this.name = name;
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