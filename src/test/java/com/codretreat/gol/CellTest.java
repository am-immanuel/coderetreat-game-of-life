package com.codretreat.gol;

import org.junit.Assert;
import org.junit.Test;

public class CellTest {
	@Test
	public void testCreateNeighbours() {
		Cell underTest = new Cell(0, 0);
		underTest.createNeighbours(new CellRegistry() {
			
			@Override
			public void registerCell(Cell cell, int x, int y) {
				
			}
			
			@Override
			public Cell findCell(int x, int y) {
				return null;
			}
		});
		Assert.assertEquals(6, underTest.getNeighbours().size());
	}
}
