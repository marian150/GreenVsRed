package greenvsRed;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 
 * Represents the Grid
 *
 */

public class Grid {
	private int x; //columns
	private int y; //rows
	private List<List<Cell>> matrix = new ArrayList<List<Cell>>(); //two-dimensional array where we save the cells
	
	/**
	 * 
	 * @param filename The filename as a String
	 * @throws IOException Throws IOException
	 */
	public Grid(String filename) throws IOException{
		/**
		 * A try - catch block to catch exception
		 * if it occurs
		 */
		try {
			Scanner sc = new Scanner(new File(filename));
			
			/**
			 * We take the first row like String and splitting it into integers with ','
			 */
			String[] ints = sc.nextLine().split(",");
			this.y = Integer.parseInt(ints[0]);
			this.x = Integer.parseInt(ints[1]);
			
			/**
			 * We take the remaining rows like Strings and splitting them into integers with ''
			 */
			for(int i = 0; i < y; i++) {
				List<Cell> a = new ArrayList<>();
				String[] rows = sc.nextLine().split("");
				for(int j = 0; j < x; j++) {
					a.add(new Cell(i, j, Integer.parseInt(rows[j])));
				}
				matrix.add(a);
			}
			sc.close();
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @return An int, representing the Grid's columns
	 */
	public int getX() {
		return x;
	}

	/**
	 * 
	 * @param x The new value of the columns
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * 
	 * @return An int, representing the Grid's rows
	 */
	public int getY() {
		return y;
	}

	/**
	 * 
	 * @param y The new value of the rows
	 */
	public void setY(int y) {
		this.y = y;
	}
	
	/**
	 * 
	 * @param y1 Y coords for a Cell
	 * @param x1 X coords for a Cell
	 * @return An object of type Cell
	 */
	public Cell getCell(int y1, int x1) {
		return this.matrix.get(y1).get(x1);
	}
	
	/**
	 * For debugging purposes
	 */
	public String toString() {
		String temp = "";
		for(int i = 0; i < this.y; i++) {
			for(int j = 0; j < this.x; j++) {
				temp += matrix.get(i).get(j).getState();
			}
			temp += "\n";
		}
		return temp;
	}
	
	/**
	 * By given Cell coordinates, calculates its Green neighbours
	 * 
	 * @param yPos The Y coords of the Cell
	 * @param xPos The X coords of the Cell
	 * @return The number of Green neighbours
	 */
	public int getGreenNeighbours(int yPos, int xPos) {
		int count = 0;
		
		//Top-left corner
		if(yPos == 0 && xPos == 0) {
			if(matrix.get(yPos).get(xPos+1).getState() == 1)
				count++;
			if(matrix.get(yPos+1).get(xPos+1).getState() == 1)
				count++;
			if(matrix.get(yPos+1).get(xPos).getState() == 1)
				count++;
		} else if(yPos == 0 && xPos == this.x-1) { //Top-right corner
			if(matrix.get(yPos).get(xPos-1).getState() == 1)
				count++;
			if(matrix.get(yPos+1).get(xPos).getState() == 1)
				count++;
			if(matrix.get(yPos+1).get(xPos-1).getState() == 1)
				count++;
		} else if(yPos == this.y-1 && xPos == 0) { //Bottom-left corner
			if(matrix.get(yPos-1).get(xPos).getState() == 1)
				count++;
			if(matrix.get(yPos-1).get(xPos+1).getState() == 1)
				count++;
			if(matrix.get(yPos).get(xPos+1).getState() == 1)
				count++;
		} else if(yPos == this.y-1 && xPos == this.x-1) { //Bottom-right vorner
			if(matrix.get(yPos).get(xPos-1).getState() == 1)
				count++;
			if(matrix.get(yPos-1).get(xPos).getState() == 1)
				count++;
			if(matrix.get(yPos-1).get(xPos-1).getState() == 1)
				count++;
		} else if(yPos == 0) { //Top side
			if(matrix.get(yPos).get(xPos+1).getState() == 1)
				count++;
			if(matrix.get(yPos).get(xPos-1).getState() == 1)
				count++;
			if(matrix.get(yPos+1).get(xPos).getState() == 1)
				count++;
			if(matrix.get(yPos+1).get(xPos+1).getState() == 1)
				count++;
			if(matrix.get(yPos+1).get(xPos-1).getState() == 1)
				count++;
		} else if(yPos == this.y-1) { //Bottom side
			if(matrix.get(yPos).get(xPos+1).getState() == 1)
				count++;
			if(matrix.get(yPos).get(xPos-1).getState() == 1)
				count++;
			if(matrix.get(yPos-1).get(xPos).getState() == 1)
				count++;
			if(matrix.get(yPos-1).get(xPos+1).getState() == 1)
				count++;
			if(matrix.get(yPos-1).get(xPos-1).getState() == 1)
				count++;
		} else if(xPos == 0) { //Left side
			if(matrix.get(yPos-1).get(xPos).getState() == 1)
				count++;
			if(matrix.get(yPos-1).get(xPos+1).getState() == 1)
				count++;
			if(matrix.get(yPos).get(xPos+1).getState() == 1)
				count++;
			if(matrix.get(yPos+1).get(xPos+1).getState() == 1)
				count++;
			if(matrix.get(yPos+1).get(xPos).getState() == 1)
				count++;
		} else if(xPos == this.x-1) { //Right side
			if(matrix.get(yPos-1).get(xPos).getState() == 1)
				count++;
			if(matrix.get(yPos-1).get(xPos-1).getState() == 1)
				count++;
			if(matrix.get(yPos).get(xPos-1).getState() == 1)
				count++;
			if(matrix.get(yPos+1).get(xPos-1).getState() == 1)
				count++;
			if(matrix.get(yPos+1).get(xPos).getState() == 1)
				count++;
		} else { //Central
			if(matrix.get(yPos-1).get(xPos).getState() == 1)
				count++;
			if(matrix.get(yPos-1).get(xPos-1).getState() == 1)
				count++;
			if(matrix.get(yPos-1).get(xPos+1).getState() == 1)
				count++;
			if(matrix.get(yPos+1).get(xPos-1).getState() == 1)
				count++;
			if(matrix.get(yPos+1).get(xPos).getState() == 1)
				count++;
			if(matrix.get(yPos+1).get(xPos+1).getState() == 1)
				count++;
			if(matrix.get(yPos).get(xPos-1).getState() == 1)
				count++;
			if(matrix.get(yPos).get(xPos+1).getState() == 1)
				count++;
		}
		
		return count;
	}
}
