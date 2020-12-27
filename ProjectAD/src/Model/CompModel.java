package Model;

import sample.Controllers.importDataScreenController;
import util.CSVReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.TreeMap;

public class CompModel implements IModel {

    static TreeMap<Integer, Integer> animals = new TreeMap<>();

    @Override
    public TreeMap<Integer, Integer> calc(int t, String path) throws IOException {
        HashMap<String, FileReader> map = importDataScreenController.getFiles();
        if (path.equals("CattleData")){
            double alpha = 1.5;
            int nOne = CSVReader.getN(map.get(path));
            int nTwo = CSVReader.getN(map.get("HorseData"));
            double r1 = CSVReader.calcR(map.get(path));
            double k1 = CSVReader.calcK(map.get(path));
            for (int x = 0 ; x < t ; x++){
                int prediction = (int) (nOne*(1+r1 * ( 1 - (nOne+alpha*nTwo)/k1)));
                animals.put(x , prediction);
                nOne = prediction;
            }
            return animals;
        }
        else if (path.equals("HorseData")){
            double alpha = 0.5;
            int nOne = CSVReader.getN(map.get(path));
            int nTwo = CSVReader.getN(map.get("CattleData"));
            double r1 = CSVReader.calcR(map.get(path));
            double k1 = CSVReader.calcK(map.get(path));
            for (int x = 0 ; x < t ; x++){
                int prediction = (int) (nOne*(1+r1 * (1 - (nOne+alpha*nTwo)/k1)));
                animals.put(x , prediction);
                nOne = prediction;
            }
            return animals;
        }
        else if (path.equals("DeerData")){
            double alpha = 0.3;
            int nOne = CSVReader.getN(map.get(path));
            int nTwo = CSVReader.getN(map.get("CattleHorseAvg"));
            double r1 = CSVReader.calcR(map.get(path));
            double k1 = CSVReader.calcK(map.get(path));
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
