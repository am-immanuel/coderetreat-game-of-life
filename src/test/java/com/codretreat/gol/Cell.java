package com.codretreat.gol;

import com.codretreat.gol.Grid.Point;

public class Cell {

	private Point point;

	public Cell(Grid.Point p) {
		this.point = p;
	}

	public Point getPoint() {
		return point;
	}
}
