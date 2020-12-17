package com.company;

import java.io.IOException;
import java.util.TreeMap;

public class CompModel implements IModel {

    static TreeMap<Integer, Integer> animals = new TreeMap<>();

    @Override
    public TreeMap<Integer, Integer> calc(int t, String path) throws IOException {
        if (path == "CattleData.csv"){
            double alpha = 1.5;
            int nOne = CSVReader.getN(path);
            int nTwo = CSVReader.getN("HorseData.csv");
            double r1 = CSVReader.calcR(path);
            double k1 = CSVReader.calcK(path);
            for (int x = 0 ; x < t ; x++){
                int prediction = (int) (nOne*(1+r1 * ( 1 - (nOne+alpha*nTwo)/k1)));
                animals.put(x , prediction);
                nOne = prediction;
            }
            return animals;
        }
        else if (path == "HorseData.csv"){
            double alpha = 0.5;
            int nOne = CSVReader.getN(path);
            int nTwo = CSVReader.getN("CattleData.csv");
            double r1 = CSVReader.calcR(path);
            double k1 = CSVReader.calcK(path);
            for (int x = 0 ; x < t ; x++){
                int prediction = (int) (nOne*(1+r1 * (1 - (nOne+alpha*nTwo)/k1)));
                animals.put(x , prediction);
                nOne = prediction;
            }
            return animals;
        }
        else if (path == "DeerData.csv"){
            double alpha = 0.3;
            int nOne = CSVReader.getN(path);
            int nTwo = CSVReader.getN("HorseCattleAvgData.csv");
            double r1 = CSVReader.calcR(path);
            double k1 = CSVReader.calcK(path);
            for (int x = 0 ; x < t ; x++){
                int prediction = (int) (nOne*(1+r1 * (1 - (nOne+alpha*nTwo)/k1)));
                animals.put(x , prediction);
                nOne = prediction;
            }
            return animals;
        }
        else{
            System.out.println("Something is wrong :( ");
            return null;
        }
    }
}
