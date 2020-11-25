package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        System.out.println("Cattle r = 0,001900165 n0 2010 = 293\nHorse r = 0,025769117 n0 2010 = 964\nDeer r = 0,029899109 n0 2010 = 1845");

        while (true) {

            System.out.println("Please choose the type of animal : " +
                    "\n 1. Cattle" +
                    "\n 2. Deer" +
                    "\n 3. Horse" +
                    "\n\n 9. Quit");
            Scanner scanner = new Scanner(System.in);
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice == 1) {
                System.out.println("Please enter time t in months : ");

                int t = Integer.parseInt(scanner.nextLine());
                System.out.println("Cattle population after " + t + " month(s): "+ LogModel.calcCattle(t));

            }
            else if (choice == 2) {
                System.out.println("Please enter time t in months : ");
                int t = Integer.parseInt(scanner.nextLine());
                System.out.println("Deer population after" + t + " time : " + LogModel.calcDeer(t));
                System.out.println("Deer population after " + t + " time : " + ExpModel.calcDeer(t));
            }
            else if (choice == 3) {
                System.out.println("Please enter time t in months : ");
                int t = Integer.parseInt(scanner.nextLine());
                System.out.println("Horse population after " + t + " month(s) : " + LogModel.calcHorse(t));

            }
            else if(choice == 9){
                System.exit(0);
            }
            else {
                System.out.println("Please enter a number between 1 and 3!");
            }
        }

    }
}
