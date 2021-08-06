package model;

import java.util.Scanner;

public class ParserCommand {
    private Scanner in = new Scanner(System.in);
    private String commandUser;
    private String[] command;
    private String split = " ";


    public String[] enterCommand() {
        System.out.print("Enter your command: ");
        commandUser = in.nextLine();
        command = commandUser.split(split);
        return command;
    }






}
