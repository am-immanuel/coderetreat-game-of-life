package com.codretreat.gol;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Grid {

	private Map<Point, Cell> cells = new HashMap<>();

	public Grid() {
		
	}

	public Grid(Point[] initialLivingCells) {
		for (Point p : initialLivingCells) {
			cells.put(p, new Cell(true));
		}
	}

	public Cell getCell(int i, int j) {
		Point p = new Point(i, j);
		Cell result = cells.get(p);
		if (result == null) {
			result = new Cell(false);
			cells.put(p, result);
		}
		return result;
	}

	private Cell[] getNeighbours(Point p) {
		Cell[] result = new Cell[8];
		result[0] = getCell(p.x - 1, p.y - 1);
		result[2] = getCell(p.x - 1, p.y + 1);
		result[5] = getCell(p.x + 1, p.y - 1);
		result[7] = getCell(p.x + 1, p.y + 1);
		result[3] = getCell(p.x, p.y - 1);
		result[4] = getCell(p.x, p.y + 1);
		result[1] = getCell(p.x - 1, p.y);
		result[6] = getCell(p.x + 1, p.y);
		return result;
	}

	public void recalculate() {
		for(Entry<Point, Cell> entry: cells.entrySet()){
			entry.getValue().recalculate(getNeighbours(entry.getKey()));
		}
		
	}
}
