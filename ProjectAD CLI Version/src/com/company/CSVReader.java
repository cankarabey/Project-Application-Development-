package com.company;

import org.apache.commons.csv.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;


public class CSVReader {

    public static double calcR(String path) throws IOException {

        BufferedReader reader = Files.newBufferedReader(Paths.get(path));
        CSVParser csvParser = new CSVParser(reader , CSVFormat.DEFAULT.withFirstRecordAsHeader());
        ArrayList<Double> birthsPerCapita = new ArrayList<>();
        ArrayList<Double> deathsPerCapita = new ArrayList<>();
        ArrayList<Double> rValues = new ArrayList<>();

        for( CSVRecord csv : csvParser){
            birthsPerCapita.add(Double.parseDouble(csv.get(2)) / Double.parseDouble(csv.get(1)));
            deathsPerCapita.add(Double.parseDouble(csv.get(3)) / Double.parseDouble(csv.get(1)));
        }

        for (int i = 0; i < birthsPerCapita.size() ; i++) {
            rValues.add(birthsPerCapita.get(i) - deathsPerCapita.get(i));
        }

        double rAvg = 0;
        for (double d : rValues){
            rAvg += d;
        }
        rAvg = rAvg/rValues.size();

        return rAvg;

    }
}
