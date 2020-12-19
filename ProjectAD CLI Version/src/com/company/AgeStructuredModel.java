package com.company;

import java.io.IOException;
import java.util.TreeMap;

public class AgeStructuredModel implements IModel {

    static TreeMap<Integer, Integer> animals = new TreeMap<>();

    @Override
    public TreeMap<Integer, Integer> calc(int t, String path) throws IOException {
        //double[][] values = CSVReader.getFandPValues(path);
        int birthsLastYear = CSVReader.getBirths(path);
        double[][] values = new double[2][4];
        values[0][0] = 0.95;
        values[0][1] = 0.70;
        values[0][2] = 0.75;
        values[0][3] = 0.0;                 //these can be deleted when the csv reader is fixed
        values[1][0] = 0.0 * 0.95;
        values[1][1] = 1.05 * 0.70;
        values[1][2] = 1.0 * 0.75;
        values[1][3] = 0.9 * 0.0;
        int ageGroupOne = birthsLastYear;
        int ageGroupTwo = (int) (birthsLastYear * values[0][0]);
        int ageGroupThree = (int) (ageGroupTwo * values[0][1]);
        int ageGroupFour = (int) (ageGroupThree * values[0][2]);

        for (int i = 0 ; i < t ; i++) {
            ageGroupFour = (int) (ageGroupThree * values[0][2]);
            ageGroupThree = (int) (ageGroupTwo * values[0][1]);
            ageGroupTwo = (int) (ageGroupOne * values[0][0]);
            ageGroupOne = (int) ((values[1][0] * ageGroupOne) + (values[1][1] * ageGroupTwo) + (values[1][2] * ageGroupThree) + (values[1][3] * ageGroupFour));
            int total = ageGroupOne + ageGroupTwo + ageGroupThree + ageGroupFour;
            animals.put(i , total);
        }
        return animals;
    }


}
