package com.company;

import java.io.IOException;
import java.util.TreeMap;

public class ExpModel implements IModel {

	/*
    public static int calcExp(int t, String path) throws IOException {
    	return (int) (CSVReader.getN(path) * Math.pow(Math.E, (CSVReader.calcR(path) * t)));
    }
	 */
    
    static TreeMap<Integer, Integer> animals = new TreeMap<>();
    
    public static TreeMap<Integer,Integer> calcExp(int t ,String path) throws IOException {
    	for (int i = 1; i<=t; i++) {
    		animals.put(i, (int) (CSVReader.getN(path) * Math.pow(Math.E, (CSVReader.calcR(path) * i))));
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

	@Override
	public void calculate(int t, String path) throws IOException {
		System.out.println( (int) (CSVReader.getN(path) * Math.pow(Math.E, (CSVReader.calcR(path) * t))));
	}
}
