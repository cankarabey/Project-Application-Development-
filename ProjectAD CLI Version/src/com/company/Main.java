package com.company;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        System.out.println(CSVReader.calcR("/Users/can/Downloads/CattleData.csv"));
        System.out.println(CSVReader.calcK("/Users/can/Downloads/CattleData.csv"));

        System.out.println("Cattle:\t r = 0,001900165 n0 2010 = 293\nHorse\t r = 0,025769117 n0 2010 = 964\nDeer:\t r = 0,029899109 n0 2010 = 1845\n");

        while (true) {

            System.out.print("Please choose a mathimatical model: " +
                    "\n 1. Exponential Model" +
                    "\n 2. Logarithmic Model" +
                    "\n\n 9. Quit" + 
                    "\n\n Model: ");
            Scanner scanner = new Scanner(System.in);
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice == 1) {
                System.out.print("Please enter time t in months : ");

                int t = Integer.parseInt(scanner.nextLine());
                System.out.println("Cattle population after " + t + " month(s)  | " + ExpModel.calcExp(t , ExpModel.getnZeroCattle(), ExpModel.getrCattle()));
                System.out.println("Deer population after " + t + " month(s)    | " + ExpModel.calcExp(t , LogModel.getnZeroDeer(), ExpModel.getrDeer()));
                System.out.println("Horse population after " + t + " month(s)   | " + ExpModel.calcExp(t , LogModel.getnZeroHorse() , ExpModel.getrHorse()) + "\n");

            } else if (choice == 2) {
                System.out.print("Please enter time t in months : ");

                int t = Integer.parseInt(scanner.nextLine());
                System.out.println("Cattle population after " + t + " month(s)  | " + LogModel.calcLog(t , LogModel.getnZeroCattle() , LogModel.getkCattle() , LogModel.getrCattle()));
                System.out.println("Deer population after " + t + " month(s)    | " + LogModel.calcLog(t , LogModel.getnZeroDeer() , LogModel.getkDeer() , LogModel.getrDeer()));
                System.out.println("Horse population after " + t + " month(s)   | " + LogModel.calcLog(t , LogModel.getnZeroHorse() , LogModel.getkHorse() , LogModel.getrHorse()) + "\n");
            
            }else if (choice == 3) {
                System.out.print("Please enter time t in months : ");

                int t = Integer.parseInt(scanner.nextLine());
                System.out.println("Cattle population after " + t + " month(s)  | " + ExpModel.calcExp2(t , ExpModel.getnZeroCattle(), ExpModel.getrCattle()));
                System.out.println("Deer population after " + t + " month(s)    | " + ExpModel.calcExp2(t , LogModel.getnZeroDeer(), ExpModel.getrDeer()));
                System.out.println("Horse population after " + t + " month(s)   | " + ExpModel.calcExp2(t , LogModel.getnZeroHorse() , ExpModel.getrHorse()) + "\n");

            }else if (choice == 4) {
                System.out.print("Please enter time t in months : ");

                int t = Integer.parseInt(scanner.nextLine());
                System.out.println("Cattle population after " + t + " month(s)  | " + LogModel.calcLog2(t , LogModel.getnZeroCattle() , LogModel.getkCattle() , LogModel.getrCattle()));
                System.out.println("Deer population after " + t + " month(s)    | " + LogModel.calcLog2(t , LogModel.getnZeroDeer() , LogModel.getkDeer() , LogModel.getrDeer()));
                System.out.println("Horse population after " + t + " month(s)   | " + LogModel.calcLog2(t , LogModel.getnZeroHorse() , LogModel.getkHorse() , LogModel.getrHorse()) + "\n");
            
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
