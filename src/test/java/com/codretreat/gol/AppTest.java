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
		assertFalse(grid.getCell(0, 1).isAlive());
	}


	@Test
	public void testDieOfLoneliness() {
		Grid grid = new Grid(new Point[] {new Point(0, 0)});
		Cell cell = grid.getCell(0, 0);
		grid.recalculate();
		assertFalse(cell.isAlive());
	}
	
	@Test
	public void testBecomeAlive() {
		Grid grid = new Grid(new Point[] { new Point(0, 0), new Point(0, 1), new Point(1, 0) });
		Cell cell = grid.getCell(1, 1);
		grid.recalculate();
		assertTrue(cell.isAlive());
	}
	
	@Test
	public void testOverCrowding(){
		Grid grid = new Grid(new Point[] { new Point(0, 0), new Point(0, 1), new Point(1, 0), new Point(1, 2), new Point(1, 1) });
		Cell cell = grid.getCell(1, 1);
		assertTrue(cell.isAlive());
		grid.recalculate();
		assertFalse(cell.isAlive());
	}

	@Test
	public void testStayAlive(){
		Grid grid = new Grid(new Point[] { new Point(0, 0), new Point(0, 1), new Point(1, 0), new Point(1, 2), new Point(1, 1) });
		grid.recalculate();
		assertTrue(grid.getCell(1, 2).isAlive());
		assertTrue(grid.getCell(0, 0).isAlive());
		assertTrue(grid.getCell(1, 0).isAlive());
		assertFalse(grid.getCell(0, 1).isAlive());
		assertFalse(grid.getCell(1, 1).isAlive());
	}
}
