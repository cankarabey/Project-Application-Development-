package com.company;

import java.io.IOException;

public interface IModel {
	public int calcR(int t);
	public int calcNZero(int t);
	public int calcK(int t);
	public void calculate(int t, String path) throws IOException;

}
