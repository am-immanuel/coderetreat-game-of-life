package com.codretreat.gol;

import java.util.HashMap;
import java.util.Map;

public class Grid {

	private Map<Point, Cell> cells = new HashMap<>();

	public Cell getCell(int i, int j) {
		Point p = new Point(i, j);
		Cell result = cells.get(p);
		if (result == null) {
			result = new Cell(p);
			cells.put(p, result);
		}
		return result;
	}

	public class Point {
		public final int x;
		public final int y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + x;
			result = prime * result + y;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Point other = (Point) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}

		private Grid getOuterType() {
			return Grid.this;
		}

	}

	public Cell[] getNeighbours(Cell cell) {
		Cell[] result = new Cell[8];
		Point p = cell.getPoint();
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
}
