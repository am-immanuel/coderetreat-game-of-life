package com.codretreat.gol;

import java.util.HashMap;
import java.util.Map;

public class Grid {

	private Map<Point, Cell> cells = new HashMap<>();
	
	public Grid(){
		Point p = new Point(0, 0);
		cells.put(p, new Cell(p));
	}
	
	public Cell getCell(int i, int j) {
		return cells.get(new Point(i, j));
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
		Cell[] result = new Cell[6];
		
		return result;
	}
}
