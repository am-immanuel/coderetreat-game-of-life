package com.codretreat.gol;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Grid {

	private Map<Point, Cell> cells = new HashMap<>();

	public Grid() {

	}

	public Grid(Point[] initialLivingCells) {
		for (Point p : initialLivingCells) {
			cells.put(p, new Cell(true));
		}
	}

	public Cell getCell(int x, int y) {
		return getCell(x, y, true);
	}

	private Cell getCell(int x, int y, boolean autoCreate) {
		Point p = new Point(x, y);
		Cell result = cells.get(p);
		if (result == null && autoCreate) {
			result = new Cell(false);
			cells.put(p, result);
		}
		return result;
	}

	private Cell[] getNeighbours(Point p) {
		Point[] neighbours = p.getNeighbours();
		Cell[] result = new Cell[neighbours.length];
		int i = 0;
		for (Point neighbour : neighbours) {
			result[i++] = getCell(neighbour.x, neighbour.y, false);
		}
		return result;
	}

	public void recalculate() {
		Set<Point> missingCells = new HashSet<>();
		for (Point existingPoint : cells.keySet()) {
			for (Point neighbour : existingPoint.getNeighbours()) {
				if (!cells.containsKey(neighbour) && cells.get(existingPoint).isAlive()) {
					missingCells.add(neighbour);
				}
			}
		}
		for (Point p : missingCells) {
			cells.put(p, new Cell(false));
		}
		for (Entry<Point, Cell> entry : cells.entrySet()) {
			entry.getValue().recalculate(getNeighbours(entry.getKey()));
		}
	}
}
