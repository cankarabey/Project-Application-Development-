package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        while (true) {

            System.out.println("Please choose the type of animal : " +
                    "\n 1. Cattle" +
                    "\n 2. Deer" +
                    "\n 3. Horse");
            Scanner scanner = new Scanner(System.in);
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice == 1) {
                System.out.println("Please enter r - Value , N zero and time : ");
                double r = Double.valueOf(scanner.nextLine());
                int n = Integer.parseInt(scanner.nextLine());
                int t = Integer.parseInt(scanner.nextLine());

                System.out.println("Deer population after t time : " + Model.calcCattle(r, n, t));

            } else if (choice == 2) {
                System.out.println("Please enter r - Value , N zero and time : ");
                double r = Double.valueOf(scanner.nextLine());
                int n = Integer.parseInt(scanner.nextLine());
                int t = Integer.parseInt(scanner.nextLine());

                System.out.println("Deer population after t time : " + Model.calcDeer(r, n, t));
            } else if (choice == 3) {
                System.out.println("Please enter r - Value , N zero and time : ");
                double r = Double.valueOf(scanner.nextLine());
                int n = Integer.parseInt(scanner.nextLine());
                int t = Integer.parseInt(scanner.nextLine());

                System.out.println("Deer population after t time : " + Model.calcHorse(r, n, t));
            } else {
                System.out.println("Please enter a number between 1 and 3!");
            }
        }

    }
}
