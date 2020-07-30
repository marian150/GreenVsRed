package greenvsRed;

/**
 * @author Mariyan Zhelyazkov
 * 
 */

import java.io.IOException;
import java.util.Scanner;

public class Main {
	/**
	 * This is a program, designed to play the Green vs Red game.
	 * @param args
	 * @throws IOException
	 */

	public static void main(String[] args) throws IOException{
		/**
		 * This is the Main method
		 * where we scan the input from the Console
		 * and calculate the result
		 */
		Grid game = new Grid("C:\\Users\\mariy\\eclipse-workspace\\GreenvsRed\\test.txt");
		/**
		 * Creating a Scanner to read from the Console
		 */
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter coordinates for Cell and number of Generations to calculate: ");
		/**
		 * The input is delimited by ',' and
		 * because of this, we store it in String[] ints
		 * and then parse to Integer values
		 */
		String[] ints = sc.nextLine().split(",");
		int y = Integer.parseInt(ints[0]);
		int x = Integer.parseInt(ints[1]);
		int n = Integer.parseInt(ints[2]);
		sc.close();
		/**
		 * Calling the static method calcResult() to
		 * calculate the result of the game
		 * @see Calculator#calcResult(int, int, Grid, int)
		 */
		System.out.println("Result " + Calculator.calcResult(y, x, game, n));
	}

}
