package model;

public class AnimalLeon extends AnimalFactory {
    private String name;
    private Species species;

    public AnimalLeon(Species species, String name) {
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
