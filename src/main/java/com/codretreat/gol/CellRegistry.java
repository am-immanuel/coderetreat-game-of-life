package com.codretreat.gol;

public interface CellRegistry {
	public Cell findCell(int x, int y);
	
	public void registerCell(Cell cell, int x, int y);
}
