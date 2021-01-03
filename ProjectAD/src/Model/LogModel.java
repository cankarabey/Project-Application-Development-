package Model;

import sample.Controllers.importDataScreenController;
import util.CSVReader;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.TreeMap;

public class LogModel implements IModel {

    static TreeMap<Integer, Integer> animals = new TreeMap<>();

	@Override
	public TreeMap<Integer, Integer> calc(int t, String path) throws IOException {
		HashMap<String, File> map = importDataScreenController.getFiles();
		int N0 = CSVReader.getN(map.get(path));
		for (int i = 1; i<=t; i++) {
			animals.put(i, ((int) (CSVReader.calcK(map.get(path))/(1 + ((CSVReader.calcK(map.get(path)) - N0)/N0)*Math.pow(Math.E , (-CSVReader.calcR(map.get(path)) * 1))))));
			N0 = animals.get(i);
		}
		return animals;
	}
}
