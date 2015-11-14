package com.codretreat.gol;

import java.util.ArrayList;
import java.util.List;

public class Board {

  final static int DEF_BOARD_SIZE = 3;

  private final List<Row> rows;


  public Board() {
    this(DEF_BOARD_SIZE);
  }


  public Board(int initSize) {
    rows = new ArrayList<Row>();
    for (int i = 0; i < initSize; i++) {
      rows.add(new Row(initSize));
    }
  }


  public int getBoardSize() {
    return rows.size();
  }


  public Row getRow(int i) {
    return rows.get(i);
  }
}
