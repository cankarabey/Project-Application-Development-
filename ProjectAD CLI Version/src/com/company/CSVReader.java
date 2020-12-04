package com.company;

import org.apache.commons.csv.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;


public class CSVReader {

    static ArrayList[] calcValues(String path) throws IOException {

        ArrayList[] arrayLists = new ArrayList[4];

        BufferedReader reader = new BufferedReader(new FileReader("src/" + path));

        CSVParser csvParser = new CSVParser(reader , CSVFormat.DEFAULT.withFirstRecordAsHeader());
        ArrayList<Double> birthsPerCapita = new ArrayList<>();
        ArrayList<Double> deathsPerCapita = new ArrayList<>();
        ArrayList<Double> rValues = new ArrayList<>();
        ArrayList<Integer> totalNumber = new ArrayList<>();

        for( CSVRecord csv : csvParser){
            birthsPerCapita.add(Double.parseDouble(csv.get(2)) / Double.parseDouble(csv.get(1)));
            deathsPerCapita.add(Double.parseDouble(csv.get(3)) / Double.parseDouble(csv.get(1)));
            totalNumber.add(Integer.parseInt(csv.get(1)));
        }

        for (int i = 0; i < birthsPerCapita.size() ; i++) {
            rValues.add(birthsPerCapita.get(i) - deathsPerCapita.get(i));
        }

        arrayLists[0] = birthsPerCapita;
        arrayLists[1] = deathsPerCapita;
        arrayLists[2] = rValues;
        arrayLists[3] = totalNumber;

        return arrayLists;
    }

    public static double calcR(String path) throws IOException {

        ArrayList[] arrayLists = calcValues(path);
        ArrayList<Double> rValues = arrayLists[2];

        double rAvg = 0;
        for (double d : rValues){
            rAvg += d;
        }
        rAvg = rAvg/rValues.size();

        return rAvg;

    }

    public static double calcK(String path) throws IOException {

        ArrayList[] arrayLists = calcValues(path);
        ArrayList<Double> rValues = arrayLists[2];
        ArrayList<Integer> totalN = arrayLists[3];
        ArrayList<Double> kValues = new ArrayList<>();

        for (int i = 0; i < totalN.size() - 1; i++) {
            double k = (rValues.get(i) * totalN.get(i) * (1 - totalN.get(i))) / (totalN.get(i) - totalN.get(i + 1));
            if (!Double.isNaN(k) && !Double.isInfinite(k)){
                kValues.add(k);
            }
        }

        double kAvg = 0;
        for (int i = 0; i < kValues.size(); i++) {
            kAvg += kValues.get(i);
        }

        kAvg = kAvg/kValues.size();

        return kAvg;
    }
    public static int getN0(String path) {
        ArrayList[] arrayLists = calcValues(path);
        ArrayList<Integer> totalN = arrayLists[3];

        return totalN.get(totalN.size() - 1);
    }
}
