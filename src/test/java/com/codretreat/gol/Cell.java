package com.codretreat.gol;

public class Cell {

	private boolean isAlive;

	public Cell(Point p, boolean isAlive) {
		this(isAlive);
	}

	public Cell(boolean isAlive) {
		this.isAlive = isAlive;
	}

	public boolean isAlive() {
		return this.isAlive;
	}

	public boolean isLonely() {
		// TODO Auto-generated method stub
		return false;
	}

	public void recalculate(Cell[] neighbours) {
		
	}
	
}
