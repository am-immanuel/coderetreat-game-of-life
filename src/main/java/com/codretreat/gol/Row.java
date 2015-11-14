package com.codretreat.gol;

import java.util.ArrayList;
import java.util.List;

public class Row {

  private final List<Cell> cells;


  public Row(int initSize) {
    cells = new ArrayList<Cell>();
    for (int i = 0; i < initSize; i++) {
      cells.add(new Cell());
    }
  }


  public Cell getCell(int i) {
    return cells.get(i);
  }
}
