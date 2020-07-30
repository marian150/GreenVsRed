package greenvsRed;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a calculator. The main algorithm.
 *
 */
public class Calculator {
	/**
	 * Calculating the given Cell's next state
	 * by given Cell coordinates and a grid
	 * 
	 * @param y1 The Y coordinate of a Cell
	 * @param x1 The X coordinate of a Cell
	 * @param grid The Grid containing the Cell
	 * @return 1 or 0 (The state of the Cell)
	 */
	public static int calcCellNextState(int y1, int x1, Grid grid) {
		if(grid.getCell(y1, x1).getState() == 1) {
			/**
			 * If the Cell is Green(1) and has 2, 3 or 6 Green neighbours
			 * then the Cell stays Green(1)
			 */
			if(grid.getGreenNeighbours(y1, x1) == 2 || grid.getGreenNeighbours(y1, x1) == 3
					|| grid.getGreenNeighbours(y1, x1) == 6)
				return 1;
			else return 0;
		}
		else {
			/**
			 * If the Cell is Red(0) and has 3 or 6 Green neighbours
			 * then the Cell turns Green(1)
			 */
			if(grid.getGreenNeighbours(y1, x1) == 3 || grid.getGreenNeighbours(y1, x1) == 6)
				return 1;
			else return 0;
		}
	}

	/**
	 * Returns a list of states for all Cells
	 * by given grid
	 * 
	 * @param grid The grid containing the Cells
	 * @return List of States(List<Integer>)
	 */
	public static List<Integer> getAllCellsNextStates(Grid grid) {
		List<Integer> temp = new ArrayList<Integer>(); 
		for(int i = 0; i < grid.getX(); i++) {
			for(int j = 0; j < grid.getY(); j++) {
				/**
				 * Calculating each Cell's next State
				 * and adding the result in temporary List<Integer>
				 */
				temp.add(calcCellNextState(j, i, grid));
			}	
		}
		return temp;
	}

	/**
	 * Changes all Cells' states in a grid
	 * by given list of states
	 * 
	 * @param grid The Grid which we want to change
	 * @param list A List<Integer> containing all Cells' next States
	 */
	public static void setAllCellsNewStates(Grid grid, List<Integer> list) {
		int q = 0;
		for(int i = 0; i < grid.getX(); i++) {
			for(int j = 0; j < grid.getY(); j++) {
				grid.getCell(j, i).setState(list.get(q));
				q++;
			}
		}
	}
	
	//Method which returns the final result - how many times in 'n' generations the given Cell becomes Green
	/**
	 * Returns the final result -
	 * how many times in 'n' generations the given Cell becomes Green
	 * 
	 * @param y1 The Y coordinate of the required Cell
	 * @param x1 The X coordinate of the required Cell
	 * @param grid The grid containing the Cell
	 * @param n How many Generations to calculate
	 * @return An int representing the final result
	 */
	public static int calcResult(int y1, int x1, Grid grid, int n) {
		int count = 0;
		if(grid.getCell(y1, x1).getState() == 1)
			count++;
		List<Integer> temp = new ArrayList<Integer>();
		for(int i = 0; i < n; i++) {
			temp = getAllCellsNextStates(grid);
			setAllCellsNewStates(grid, temp);
			if(grid.getCell(y1, x1).getState() == 1)
				count++;
		}
		return count;
	}
}
