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

        for( CSVRecord csv : csvParser){
            System.out.println(csv.get(0));
        }

    }
}
