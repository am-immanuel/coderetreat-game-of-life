package com.codretreat.gol;

import static org.junit.Assert.*;

import org.junit.Test;

public class AppTest {
	@Test
	public void testInitialCoordinates() {
		Grid grid = new Grid();
		Cell cell = grid.getCell(0, 0);
		assertNotNull(cell);
	}
	
	@Test
	public void testInitialLivingCell() {
		Grid grid = new Grid(new Point[] {new Point(0, 0)});
		Cell cell = grid.getCell(0, 0);
		assertNotNull(cell);
		assertTrue(cell.isAlive());
	}


	@Test
	public void testDieOfLoneliness() {
		Grid grid = new Grid(new Point[] {new Point(0, 0)});
		Cell cell = grid.getCell(0, 0);
		grid.recalculate();
		assertFalse(cell.isAlive());
	}
}
