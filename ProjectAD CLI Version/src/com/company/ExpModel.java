package com.company;

import java.io.IOException;
import java.util.TreeMap;

public class ExpModel implements IModel {

    public static int calcExp(int t, String path) throws IOException {
    	return (int) (CSVReader.getN(path) * Math.pow(Math.E, (CSVReader.calcR(path) * t)));
    }
    
    static TreeMap<Integer, Integer> animals = new TreeMap<>();
    
    public static TreeMap<Integer,Integer> calcExp2(int t , int nZero, double r) {
    	for (int i = 1; i<=t; i++) {
    		animals.put(i, ((int) (nZero * Math.pow(Math.E, (r * i)))));
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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int calcK(int t) {
		// TODO Auto-generated method stub
		return 0;
	}




}
