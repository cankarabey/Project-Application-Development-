package com.company;

public class Model {

    private static final double rCattle = 0.001900165;
    private static final double rHorse = 0.025769117;
    private static final double rDeer = 0.029899109;
    private static final int nZeroCattle = 293;
    private static final int nZeroHorse = 964;
    private static final int nZeroDeer = 1845;
    // cattle r = 0,001900165 n0 2010 = 293
    // horse r = 0,025769117 n0 2010 = 964
    // deer r = 0,029899109 m0 2010 = 1845

    public static double calcDeer(int t){
        double result;
        result = nZeroDeer * Math.pow(Math.E , (rDeer * t));
        return result;
    }

    public static double calcHorse( int t){
        double result;
        result = nZeroHorse * Math.pow(Math.E , (rHorse * t));
        return result;
    }

    public static double calcCattle(int t){
        double result;
        result = nZeroCattle * Math.pow(Math.E , (rCattle * t));
        return result;
    }




}
