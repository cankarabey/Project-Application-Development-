package com.company;

public class LogModel {

    private static final double rCattle = 0.001900165;
    private static final double rHorse = 0.025769117;
    private static final double rDeer = 0.029899109;
    private static final int nZeroCattle = 293;
    private static final int nZeroHorse = 964;
    private static final int nZeroDeer = 1845;
    private static final double kCattle = 121.93;
    private static final double kHorse = 2929.261;
    private static final double kDeer = -1766.52;


    public static int calcDeer(int t){
        return (int) (kDeer/(1 + ((kDeer - nZeroDeer)/nZeroDeer)*Math.pow(Math.E , (-rDeer * t))));
    }

    public static int calcCattle(int t){
        return (int) (kCattle/(1 + ((kCattle - nZeroCattle)/nZeroCattle)*Math.pow(Math.E , (-rCattle * t))));
    }

    public static int calcHorse(int t){
        return (int) (kHorse/(1 + ((kHorse - nZeroHorse)/nZeroHorse)*Math.pow(Math.E , (-rHorse * t))));
    }

}
