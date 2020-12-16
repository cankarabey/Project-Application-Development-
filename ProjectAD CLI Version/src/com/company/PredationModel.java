package com.company;

import java.io.IOException;
import java.util.TreeMap;

public class PredationModel implements IModel {
    static TreeMap<Integer, Integer> animals = new TreeMap<>();

    @Override
    public TreeMap<Integer, Integer> calc(int t, String path) throws IOException {
        int N0 = CSVReader.getN(path);
        double h = 0.01685;
        double D = 88052.197;
        int ammountOfWolfs = 1;
        for (int i = 1; i<=t; i++) {
            int V =  (int) (CSVReader.calcR(path)*CSVReader.getN(path)*1 - (((1/h * (CSVReader.getN(path)^2)))/((CSVReader.getN(path)^2) + D))*ammountOfWolfs*1);
            animals.put(i, V );
            N0 = animals.get(i);
        }
        return animals;
    }

    //V= rVt-(kV^2/(V^2+D^2))pt
    //p=(BV-q)pt
}
