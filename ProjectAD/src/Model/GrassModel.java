package Model;

import sample.Controllers.importDataScreenController;
import util.CSVReader;

import java.io.IOException;
import java.util.TreeMap;

public class GrassModel {
    static TreeMap<Integer, Double> grass = new TreeMap<>();

    public static TreeMap<Integer, Double> getGrass(int t, String path) throws IOException{
        Double GP = CSVReader.getGrowthPotential(importDataScreenController.getFiles().get("CattleData"));
        int temp0 = 20;
        int avgTemp = 10;
        for (int i = 0 ; i <= t; i++) {
            Double GrowthPotential = Math.pow(Math.E, -0.5 * Math.pow(((temp0-avgTemp)/GP), 2)) * 60 * 5600;
            grass.put(i, GrowthPotential);
            GP = GP - 0.55;
        }
        return grass;
    }
}