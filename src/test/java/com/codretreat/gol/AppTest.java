package com.codretreat.gol;

import org.junit.Test;
import static org.junit.Assert.*;

public class AppTest
{
	@Test
	public void testInitialCoordinates() {
		Grid grid = new Grid();
		Cell cell = grid.getCell(0, 0);
		assertNotNull(cell);
		assertNotNull(cell.getPoint());
		assertNotNull(grid.getNeighbours(cell));
		assertEquals(6, grid.getNeighbours(cell).length);
	}
}
