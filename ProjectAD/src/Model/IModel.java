package Model;

import java.io.IOException;
import java.util.TreeMap;

public interface IModel {
	public TreeMap<Integer,Integer> calc(int t, String path) throws IOException;

}
