package com.company;

import java.io.IOException;
import java.util.TreeMap;

public class PredationModel implements IModel {
    static TreeMap<Integer, Integer> animals = new TreeMap<>();
    double WolfAlfa = 0.2;
    // int amountOfWolfs = PopulationWolf;
    // int NWolfs = CSVReader.getN("Wolfs.cvs");
    // int PopulationWolf = CSVReader.getN("Wolf.csv") * ((beta * (CSVReader.getN("DeerData.csv")) - CSVReader.getDeathRate("DeerData.csv")) * t;
    int amountOfWolfs = 5;
    int wolfs = 5;



    public void calcWolfs(double alfa, int pop){
                int dvdtW = (int)  (alfa * pop * wolfs - (0.2 * wolfs * wolfs));
                if(dvdtW <= -50) {
                    dvdtW = -50;
                    wolfs += dvdtW/3;
                }if (dvdtW >= 20){
                    dvdtW =20;
                    wolfs += dvdtW/3;
                 }else{
                    wolfs += dvdtW/3;
        }
    }

    @Override
    public TreeMap<Integer, Integer> calc(int t, String path) throws IOException {
        if (path.equals("CattleData.csv")) {
            double percentileC =(double) CSVReader.getN("CattleData.csv") / (CSVReader.getN("CattleData.csv")
                    + CSVReader.getN("DeerData.csv") + CSVReader.getN("HorseData.csv"));
            int N0 = CSVReader.getN(path);
            double r = CSVReader.calcR(path);
            double hCattle = 0.366;
            double DCattle = (1 / (WolfAlfa * hCattle));
            double kCattle = (1 / hCattle);
            for (int i = 1; i<= t; i++){
                int dvdtA = (int) (((r * N0) - ((kCattle * wolfs * (N0 ^ 2)) / ((N0 ^ 2) + (DCattle * DCattle)))) * percentileC);
                animals.put(i, N0);
                N0 += dvdtA;

                double alfa = 0.8;
                this.calcWolfs(alfa, N0);
            }
            return animals;
        }

        else if (path.equals("DeerData.csv")) {
            double percentileD = (double) CSVReader.getN("DeerData.csv") / (CSVReader.getN("CattleData.csv")
                    + CSVReader.getN("DeerData.csv") + CSVReader.getN("HorseData.csv"));
            int N0 = CSVReader.getN(path);
            double r = CSVReader.calcR(path);
            double hDeer = 0.0243;
            double DDeer = (1 / (WolfAlfa * hDeer));
            double kDeer = (1 / hDeer);
            for (int i = 1; i<= t; i++){
                int dvdtA = (int) (((r * N0) - ((kDeer * wolfs * (N0 ^ 2)) / ((N0 ^ 2) + (DDeer * DDeer))))* percentileD);
                animals.put(i, N0);
                N0 += dvdtA;

                double alfa = 0.3;
                this.calcWolfs(alfa, N0);
            }
            return animals;
        }

        else if (path.equals("HorseData.csv")){
            double percentileH = (double) CSVReader.getN("HorseData.csv") / (CSVReader.getN("CattleData.csv")
                    + CSVReader.getN("DeerData.csv") + CSVReader.getN("HorseData.csv"));
            int N0 = CSVReader.getN(path);
            double r = CSVReader.calcR(path);
            double hHorse = 0.21;
            double DHorse = (1 / (WolfAlfa * hHorse));
            double kHorse = (1 / hHorse);
            for (int i = 1; i<= t; i++){
                int dvdtA = (int) (((r * N0) - ((kHorse * wolfs * (N0 ^ 2)) / ((N0 ^ 2) + (DHorse * DHorse))))* percentileH);
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
