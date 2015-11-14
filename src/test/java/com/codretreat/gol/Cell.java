package com.codretreat.gol;

public class Cell {

	private boolean isAlive;

	public Cell(boolean isAlive) {
		this.isAlive = isAlive;
	}

	public boolean isAlive() {
		return this.isAlive;
	}

	public void recalculate(Cell[] neighbours) {
		int numOfLivingCells = 0;
		for (Cell c : neighbours) {
			if (c == null) 
				continue;
			if (c.isAlive()) {
				numOfLivingCells++;
			}
		}
		if (numOfLivingCells < 2 ) {
			isAlive = false;
		} else if (numOfLivingCells == 3) {
			isAlive = true;
		}else if(numOfLivingCells > 3){
			isAlive = false;
		}
	}

}
