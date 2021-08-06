package model;

public class CommandHandler {
    private AnimalFactory animalFactory = new AnimalFactory();
    private ZooImpl zooImpl;

    public CommandHandler(ZooImpl zooImpl) {
        this.zooImpl = zooImpl;
    }

    public void checkCommand(String[] command) throws ArrayIndexOutOfBoundsException {
        switch(command[0]) {
            case "check-in":
                switch (command[1]) {
                    case "leon": animalFactory = new AnimalLeon(Species.LEON, command[2]);
                    zooImpl.checkInAnimal(animalFactory);
                    break;
                    case "giraffe": animalFactory = new AnimalGiraffe(Species.GIRAFFE, command[2]);
                    zooImpl.checkInAnimal(animalFactory);
                    break;
                    case "squirrel": animalFactory = new AnimalSquirrel(Species.SQUIRREL, command[2]);
                    zooImpl.checkInAnimal(animalFactory);
                    break;
                    case "penguin": animalFactory = new AnimalPenguin(Species.PENGUIN, command[2]);
                    zooImpl.checkInAnimal(animalFactory);
                    break;
                    default: System.out.println("Type animal is not correct!");
                    break;
                }
            break;
            case "check-out": animalFactory = new AnimalFactory(command[1]);
            zooImpl.checkOutAnimal(animalFactory);
            break;
            case "log": zooImpl.getLog();
            break;
            default: System.out.println("Your command is not correct!");
            break;

        }
    }



}
