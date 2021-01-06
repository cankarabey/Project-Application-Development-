package com.company;

import java.io.IOException;
import java.util.TreeMap;

public class GrassModel {
    static TreeMap<Integer, String> grass = new TreeMap<>();

    public static TreeMap<Integer, String> getGrass(int t, String path) throws IOException{
        Double GP = CSVReader.getGrowthPotential(path);
        int temp0 = 20;
        int avgTemp = 10;
        for (int i = 0 ; i <= t; i++) {
            Double GrowthPotential = Math.pow(Math.E, -0.5 * Math.pow(((temp0-avgTemp)/GP), 2)) * 60 * 5600;
            grass.put(2014 + i, String.format("%.2f", GrowthPotential));
            GP = GP - 0.55;
        }
        return grass;
    }
}