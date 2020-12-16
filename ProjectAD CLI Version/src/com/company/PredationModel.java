package com.company;

import java.io.IOException;
import java.util.TreeMap;

public class PredationModel implements IModel {
    static TreeMap<Integer, Integer> animals = new TreeMap<>();

    @Override
    public TreeMap<Integer, Integer> calc(int t, String path) throws IOException {
        if (path == "DeerData.csv") {
            int N0 = CSVReader.getN(path);
            // int NWolfs = CSVReader.getN("Wolfs.cvs");
            int amountOfWolfs = 1;
            double hDeer = 0.0243;
            double D = 1;
            for (int i = 1; i <= t; i++) {
                int V = (int) (CSVReader.calcR(path) * CSVReader.getN(path) * 1 - (((1 / hDeer * (CSVReader.getN(path) ^ 2))) / ((CSVReader.getN(path) ^ 2) + D)) * amountOfWolfs * 1);
                animals.put(i, V);
                N0 = V;
            }
            return animals;
        }
        else if (path == "HorseData.csv"){
            int N0 = CSVReader.getN(path);
            // int NWolfs = CSVReader.getN("Wolfs.cvs");
            int amountOfWolfs = 1;
            double hHorse = 0.21;
            double D = 1;
            for (int i = 1; i <= t; i++) {
                int V = (int) (CSVReader.calcR(path) * CSVReader.getN(path) * 1 - (((1 / hHorse * (CSVReader.getN(path) ^ 2))) / ((CSVReader.getN(path) ^ 2) + D)) * amountOfWolfs * 1);
                animals.put(i, V);
                N0 = V;
            }
            return animals;
        }
        else if (path == "CattleData.cvs"){
            int N0 = CSVReader.getN(path);
            // int NWolfs = CSVReader.getN("Wolfs.cvs");
            int amountOfWolfs = 1;
            double hCattle = 0.366;
            double D = 1;
            for (int i = 1; i <= t; i++) {
                int V = (int) (CSVReader.calcR(path) * CSVReader.getN(path) * 1 - (((1 / hCattle * (CSVReader.getN(path) ^ 2))) / ((CSVReader.getN(path) ^ 2) + D)) * amountOfWolfs * 1);
                animals.put(i, V);
                N0 = V;
            }
            return animals;
        }

        else {
            System.out.println("Something is wrong :( ");
            return null;
        }
    }

    //V= rVt-(kV^2/(V^2+D^2))pt
    //p=(BV-q)pt
}
