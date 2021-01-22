package com.company;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        System.out.println(CSVReader.PandFlist("CattleLifeTable.csv"));
        System.out.println(CSVReader.PandFlist("DeerLifeTable.csv"));
        System.out.println(CSVReader.PandFlist("HorseLifeTable.csv"));
        System.out.println(CSVReader.calcK("CattleData.csv"));
        System.out.println(CSVReader.calcK("DeerData.csv"));
        System.out.println(CSVReader.calcK("HorseData.csv"));

        
        int year = CSVReader.getYear("CattleData.csv");
        System.out.println(year);
        System.out.println("Cattle:\t rValue = " + CSVReader.calcR("CattleData.csv") + "\t N0 = " + CSVReader.getN("CattleData.csv") + 
        		"\nDeer:\t rValue = " + CSVReader.calcR("DeerData.csv") + "\t N0 = " + CSVReader.getN("DeerData.csv") + 
        		"\nHorse:\t rValue = " + CSVReader.calcR("HorseData.csv") + "\t N0 = " + CSVReader.getN("HorseData.csv") + "\n\n");

        while (true) {
            year = CSVReader.getYear("CattleData.csv");

            System.out.print("Please choose a mathematical model: " +
                    "\n 1. Exponential Model" +
                    "\n 2. Logarithmic Model" +
                    "\n 3. Age Structured Model" +
                    "\n 4. Competition Model" +
                    "\n 5. Predation Model" +
                    "\n 6. Grass annual mass" +
                    "\n\n 9. Quit" + 
                    "\n\nModel: ");
            Scanner scanner = new Scanner(System.in);
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice == 1) {
                ExpModel expModel = new ExpModel();
                System.out.print("Please enter time t in years : ");

                int t = Integer.parseInt(scanner.nextLine());
                System.out.println("Year |\tCattle|\tDeer |\tHorse");
                for (Integer key : expModel.calc(t , "CattleData.csv").keySet() ){
                    System.out.println(year + " | \t" + expModel.calc(t , "CattleData.csv").get(key) + 
                    		"   |\t" +  expModel.calc(t , "DeerData.csv").get(key) 
                    		+ " | \t" + expModel.calc(t , "HorseData.csv").get(key) );
                    year++;
                }
                System.out.println("-----------------------------");

            }else if (choice == 2) {
                System.out.print("Please enter time t in years : ");
                LogModel logModel = new LogModel();
                int t = Integer.parseInt(scanner.nextLine());
                System.out.println("Year |\tCattle|\tDeer |\tHorse");
                for (Integer key : logModel.calc(t , "CattleData.csv").keySet() ){
                    System.out.println(year + " | \t" + logModel.calc(t , "CattleData.csv").get(key) 
                    		+ "   |\t" +  logModel.calc(t , "DeerData.csv").get(key) 
                    		+ " | \t" + logModel.calc(t , "HorseData.csv").get(key) );
                    year++;
                }
                System.out.println("-----------------------------");
            }
            else if (choice == 3) {
                System.out.print("Please enter time t in years : ");
                AgeStructuredModel ageStructuredModel = new AgeStructuredModel();
                int t = Integer.parseInt(scanner.nextLine());
                System.out.println("Year |\tCattle|\tDeer |\tHorse");
                for (Integer key : ageStructuredModel.calc(t , "CattleData.csv").keySet() ){
                    System.out.println(year + " | \t" + ageStructuredModel.calc(t , "CattleData.csv").get(key)
                            + "   |\t" +  ageStructuredModel.calc(t , "DeerData.csv").get(key)
                            + " | \t" + ageStructuredModel.calc(t , "HorseData.csv").get(key) );
                    year++;
                }
                year = CSVReader.getYear("CattleData.csv");
                System.out.println("--------------Horse--------------");
                System.out.println("Year | Baby | Young | Adult | Old");
                for (int i = 0 ; i < t ; i++){
                    System.out.println(year + " | " + ageStructuredModel.showNumbersPerAgeGroup()[i][0] + "  | " + ageStructuredModel.showNumbersPerAgeGroup()[i][1] + "  | " + ageStructuredModel.showNumbersPerAgeGroup()[i][2] + "  | " + ageStructuredModel.showNumbersPerAgeGroup()[i][3]);
                    year++;
                }
                ageStructuredModel.calc(t ,"CattleData.csv");
                year = CSVReader.getYear("CattleData.csv");
                System.out.println("--------------Cattle--------------");
                System.out.println("Year | Baby | Young | Adult | Old");
                for (int i = 0 ; i < t ; i++){
                    System.out.println(year + " | " + ageStructuredModel.showNumbersPerAgeGroup()[i][0] + "   | " + ageStructuredModel.showNumbersPerAgeGroup()[i][1] + "   | " + ageStructuredModel.showNumbersPerAgeGroup()[i][2] + "    | " + ageStructuredModel.showNumbersPerAgeGroup()[i][3]);
                    year++;
                }
                ageStructuredModel.calc(t,"DeerData.csv");
                year = CSVReader.getYear("DeerData.csv");
                System.out.println("--------------Deer--------------");
                System.out.println("Year | Baby | Young | Adult | Old");
                for (int i = 0 ; i < t ; i++){
                    System.out.println(year + " | " + ageStructuredModel.showNumbersPerAgeGroup()[i][0] + "  | " + ageStructuredModel.showNumbersPerAgeGroup()[i][1] + "   | " + ageStructuredModel.showNumbersPerAgeGroup()[i][2] + "   | " + ageStructuredModel.showNumbersPerAgeGroup()[i][3]);
                    year++;
                }

                System.out.println("-----------------------------");
            }
            else if (choice == 4){
                System.out.print("Please enter time in t years : ");
                CompModel compModel = new CompModel();
                int t = Integer.parseInt(scanner.nextLine());
                System.out.println("Year |\tCattle|\tDeer |\tHorse");
                for (Integer key : compModel.calc(t , "CattleData.csv").keySet() ){
                    System.out.println(year + " | \t" + compModel.calc(t , "CattleData.csv").get(key)
                            + "   |\t" +  compModel.calc(t , "DeerData.csv").get(key)
                            + " | \t" + compModel.calc(t , "HorseData.csv").get(key) );
                    year++;
                }
                System.out.println("-----------------------------");
            }

            else if (choice == 5){
                System.out.print("Please enter time in t years : ");
                PredationModel predationModel = new PredationModel();
                int t = Integer.parseInt(scanner.nextLine());
                System.out.println("Year |\tCattle|\tDeer |\tHorse \t| Wolves");
                for (Integer key : predationModel.calc(t , "CattleData.csv").keySet() ){
                    System.out.println(year + " | \t" + predationModel.calc(t , "CattleData.csv").get(key)
                            + "   |\t" +  predationModel.calc(t , "DeerData.csv").get(key)
                            + " | \t" + predationModel.calc(t , "HorseData.csv").get(key)
                            + " \t| " + predationModel.wolfs);
                    year++;
                }
                System.out.println("-----------------------------");
            }

            else if (choice == 6) {
                System.out.print("Please enter time in t years : ");
                GrassModel grassModel = new GrassModel();
                int t = Integer.parseInt(scanner.nextLine());
                System.out.println("Year |\tGrass in kg");
                for (Integer key : grassModel.getGrass(t , "GrassData.csv").keySet() ){
                    System.out.println(year + " | \t" + grassModel.getGrass(t , "GrassData.csv").get(key) + "KG");
                    year++;
                }
                System.out.println("-----------------------------");
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
