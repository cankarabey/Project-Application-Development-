package Model;

import sample.Controllers.importDataScreenController;
import util.CSVReader;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

public class AgeStructuredModel implements IModel {

    static TreeMap<Integer, Integer> animals = new TreeMap<>();
    private static int[][] numbersByAgeGroup;

    @Override
    public TreeMap<Integer, Integer> calc(int t, String path) throws IOException {
        HashMap<String, File> map = importDataScreenController.getFiles();
        ArrayList<Double> pValues = (ArrayList<Double>) CSVReader.PandFlist(map.get(path)).get(0);
        ArrayList<Double> fValues = (ArrayList<Double>) CSVReader.PandFlist(map.get(path)).get(1);
        numbersByAgeGroup = new int[t][4];
        int birthsLastYear = CSVReader.getBirths(map.get(path));
        int ageGroupOne = birthsLastYear;
        int ageGroupTwo = (int) (birthsLastYear * pValues.get(0));
        int ageGroupThree = (int) (ageGroupTwo * pValues.get(1));
        int ageGroupFour = (int) (ageGroupThree * pValues.get(2));

        for (int i = 0 ; i < t ; i++) {
            ageGroupFour = (int) (ageGroupThree * pValues.get(2));
            ageGroupThree = (int) (ageGroupTwo * pValues.get(1));
            ageGroupTwo = (int) (ageGroupOne * pValues.get(0));
            ageGroupOne = (int) ((fValues.get(0) * ageGroupOne) + (fValues.get(1) * ageGroupTwo) + (fValues.get(2) * ageGroupThree) + (fValues.get(3) * ageGroupFour));
            int total = ageGroupOne + ageGroupTwo + ageGroupThree + ageGroupFour;
            animals.put(i , total);
            numbersByAgeGroup[i] = new int[]{ageGroupOne, ageGroupTwo, ageGroupThree, ageGroupFour};
        }
        return animals;
    }

    public int[][] showNumbersPerAgeGroup(){
        return numbersByAgeGroup;
    }


}
