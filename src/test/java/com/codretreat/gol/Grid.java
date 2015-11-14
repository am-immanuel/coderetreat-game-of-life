package com.codretreat.gol;

import java.util.HashMap;
import java.util.Map;

public class Grid {

	private Map<Point, Cell> cells = new HashMap<>();
	
	public Cell getCell(int i, int j) {
		return new Cell();
	}

	private class Point {
		public final int x;
		public final int y;
		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
				
	}
}
