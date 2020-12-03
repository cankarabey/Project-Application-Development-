package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){

    	//test for Roberts

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
//else if (choice == 2) {
//System.out.println("Please enter time t in months : ");
//int t = Integer.parseInt(scanner.nextLine());
//System.out.println("Deer population after" + t + " time : " + LogModel.calcLog(t , LogModel.getnZeroDeer() , LogModel.getkDeer() , LogModel.getrDeer()));
//}
//else if (choice == 3) {
//System.out.println("Please enter time t in months : ");
//int t = Integer.parseInt(scanner.nextLine());
//System.out.println("Horse population after " + t + " month(s) : " + LogModel.calcLog(t , LogModel.getnZeroHorse() , LogModel.getkHorse() , LogModel.getrHorse()));
//
//}
