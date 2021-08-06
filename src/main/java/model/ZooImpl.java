package model;

import java.util.Date;
import java.util.List;

public class ZooImpl implements Zoo {
    private CheckAnimalCage checkAnimalCage;
    private ZooInit zooinit;

    public ZooImpl(ZooInit zooInit, CheckAnimalCage checkAnimalCage) {
        this.zooinit = zooInit;
        this.checkAnimalCage = checkAnimalCage;
    }


    @Override
    public void checkInAnimal(Animal animal) {
        checkAnimalCage.checkNameAnimal();
        int addAnimal = 0;
        int addName = 0;
        for(String nameAnimal : checkAnimalCage.getNamesAnimals()) {
            if(!animal.getName().equals(nameAnimal)) {
                ++addName;
            }
        }

        for(CageImpl cage : zooinit.getCages()) {
            if(animal.getSpecies() == cage.getCondition().isAvailableFor().get(0) && cage.isVacantCage() && addName == checkAnimalCage.getCount() || checkAnimalCage.getCount() == 0) {
                ++addAnimal;
            }
        }


        if(addAnimal > 0) {
            System.out.println("Your animal is added in the zoo!");
            addAnimal = 0;
            addName = 0;
            InhibitionLog log = new InhibitionLog(new Date(), null, animal.getSpecies(), animal.getName());
            checkAnimalCage.updateAddAnimal(animal.getSpecies(), animal.getName());
            checkAnimalCage.updateInLog(log);

            zooinit.checkDbCage();
            checkAnimalCage.getNamesAnimals().clear();

        }
        else {
            System.out.println("Your animal can not add in the zoo!");
        }
    }

    @Override
    public void checkOutAnimal(Animal animal) {
        int remove = 0;
        checkAnimalCage.checkNameAnimal();
        for(String name : checkAnimalCage.getNamesAnimals()) {
            if(animal.getName().equalsIgnoreCase(name)) {
                ++remove;
            }
        }

        if(remove > 0) {
            System.out.println("Animal was removed!");
            remove = 0;
            InhibitionLog log = new InhibitionLog(null, new Date(), animal.getSpecies(), animal.getName());
            checkAnimalCage.updateOutLog(log);
            checkAnimalCage.updateOutAnimal(animal.getName());
            zooinit.checkDbCage();
            checkAnimalCage.getNamesAnimals().clear();
        }
        else if(remove == 0) {
            System.out.println("Animal is not removed!");
        }
    }

    public void getLog() {
        checkAnimalCage.getLog();
    }

    @Override
    public List<InhibitionLog> getHistory() {
        return null;
    }
}
