package com.codretreat.gol;

import com.codretreat.gol.Grid.Point;

public class Cell {

	private Point point;
	private boolean isAlive;

	public Cell(Grid.Point p) {
		this.point = p;
		this.isAlive = false;
	}

	public Point getPoint() {
		return point;
	}

	public boolean isAlive() {
		return this.isAlive;
	}

	public void setAlive(boolean b) {
		// TODO Auto-generated method stub
		
	}
	
}
