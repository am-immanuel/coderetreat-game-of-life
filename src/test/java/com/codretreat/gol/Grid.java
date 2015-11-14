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
		for (Cell c : cells.values()) {
			c.commitNextState();
		}
		Set<Point> pointsToDelete = new HashSet<>();
		for (Entry<Point, Cell> entry : cells.entrySet()) {
			if (!entry.getValue().isAlive()) {
				pointsToDelete.add(entry.getKey());
			}
		}
		for (Point p : pointsToDelete) {
			cells.remove(p);
		}
	}
	
	public boolean[][] toArray() {
		int minX = Integer.MAX_VALUE;
		int minY = Integer.MAX_VALUE;
		int maxX = Integer.MIN_VALUE;
		int maxY = Integer.MIN_VALUE;
		for (Point p : cells.keySet()) {
			minX = Math.min(minX, p.x);
			minY = Math.min(minY, p.y);
			maxX = Math.max(maxX, p.x);
			maxY = Math.max(maxY, p.y);
		}
		boolean[][] result = new boolean[maxX - minX + 1][maxY - minY + 1];
		for (int x = 0; x <= maxX - minX; x++) {
			for (int y = 0; y <= maxY - minY; y++) {
				Point p = new Point(x, y);
				Cell c = cells.get(p);
				result[x][y] = c != null && c.isAlive();
			}
		}
		return result;
	}
}
