package com.company;

import org.apache.commons.csv.*;

import java.awt.print.PrinterGraphics;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class CSVReader {

    static ArrayList[] calcValues(String path) throws IOException {

        ArrayList[] arrayLists = new ArrayList[6];

        BufferedReader reader = new BufferedReader(new FileReader("src/" + path));

        CSVParser csvParser = new CSVParser(reader , CSVFormat.DEFAULT.withFirstRecordAsHeader());
        ArrayList<Double> birthsPerCapita = new ArrayList<>();
        ArrayList<Double> deathsPerCapita = new ArrayList<>();
        ArrayList<Double> rValues = new ArrayList<>();
        ArrayList<Integer> totalNumber = new ArrayList<>();
        ArrayList<Integer> years = new ArrayList<>();
        ArrayList<Integer> births = new ArrayList<>();

        for( CSVRecord csv : csvParser){
            birthsPerCapita.add(Double.parseDouble(csv.get(2)) / Double.parseDouble(csv.get(1)));
            deathsPerCapita.add(Double.parseDouble(csv.get(3)) / Double.parseDouble(csv.get(1)));
            totalNumber.add(Integer.parseInt(csv.get(1)));
            years.add(Integer.parseInt(csv.get(0)));
            births.add(Integer.parseInt(csv.get(2)));
        }

        for (int i = 0; i < birthsPerCapita.size() ; i++) {
            rValues.add(birthsPerCapita.get(i) - deathsPerCapita.get(i));
        }

        arrayLists[0] = birthsPerCapita;
        arrayLists[1] = deathsPerCapita;
        arrayLists[2] = rValues;
        arrayLists[3] = totalNumber;
        arrayLists[4] = years;
        arrayLists[5] = births;

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

    public static int getN(String path) throws IOException {
        ArrayList[] arrayLists = calcValues(path);
        ArrayList<Integer> totalN = arrayLists[3];

        return totalN.get(totalN.size() - 1);
    }

    public static double getAlpha(String path) throws IOException{
        ArrayList[] arrayLists = calcValues(path);
        ArrayList<Integer> totalNumbers = arrayLists[3];
        if (path.equals("CattleData.csv")) {
            double deltaN = (totalNumbers.get(totalNumbers.size() - 1) - totalNumbers.get(totalNumbers.size()-6)) / 6;
            return ((calcK(path)/getN("HorseData.csv")) - (getN(path)/getN("HorseData.csv")) - ((deltaN*calcK(path))/(getN(path)*calcR(path)*getN("HorseData.csv"))));
        }
        else if (path.equals("HorseData.csv")){
            double deltaN = (totalNumbers.get(totalNumbers.size() - 1) - totalNumbers.get(totalNumbers.size()-6)) / 6;
            return ((calcK(path)/getN("CattleData.csv")) - (getN(path)/getN("CattleData.csv")) - ((deltaN*calcK(path))/(getN(path)*calcR(path)*getN("CattleData.csv"))));
        }
        else if (path.equals("DeerData.csv")){
            double deltaN = (totalNumbers.get(totalNumbers.size() - 1) - totalNumbers.get(totalNumbers.size()-6)) / 6;
            return ((calcK(path)/getN("HorseCattleAvgData.csv")) - (getN(path)/getN("HorseCattleAvgData.csv")) - ((deltaN*calcK(path))/(getN(path)*calcR(path)*getN("HorseCattleAvgData.csv"))));
        }
        else {
            System.out.println("Something went wrong.");
            return 0;
        }
    }

    public static int getYear(String path) throws IOException {
        ArrayList[] arrayLists = calcValues(path);
        ArrayList<Integer> years = arrayLists[4];
        return years.get(years.size() - 1);
    }
    

    public static List PandFlist(String path) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader("src/" + path));
        CSVParser csvParser = new CSVParser(reader , CSVFormat.DEFAULT.withFirstRecordAsHeader());
        ArrayList<ArrayList<Double>> values = new ArrayList<ArrayList<Double>>();
        values.add(new ArrayList<Double>());
        values.add(new ArrayList<Double>());
        for( CSVRecord csv : csvParser){
            values.get(0).add(Double.parseDouble(csv.get(1)));
            values.get(1).add(Double.parseDouble(csv.get(1)) * Double.parseDouble(csv.get(0)));
        }
        return values;
    }

    public static int getBirths(String path) throws IOException {
        ArrayList[] arrayLists = calcValues(path);
        ArrayList<Integer> births = arrayLists[5];
        return births.get(births.size() - 2);
    }
}
