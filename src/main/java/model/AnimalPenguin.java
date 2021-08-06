package model;

public class AnimalPenguin extends AnimalFactory {
    private String name;
    private Species species;

    public AnimalPenguin(Species species, String name) {
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
