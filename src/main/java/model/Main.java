package model;

import javax.swing.plaf.nimbus.State;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        ZooInit zooInit = new ZooInit();
        zooInit.checkDbCage();
        CheckAnimalCage checkAnimalCage = new CheckAnimalCage(zooInit);
        ZooImpl zooImpl = new ZooImpl(zooInit, checkAnimalCage);
        ParserCommand parser = new ParserCommand();
        CommandHandler commandHandler = new CommandHandler(zooImpl);
        while(true) {
            try {
                commandHandler.checkCommand(parser.enterCommand());
            }
            catch(ArrayIndexOutOfBoundsException ex) {
                System.out.println("Your command is not correct!");
            }

        }
    }
}
