package droidbattle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import arenas.*;
import controller.*;
import droids.*;

public class DroidBattle {
    public void battle() throws InterruptedException, IOException {
        Droid droid1 = getDroidByPlayer();
        Droid droid2 = getDroidByPlayer();
        // choose arena
        Arena arena;
        Scanner input = new Scanner(System.in);
        System.out.println("\nGreat, final point.\nChoose a battle place:");
        System.out.println("1. Basic arena.\n2. Cathedral (HP+).\n3. Hell ( HP-).\n");

        System.out.print("PLAYER: ");
        int userInp = input.nextInt();

        switch (userInp) {
            case 1:
                arena = new Arena(0, 0);
                break;

            case 2:
                arena = new Arena(0, 5);
                break;

            case 3:
                arena = new Arena(5, 0);
                break;

            default:
                arena = new Arena(0, 0);
                break;
        }

        DuelController control = new DuelController(droid1, droid2, arena);
        Droid winner = control.startFight();

        System.out.println("--------------");
        System.out.println("The winner is " + winner.getName());

    }

    public void partyBatlle() throws InterruptedException, IOException {
        ArrayList<Droid> FT = new ArrayList<>();
        ArrayList<Droid> ST = new ArrayList<>();
        FT.add(getDroidByPlayer());
        FT.add(getDroidByPlayer());
        ST.add(getDroidByPlayer());
        ST.add(getDroidByPlayer());

        TeamVsTeamController control = new TeamVsTeamController(FT, ST, new Arena(0, 0));
        ArrayList<Droid> winnerTeam = control.startFight();

        System.out.println("--------------");
        System.out.println("The winner are: ");
        for (Droid droid : winnerTeam) {
            System.out.println(droid);
        }
    }

    public Droid getDroidByPlayer() {

        String botname;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your future droid name: ");
        botname = input.nextLine();
        System.out.printf("\nPick a hero:" +
                        "\n\t1.Droid(basic)." +
                        "\n\t2.Loki (THIEF / Crit and Dodge)." +
                        "\n\t3.Apolon (ARCHER / Dodge)." +
                        "\n\t4.Ares (Warior / Protection)."+
                        "\n\t5.Demetra (Priest / Healing spels).\n");
        System.out.print("PLAYER: ");
        int userInp = input.nextInt();

        int randomHP;
        int randomDMG;
        int randomCRIT;
        int randomACC;
        int randomDEX;
        int randomPROT;
        int randomHealStreng;

        switch (userInp) {
            case 1:
                randomHP = getRandomNumber(45, 65);
                randomDMG = getRandomNumber(12, 25);

                System.out.printf("\nYour generated bot:\n\t%s,\nHP: %d;\nDMG: %d;\n", botname, randomHP, randomDMG);

                return new Droid(botname, randomHP, randomDMG);

            case 2:
                randomHP = getRandomNumber(42, 60);
                randomDMG = getRandomNumber(15, 35);
                randomCRIT = getRandomNumber(10, 35);
                randomDEX = getRandomNumber(30, 65);

                System.out.printf("Your generated bot:\n\t%s,\nHP: %d;\nDMG: %d;\nCRIT: %d;\nDEX: %d;\n", botname,
                                    randomHP, randomDMG, randomCRIT, randomDEX);

                return new Loki(botname, randomHP, randomDMG, randomCRIT, randomDEX);

            case 3:
                randomHP = getRandomNumber(48, 62);
                randomDMG = getRandomNumber(15, 30);
                randomACC = getRandomNumber(65, 100);
                randomDEX = getRandomNumber(15, 30);

                System.out.printf("Your generated bot:\n\t%s,\nHP: %d;\nDMG: %d;\nACC: %d;\nDEX: %d;\n", botname,
                        randomHP, randomDMG, randomACC, randomDEX);

                return new Apolon(botname, randomHP, randomDMG, randomACC, randomDEX);

            case 4:
                randomHP = getRandomNumber(80, 150);
                randomDMG = getRandomNumber(20, 28);
                randomPROT = getRandomNumber(30, 80);
                System.out.printf("Your generated bot:\n\t%s,\nHP: %d;\nDMG: %d;\nPROT: %d;\n", botname, randomHP,
                        randomDMG, randomPROT);
                return new Ares(botname, randomHP, randomDMG, randomPROT);

            case 5:
                randomHP = getRandomNumber(50,75);
                randomDMG = getRandomNumber(15,30);
                randomHealStreng = getRandomNumber(20,35);
                System.out.printf("Your generated bot:\n\t%s,\nHP: %d;\nDMG: %d;\nHealSt: %d;\n\n", botname, randomHP,
                        randomDMG,randomHealStreng);
                return new Demetra(botname, randomHP, randomDMG, randomHealStreng);

            default:
                System.out.println("Wrong input!");
                return new Droid("BOT", 1, 1);
        }
    }

    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}
