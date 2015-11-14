package com.codretreat.gol;

import java.util.ArrayList;
import java.util.List;

public class Board {

  final static int DEF_BOARD_SIZE = 3;

  private final List<Row> rows;
  private final List<Row> negativeRows;


  public Board() {
    this(DEF_BOARD_SIZE);
  }


  public Board(int initSize) {
    rows = new ArrayList<Row>();
    negativeRows = new ArrayList<Row>();
    int sizeOneWay = DEF_BOARD_SIZE / 2;
    for (int i = -sizeOneWay; i < sizeOneWay + 1; i++) {
    	if (i < 0) {
    		negativeRows.add(new Row(initSize));
    	} else {
    	  rows.add(new Row(initSize));
    	}
    }
  }


  public int getBoardSize() {
    return rows.size() + negativeRows.size();
  }


  public Row getRow(int i) {
  	if (i >= 0) {
      return rows.get(i);
  	} else {
  		return negativeRows.get(-i - 1);
  	}
  }
}
