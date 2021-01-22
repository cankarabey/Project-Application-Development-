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
     int amountOfWolfs = 1;

    public void calcWolfs(double alfa, int pop){
        int dvdtW = (int)  (alfa * pop * amountOfWolfs - (0.2 * amountOfWolfs * amountOfWolfs));
        if(dvdtW <= -50) {
            dvdtW = -50;
            amountOfWolfs += dvdtW/3;
        }if (dvdtW >= 20){
            dvdtW =20;
            amountOfWolfs += dvdtW/3;
        }else{
            amountOfWolfs += dvdtW/3;
        }
    }

    @Override
    public TreeMap<Integer, Integer> calc(int t, String path) throws IOException {
        HashMap<String, File> map = importDataScreenController.getFiles();
        if (path.equals("CattleData")) {
            double percentileC =(double) CSVReader.getN(map.get("CattleData")) / (CSVReader.getN(map.get("CattleData"))
                    + CSVReader.getN(map.get("DeerData")) + CSVReader.getN(map.get("HorseData")));
            int N0 = CSVReader.getN(map.get(path));
            double r = CSVReader.calcR(map.get(path));
            double hCattle = 0.366;
            double DCattle = (1 / (WolfAlfa * hCattle));
            double kCattle = (1 / hCattle);
            for (int i = 1; i<= t; i++){
                int dvdtA = (int) (((r * N0) - ((kCattle * amountOfWolfs * (N0 ^ 2)) / ((N0 ^ 2) + (DCattle * DCattle)))) * percentileC);
                animals.put(i, N0);
                N0 += dvdtA;

                double alfa = 0.8;
                this.calcWolfs(alfa, N0);
            }
            return animals;
        }
        else if (path.equals("DeerData")) {
            double percentileD = (double) CSVReader.getN(map.get("DeerData")) / (CSVReader.getN(map.get("CattleData"))
                    + CSVReader.getN(map.get("DeerData")) + CSVReader.getN(map.get("HorseData")));
            int N0 = CSVReader.getN(map.get(path));
            double r = CSVReader.calcR(map.get(path));
            double hDeer = 0.0243;
            double DDeer = (1 / (WolfAlfa * hDeer));
            double kDeer = (1 / hDeer);
            for (int i = 1; i<= t; i++){
                int dvdtA = (int) (((r * N0) - ((kDeer * amountOfWolfs * (N0 ^ 2)) / ((N0 ^ 2) + (DDeer * DDeer))))* percentileD);
                animals.put(i, N0);
                N0 += dvdtA;

                double alfa = 0.3;
                this.calcWolfs(alfa, N0);
            }
            return animals;
        }
        else if (path.equals("HorseData")){
            double percentileH = (double) CSVReader.getN(map.get("HorseData")) / (CSVReader.getN(map.get("CattleData"))
                    + CSVReader.getN(map.get("DeerData")) + CSVReader.getN(map.get("HorseData")));
            int N0 = CSVReader.getN(map.get(path));
            double r = CSVReader.calcR(map.get(path));
            double hHorse = 0.21;
            double DHorse = (1 / (WolfAlfa * hHorse));
            double kHorse = (1 / hHorse);
            for (int i = 1; i<= t; i++){
                int dvdtA = (int) (((r * N0) - ((kHorse * amountOfWolfs * (N0 ^ 2)) / ((N0 ^ 2) + (DHorse * DHorse))))* percentileH);
                animals.put(i, N0);
                N0 += dvdtA;

                double alfa = 0.6;
                this.calcWolfs(alfa, N0);
            }
            return animals;
        }
        else {
            System.out.println("Something is wrong :( ");
            return null;
        }
    }
}
