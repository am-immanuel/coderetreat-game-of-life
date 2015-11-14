package com.codretreat.gol;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
  		Grid grid = new Grid(new Point[] { new Point(0, 0), new Point(0, 1), new Point(1, 0) });
  		boolean hasAlives = true;
  		while (hasAlives) {
  			hasAlives = false;
  			grid.recalculate();
  			boolean[][] array = grid.toArray();
  			for (int x = 0; x < array.length; x++) {
  				for (int y = 0; y < array[x].length; y++) {
  					boolean isAlive = array[x][y]; 
  					System.out.print(isAlive ? "*" : " ");
  					if (isAlive) {
  						hasAlives = true;
  					}
  				}
    			System.out.println();
  			}
  			System.out.println("======");
  		}
    }
}
