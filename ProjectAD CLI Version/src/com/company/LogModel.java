package com.company;

import java.io.IOException;
import java.util.TreeMap;

public class LogModel implements IModel {


    public static int calcLog(int t , String path) throws IOException {
        return (int) (CSVReader.calcK(path)/(1 + ((CSVReader.calcK(path) - CSVReader.getN(path))/CSVReader.getN(path))*Math.pow(Math.E , (-CSVReader.calcR(path) * t))));
    }
    
    static TreeMap<Integer, Integer> animals = new TreeMap<>();
    
    public static TreeMap<Integer,Integer> calcLog2(int t , String path) throws IOException {
    	for (int i = 1; i<=t; i++) {
    		animals.put(i, ((int) (CSVReader.calcK(path)/(1 + ((CSVReader.calcK(path) - CSVReader.getN(path))/CSVReader.getN(path))*Math.pow(Math.E , (-CSVReader.calcR(path) * i))))));
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
