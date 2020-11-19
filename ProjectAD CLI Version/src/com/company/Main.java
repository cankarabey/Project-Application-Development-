package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        System.out.println("Please enter r - Value , N zero and time : ");
        Scanner scanner = new Scanner(System.in);
        double r = Double.valueOf(scanner.nextLine());
        int n = Integer.parseInt(scanner.nextLine());
        int t = Integer.parseInt(scanner.nextLine());

        System.out.println("Deer population after t time : " + Model.calcDeer(r , n, t));


    }
}
