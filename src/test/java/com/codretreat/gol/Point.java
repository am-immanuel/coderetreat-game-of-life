package com.codretreat.gol;

public class Point {
	public final int x;
	public final int y;

	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	public Point[] getNeighbours() {
		Point[] result = new Point[8];
		result[0] = new Point(x - 1, y - 1);
		result[2] = new Point(x - 1, y + 1);
		result[5] = new Point(x + 1, y - 1);
		result[7] = new Point(x + 1, y + 1);
		result[3] = new Point(x, y - 1);
		result[4] = new Point(x, y + 1);
		result[1] = new Point(x - 1, y);
		result[6] = new Point(x + 1, y);
		return result;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

}
