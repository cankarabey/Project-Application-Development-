package Model;

import sample.Controllers.importDataScreenController;
import util.CSVReader;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.TreeMap;

public class PredationModel implements IModel {
    static TreeMap<Integer, Integer> animals = new TreeMap<>();
    double WolfAlfa = 0.2;
    // int amountOfWolfs = PopulationWolf;
    // int NWolfs = CSVReader.getN("Wolfs.cvs");
    // int PopulationWolf = CSVReader.getN("Wolf.csv") * ((beta * (CSVReader.getN("DeerData.csv")) - CSVReader.getDeathRate("DeerData.csv")) * t;
    int amountOfWolfs = 1;

    @Override
    public TreeMap<Integer, Integer> calc(int t, String path) throws IOException {
        HashMap<String, File> map = importDataScreenController.getFiles();
        if (path.equals("CattleData")) {
            int wolfs = 1;
            int N0 = CSVReader.getN(map.get(path));
            double r = CSVReader.calcR(map.get(path));
            double hCattle = 0.366;
            double DCattle = (1 / (WolfAlfa * hCattle));
            double kCattle = (1 / hCattle);
            for (int i = 1; i<= t; i++){
                int dvdtA = (int) ((r * N0) - ((kCattle * wolfs * (N0 ^ 2)) / ((N0 ^ 2) + (DCattle * DCattle))));
                animals.put(i, N0);
                N0 += dvdtA;

//                int dvdtW = (int) (0.8 * N0 * wolfs - (0.2 * wolfs * wolfs));
//                wolfs += dvdtW;
//                System.out.println(wolfs);

            }
            return animals;
        }
        else if (path.equals("DeerData")) {
            int N0 = CSVReader.getN(map.get(path));
            double r = CSVReader.calcR(map.get(path));
            double hDeer = 0.0243;
            double DDeer = (1 / (WolfAlfa * hDeer));
            double kDeer = (1 / hDeer);
            for (int i = 1; i<= t; i++){
                int dvdtA = (int) ((r * N0) - ((kDeer * amountOfWolfs * (N0 ^ 2)) / ((N0 ^ 2) + (DDeer * DDeer))));
                animals.put(i, N0);
                N0 += dvdtA;
            }
            return animals;
        }
        else if (path.equals("HorseData")){
            int N0 = CSVReader.getN(map.get(path));
            double r = CSVReader.calcR(map.get(path));
            double hHorse = 0.21;
            double DHorse = (1 / (WolfAlfa * hHorse));
            double kHorse = (1 / hHorse);
            for (int i = 1; i<= t; i++){
                int dvdtA = (int) ((r * N0) - ((kHorse * amountOfWolfs * (N0 ^ 2)) / ((N0 ^ 2) + (DHorse * DHorse))));
                animals.put(i, N0);
                N0 += dvdtA;
            }
            return animals;
        }
        else {
            System.out.println("Something is wrong :( ");
            return null;
        }
    }
}
