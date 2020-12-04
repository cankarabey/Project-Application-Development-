package com.company;

import java.util.TreeMap;

public class LogModel implements IModel {


    public static int calcLog(int t , int nZero , double k , double r){
        return (int) (k/(1 + ((k - nZero)/nZero)*Math.pow(Math.E , (-r * t))));
    }
    
    static TreeMap<Integer, Integer> animals = new TreeMap<>();
    
    public static TreeMap<Integer,Integer> calcLog2(int t , int nZero, double k, double r) {
    	for (int i = 1; i<=t; i++) {
    		animals.put(i, ((int) (k/(1 + ((k - nZero)/nZero)*Math.pow(Math.E , (-r * i))))));
    	}
    	return animals;
    }

	@Override
	public int calcR(int t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int calcNZero(int t) {
	int nZero = 0;
			return nZero;
	}

	@Override
	public int calcK(int t) {
		// TODO Auto-generated method stub
		return 0;
	}


}
