package com.codretreat.gol;

public class Cell {

	private boolean isAlive;
	private boolean nextAliveState;

	public Cell(boolean isAlive) {
		this.isAlive = isAlive;
	}

	public boolean isAlive() {
		return this.isAlive;
	}

	public void recalculate(Cell[] neighbours) {
		nextAliveState = isAlive;
		int numOfLivingCells = 0;
		for (Cell c : neighbours) {
			if (c == null) 
				continue;
			if (c.isAlive()) {
				numOfLivingCells++;
			}
		}
		if (numOfLivingCells < 2 ) {
			nextAliveState = false;
		} else if (numOfLivingCells == 3) {
			nextAliveState = true;
		}else if(numOfLivingCells > 3){
			nextAliveState = false;
		}
	}

	public void commitNextState() {
		isAlive = nextAliveState;
	}
}
