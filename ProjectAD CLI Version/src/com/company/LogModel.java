package com.company;

import java.io.IOException;
import java.util.TreeMap;

public class LogModel implements IModel {

    static TreeMap<Integer, Integer> animals = new TreeMap<>();
    
    public static TreeMap<Integer,Integer> calcLog(int t , String path) throws IOException {
    	int N0 = CSVReader.getN(path);
    	for (int i = 1; i<=t; i++) {
    		animals.put(i, ((int) (CSVReader.calcK(path)/(1 + ((CSVReader.calcK(path) - N0)/N0)*Math.pow(Math.E , (-CSVReader.calcR(path) * 1))))));
    		N0 = animals.get(i);
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

	@Override
	public void calculate(int t, String path) throws IOException {
		System.out.println( (int) (CSVReader.calcK(path)/(1 + ((CSVReader.calcK(path) - CSVReader.getN(path))/CSVReader.getN(path))*Math.pow(Math.E , (-CSVReader.calcR(path) * t)))));
	}
}
