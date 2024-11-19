import java.io.FileReader;
import java.util.Scanner;

import droidbattle.*;

public class Main {

    /**
     * @param args
     * @throws Exception
     */

    public static void main(String[] args) throws Exception {
        System.out.println("\n\t\tWeLcOmE tO mY dRoId BatTlE");
        System.out.println("In this game we have 3 types of arenas, 4 droids and two GAME modes.\n");
        System.out.println("PICK settings what your need:");
        System.out.println("1. One By One. ");
        System.out.println("2. Team By Team. ");
        System.out.println("3. Show last FIGHT.");

        try (Scanner inp = new Scanner(System.in)) {
            int userInput;
            System.out.print("PLAYER: ");
            userInput = inp.nextInt();
            switch (userInput) {
                case 1:
                    System.out.println("\nGreat choise. One by one battles the only way to explore the strongest hero!");
                    new DroidBattle().battle();
                    break;

                case 2:
                    new DroidBattle().partyBatlle();
                    break;

                case 3:
                    FileReader fr = new FileReader("battleLog.txt");
                    int i;
                    while ((i = fr.read()) != -1) {
                        System.out.print((char) i);
                    }
                    break;

                default:
                    System.out.println("Wrong input!!!");
                    System.out.println("RESTARTING THE GAME.");
                    main(args);
                    break;
            }
        }
    }
}