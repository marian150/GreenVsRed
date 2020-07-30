package greenvsRed;

/**
 * Represents a Cell in the Grid
 *
 */

public class Cell {
	private int x; //x coordinate
	private int y; //y coordinate
	private int state; // green(1) or red(0)
	
	/**
	 * 
	 * @param x The x coordinate of the Cell
	 * @param y The y coordinate of the Cell
	 * @param state The state of the Cell
	 */
	public Cell(int x, int y, int state) {
		this.setX(x);
		this.setY(y);
		this.setState(state);
	}

	/**
	 * 
	 * @return An int representing the Cell's X coordinate
	 */
	public int getX() {
		return x;
	}

	/**
	 * 
	 * @param x The new value of X coordinate
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * 
	 * @return An int representing the Cell's Y coordinate
	 */
	public int getY() {
		return y;
	}

	/**
	 * 
	 * @param y The new value of Y coordinate
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * 
	 * @return An int representing the Cell's State
	 */
	public int getState() {
		return state;
	}

	/**
	 * 
	 * @param state The new value of State
	 */
	public void setState(int state) {
		this.state = state;
	}
}
