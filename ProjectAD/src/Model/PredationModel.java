package Model;

import util.CSVReader;

import java.io.IOException;
import java.util.TreeMap;

public class PredationModel implements IModel {
    static TreeMap<Integer, Integer> animals = new TreeMap<>();
    double WolfAlfa = 0.2;

    @Override
    public TreeMap<Integer, Integer> calc(int t, String path) throws IOException {
        if (path.equals("DeerData.csv")) {
            int N0 = CSVReader.getN(path);
            // int NWolfs = CSVReader.getN("Wolfs.cvs");
            // int PopulationWolf = CSVReader.getN("Wolf.csv") * ((beta * (CSVReader.getN("DeerData.csv")) - CSVReader.getDeathRate("DeerData.csv")) * t; 
            int amountOfWolfs = 1;
          //Assuming a wolf eats 1:1:1 Deer:Horse:Cattle
            double hDeer = 0.0243/3;
            double DDeer = (1 / (WolfAlfa * hDeer));
            double kDeer = (1 / hDeer);
            for (int i = 1; i <= t; i++) {
                int V = (int) (CSVReader.calcR(path) * N0 * 1 - (((kDeer * (N0 ^ 2))) / ((N0 ^ 2) + 
                		(DDeer * DDeer))) * amountOfWolfs * 1);
                animals.put(i, V);
                N0 = V;
            }
            return animals;
            
            
        }
        else if (path.equals("HorseData.csv")){
            int N0 = CSVReader.getN(path);
            // int NWolfs = CSVReader.getN("Wolfs.csv");
            // int PopulationWolf = CSVReader.getN("Wolf.csv") * ((beta * (CSVReader.getN("HorseData.csv")) - CSVReader.getDeathRate("HorseData.csv")) * t; 
            int amountOfWolfs = 1;
          //Assuming a wolf eats 1:1:1 Deer:Horse:Cattle
            double hHorse = 0.21/3;
            double DHorse = (1 / (WolfAlfa * hHorse));
            double kHorse = (1 / hHorse);
            for (int i = 1; i <= t; i++) {
                int V = (int) (CSVReader.calcR(path) * N0 * 1 - (((kHorse * (N0 ^ 2))) / ((N0 ^ 2) + 
                		(DHorse * DHorse))) * amountOfWolfs * 1);
                animals.put(i, V);
                N0 = V;
            }
            return animals;
        }

        else if (path.equals("CattleData.csv")){
            int N0 = CSVReader.getN(path);
            // int NWolfs = CSVReader.getN("Wolfs.csv");
            // int PopulationWolf = CSVReader.getN("Wolf.csv") * ((beta * (CSVReader.getN("CattleData.csv")) - CSVReader.getDeathRate("CattleData.csv")) * t; 
            // int amountOfWolfs = PopulationWolf;
            int amountOfWolfs = 1;
            //Assuming a wolf eats 1:1:1 Deer:Horse:Cattle
            double hCattle = 0.366/3;
            double DCattle = (1 / (WolfAlfa * hCattle));
            double kCattle = (1 / hCattle);
            for (int i = 1; i <= t; i++) {
                int V = (int) (CSVReader.calcR(path) * N0 * 1 - (((kCattle * (N0 ^ 2))) / ((N0 ^ 2) + 
                		(DCattle * DCattle))) * amountOfWolfs * 1);
                animals.put(i, V);
                N0 = V;
            }
            return animals;
        }
        else {
            System.out.println("Something is wrong :( ");
            return null;
        }
    }
}