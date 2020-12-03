package com.company;

public class LogModel implements IModel {

    private static final double rCattle = 0.001900165;
    private static final double rHorse = 0.025769117;
    private static final double rDeer = 0.029899109;
    private static final int nZeroCattle = 293;
    private static final int nZeroHorse = 964;
    private static final int nZeroDeer = 1845;
    private static final double kCattle = 121.93;
    private static final double kHorse = 2929.261;
    private static final double kDeer = -1766.52;


    public static int calcLog(int t , int nZero , double k , double r){
        return (int) (k/(1 + ((k - nZero)/nZero)*Math.pow(Math.E , (-r * t))));
    }

    public static double getrCattle() {
        return rCattle;
    }

    public static double getrHorse() {
        return rHorse;
    }

    public static double getrDeer() {
        return rDeer;
    }

    public static int getnZeroCattle() {
        return nZeroCattle;
    }

    public static int getnZeroHorse() {
        return nZeroHorse;
    }

    public static int getnZeroDeer() {
        return nZeroDeer;
    }

    public static double getkCattle() {
        return kCattle;
    }

    public static double getkHorse() {
        return kHorse;
    }

    public static double getkDeer() {
        return kDeer;
    }

	@Override
	public int calcR(int t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int calcNZero(int t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int calcK(int t) {
		// TODO Auto-generated method stub
		return 0;
	}


}
