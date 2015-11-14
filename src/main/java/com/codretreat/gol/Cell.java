package com.codretreat.gol;

import java.util.HashSet;
import java.util.Set;

public class Cell {
	
	private int x;
	private int y;
	private Set<Cell> neighbours;

	public Cell(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void createNeighbours(CellRegistry cellResolver) {
		if (neighbours != null) {
			throw new IllegalStateException("createNeighbours() was already called");
		}
		neighbours = new HashSet<>();
	}

	public Set<Cell> getNeighbours() {
		if (neighbours == null) {
			throw new IllegalStateException("createNeighbours() was not called");
		}
		return neighbours;
	}

}
