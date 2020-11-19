package com.company;

public class Model {

    public static double calcDeer(double rValue , int nZero , int t){
        double result = 0;
        result = nZero * Math.pow(Math.E , (rValue * t));
        return result;
    }
}
