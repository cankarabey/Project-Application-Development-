package com.company;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        
        int year = CSVReader.getYear("CattleData.csv");
        System.out.println(year);
        System.out.println("Cattle rValue = " + CSVReader.calcR("CattleData.csv") + " N0 = " + CSVReader.getN("CattleData.csv") + " \nDeer rValue = " + CSVReader.calcR("DeerData.csv") + " N0 = " + CSVReader.getN("DeerData.csv") + "\nHorse rValue = " + CSVReader.calcR("HorseData.csv") + " N0 = " + CSVReader.getN("HorseData.csv") + "\n\n");

        while (true) {
            year = CSVReader.getYear("CattleData.csv");

            System.out.print("Please choose a mathematical model: " +
                    "\n 1. Exponential Model" +
                    "\n 2. Logarithmic Model" +
                    "\n\n 9. Quit" + 
                    "\n\n Model: ");
            Scanner scanner = new Scanner(System.in);
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice == 1) {
                ExpModel expModel = new ExpModel();
                System.out.print("Please enter time t in years : ");

                int t = Integer.parseInt(scanner.nextLine());
                System.out.println("Year |Cattle|Deer |Horse");
                for (Integer key : expModel.calc(t , "CattleData.csv").keySet() ){
                    System.out.println(year + " | " + expModel.calc(t , "CattleData.csv").get(key) + " | " +  expModel.calc(t , "DeerData.csv").get(key) + " | " + expModel.calc(t , "HorseData.csv").get(key) );
                    year++;
                }

            }else if (choice == 2) {
                System.out.print("Please enter time t in years : ");
                LogModel logModel = new LogModel();
                int t = Integer.parseInt(scanner.nextLine());
                System.out.println("Year |Cattle|Deer |Horse");
                for (Integer key : logModel.calc(t , "CattleData.csv").keySet() ){
                    System.out.println(year + " | " + logModel.calc(t , "CattleData.csv").get(key) + " | " +  logModel.calc(t , "DeerData.csv").get(key) + " | " + logModel.calc(t , "HorseData.csv").get(key) );
                    year++;
                }
            
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
