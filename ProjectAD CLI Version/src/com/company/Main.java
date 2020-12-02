package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){


        System.out.println("Cattle:\t r = 0,001900165 n0 2010 = 293\nHorse\t r = 0,025769117 n0 2010 = 964\nDeer:\t r = 0,029899109 n0 2010 = 1845\n");

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
                System.out.println("Cattle population after " + t + " month(s): " + LogModel.calc(t , LogModel.getnZeroCattle() , LogModel.getkCattle() , LogModel.getrCattle()));

            }
            else if (choice == 2) {
                System.out.println("Please enter time t in months : ");
                int t = Integer.parseInt(scanner.nextLine());
                System.out.println("Deer population after" + t + " time : " + LogModel.calc(t , LogModel.getnZeroDeer() , LogModel.getkDeer() , LogModel.getrDeer()));
            }
            else if (choice == 3) {
                System.out.println("Please enter time t in months : ");
                int t = Integer.parseInt(scanner.nextLine());
                System.out.println("Horse population after " + t + " month(s) : " + LogModel.calc(t , LogModel.getnZeroHorse() , LogModel.getkHorse() , LogModel.getrHorse()));

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
