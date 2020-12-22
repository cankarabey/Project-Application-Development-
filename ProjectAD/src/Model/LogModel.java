package Model;

import util.CSVReader;

import java.io.IOException;
import java.util.TreeMap;

public class LogModel implements IModel {

    static TreeMap<Integer, Integer> animals = new TreeMap<>();

	@Override
	public TreeMap<Integer, Integer> calc(int t, String path) throws IOException {
		int N0 = CSVReader.getN(path);
		for (int i = 1; i<=t; i++) {
			animals.put(i, ((int) (CSVReader.calcK(path)/(1 + ((CSVReader.calcK(path) - N0)/N0)*Math.pow(Math.E , (-CSVReader.calcR(path) * 1))))));
			N0 = animals.get(i);
		}
		return animals;
	}
}
