package com.company;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        System.out.println("Cattle rValue = " + CSVReader.calcR("CattleData.csv") + " N0 = " + CSVReader.getN("CattleData.csv") + " \nDeer rValue = " + CSVReader.calcR("DeerData.csv") + " N0 = " + CSVReader.getN("DeerData.csv") + "\nHorse rValue = " + CSVReader.calcR("HorseData.csv") + " N0 = " + CSVReader.getN("HorseData.csv") + "\n\n");

        while (true) {

            System.out.print("Please choose a mathematical model: " +
                    "\n 1. Exponential Model" +
                    "\n 2. Logarithmic Model" +
                    "\n\n 9. Quit" + 
                    "\n\n Model: ");
            Scanner scanner = new Scanner(System.in);
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice == 1) {
                System.out.print("Please enter time t in months : ");

                int t = Integer.parseInt(scanner.nextLine());
                System.out.println("Cattle population after " + t + " month(s)  | " + ExpModel.calcExp(t , "CattleData.csv"));
                System.out.println("Deer population after " + t + " month(s)    | " + ExpModel.calcExp(t , "DeerData.csv"));
                System.out.println("Horse population after " + t + " month(s)   | " + ExpModel.calcExp(t , "HorseData.csv"));

            } else if (choice == 2) {
                System.out.print("Please enter time t in months : ");

                int t = Integer.parseInt(scanner.nextLine());
                System.out.println("Cattle population after " + t + " month(s)  | " + LogModel.calcLog(t , CSVReader.getN("CattleData.csv") , CSVReader.calcK("CattleData.csv") , CSVReader.calcR("CattleData.csv")));
                System.out.println("Deer population after " + t + " month(s)    | " + LogModel.calcLog(t , CSVReader.getN("DeerData.csv") , CSVReader.calcK("DeerData.csv") , CSVReader.calcR("DeerData.csv")));
                System.out.println("Horse population after " + t + " month(s)   | " + LogModel.calcLog(t , CSVReader.getN("HorseData.csv") , CSVReader.calcK("HorseData.csv") , CSVReader.calcR("HorseData.csv") ));
            
            }else if (choice == 3) {
                System.out.print("Please enter time t in months : ");

                int t = Integer.parseInt(scanner.nextLine());
                System.out.println("Cattle population after " + t + " month(s)  | " + ExpModel.calcExp2(t , CSVReader.getN("CattleData.csv"), CSVReader.calcR("CattleData.csv")));
                System.out.println("Deer population after " + t + " month(s)    | " + ExpModel.calcExp2(t , CSVReader.getN("DeerData.csv"), CSVReader.calcR("DeerData.csv")));
                System.out.println("Horse population after " + t + " month(s)   | " + ExpModel.calcExp2(t , CSVReader.getN("HorseData.csv") , CSVReader.calcR("HorseData.csv")));

            }else if (choice == 4) {
                System.out.print("Please enter time t in months : ");

                int t = Integer.parseInt(scanner.nextLine());
                System.out.println("Cattle population after " + t + " month(s)  | " + LogModel.calcLog2(t , CSVReader.getN("CattleData.csv") , CSVReader.calcK("CattleData.csv") , CSVReader.calcR("CattleData.csv")));
                System.out.println("Deer population after " + t + " month(s)    | " + LogModel.calcLog2(t , CSVReader.getN("DeerData.csv") , CSVReader.calcK("DeerData.csv") , CSVReader.calcR("DeerData.csv")));
                System.out.println("Horse population after " + t + " month(s)   | " + LogModel.calcLog2(t , CSVReader.getN("HorseData.csv") , CSVReader.calcK("HorseData.csv") , CSVReader.calcR("HorseData.csv")));
            
            }

            else if(choice == 9){
                System.exit(0);
            }
            else {
                System.out.println("Please enter a valid numeral option.");
            }
        }

    }
}
