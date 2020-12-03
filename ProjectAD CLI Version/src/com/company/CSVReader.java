package com.company;

import org.apache.commons.csv.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class CSVReader {

    public static void calcR() throws IOException {

        BufferedReader reader = Files.newBufferedReader(Paths.get("/Users/can/Downloads/CattleData.csv"));
        CSVParser csvParser = new CSVParser(reader , CSVFormat.DEFAULT.withHeader("Year" , "Total" , "Births" , "Deaths"));
        int[] birthsPerCapita = new int[csvParser.getRecords().size()];

        int count = 0;
        for( CSVRecord csv : csvParser){
            birthsPerCapita[count] = Integer.parseInt(csv.get(2)) / Integer.parseInt(csv.get(1));
            System.out.println(Integer.parseInt(csv.get(2)));
            count++;
        }

        for (int i : birthsPerCapita){
            //System.out.println(i);
        }

    }
}
