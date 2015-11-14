package com.codretreat.gol;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class AppTest {

  private static final int INIT_BOARD_SIZE = 3;


  @Test
  public void testInitBoardSize() {
    Board initBoard = new Board();
    assertTrue(INIT_BOARD_SIZE == initBoard.getBoardSize());
  }

  @Test
  public void testInitialCoordinates() {
    Board initBoard = new Board();
    Row zeroRow = initBoard.getRow(0);
    Cell cell = zeroRow.getCell(0);
    assertNotNull(cell);
    assertNotNull(initBoard.getRow(-1));
    assertNotNull(initBoard.getRow(1));
  }
}
