package com.company;

import java.io.IOException;
import java.util.TreeMap;

public class PredationModel implements IModel {
    static TreeMap<Integer, Integer> animals = new TreeMap<>();

    @Override
    public TreeMap<Integer, Integer> calc(int t, String path) throws IOException {
        return null;
    }

    //V= rVt-(kV^2/(V^2+D^2))pt
    //p=(BV-q)pt
}
