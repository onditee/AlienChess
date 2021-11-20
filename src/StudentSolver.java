import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class StudentSolver {
	public static ArrayList<Pair<Integer, Integer>> solve(int[][] board) {

		ArrayList<Pair<Integer, Integer>> indeces = new ArrayList<Pair<Integer, Integer>>();

		ArrayList<Integer> isolatedColumn = new ArrayList<Integer>();
		ArrayList<Integer> isolatedColumnTemp = new ArrayList<Integer>();
		int maxValueTemp = 0;

		int rows = board.length;
		int columns = board[0].length;
		// System.out.println("columns " + columns);
		for (int j = 0; j < columns; j++) {
			for (int i = 0; i < rows; i++) {

				isolatedColumn.add(board[i][j]);
			}

			// for (int i : isolatedColumn)
			// System.out.println(i);
			boolean exit = false;
			while (exit == false) {

				int maxValue = Collections.max(isolatedColumn);
				// System.out.println("Max Value " + maxValue);

				int indexOfMax = isolatedColumn.indexOf(maxValue);
				// System.out.println("Index of Max Value " + indexOfMax);
				// Add the pair to indexes

				Pair index = new Pair(indexOfMax, j);
				// indeces.add(index);

				// Going to implement restrictions
				int m = (int) index.first;
				int n = (int) index.second;

				if (maxValue == 0) {
					exit = true;
				} else {
					if (n == 0) {

						if (board[m][n] >= board[m][n + 1]) {
							exit = true;
							if (m == 0) {
								board[m + 1][n] = 0;
								board[m][n + 1] = 0;
							} else if (m == rows - 1) {
								board[m - 1][n] = 0;
								board[m][n + 1] = 0;
							} else {
								board[m - 1][n] = 0;
								board[m + 1][n] = 0;
								board[m][n + 1] = 0;
							}
						} else {
							for (int i = 0; i < rows; i++) {
								isolatedColumnTemp.add(board[i][n + 1]);
							}
							maxValueTemp = Collections.max(isolatedColumnTemp);
							System.out.println("Max Value " + maxValueTemp);
							if (board[m][n + 1] == maxValueTemp) {
								isolatedColumn.set(indexOfMax, 0);
							} else {
								exit = true;
								if (m == 0) {
									board[m + 1][n] = 0;
									board[m][n + 1] = 0;
								} else if (m == rows - 1) {
									board[m - 1][n] = 0;
									board[m][n + 1] = 0;
								} else {
									board[m - 1][n] = 0;
									board[m + 1][n] = 0;
									board[m][n + 1] = 0;
								}
							}
							isolatedColumnTemp.clear();

						}

					} else if (n == columns - 1) {

						if (board[m][n] > board[m][n - 1]) {
							exit = true;

							if (m == 0) {
								board[m + 1][n] = 0;
								board[m][n - 1] = 0;
							} else if (m == rows - 1) {
								board[m - 1][n] = 0;
								board[m][n - 1] = 0;
							} else {
								board[m - 1][n] = 0;
								board[m + 1][n] = 0;
								board[m][n - 1] = 0;
							}
						}

					} else {
						if (board[m][n] >= board[m][n + 1]) {
							exit = true;
							if (m == 0) {
								board[m + 1][n] = 0;
								board[m][n + 1] = 0;
								board[m][n - 1] = 0;
							} else if (m == rows - 1) {
								board[m - 1][n] = 0;
								board[m][n + 1] = 0;
								board[m][n - 1] = 0;
							} else {
								board[m - 1][n] = 0;
								board[m + 1][n] = 0;
								board[m][n + 1] = 0;
								board[m][n - 1] = 0;
							}
						} else {
							for (int i = 0; i < rows; i++) {
								isolatedColumnTemp.add(board[i][n + 1]);
							}
							maxValueTemp = Collections.max(isolatedColumnTemp);
							// System.out.println("Max Value " + maxValueTemp);
							if (board[m][n + 1] == maxValueTemp) {
								isolatedColumn.set(indexOfMax, 0);
							} else {
								exit = true;
								if (m == 0) {
									board[m + 1][n] = 0;
									board[m][n + 1] = 0;
								} else if (m == rows - 1) {
									board[m - 1][n] = 0;
									board[m][n + 1] = 0;
								} else {
									board[m - 1][n] = 0;
									board[m + 1][n] = 0;
									board[m][n + 1] = 0;
								}
							}
							isolatedColumnTemp.clear();

						}
					}
				}

				if (exit == true && board[m][n] != 0) {
					indeces.add(index);
					board[m][n] = 0;
				}
			}

			isolatedColumn.clear();

		}

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
		boolean repeat = false;

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				if (j < columns - 1) {
					// This makes sure that the element to the immediate right is not taken up
					if (board[i][j] != 0 && board[i][j + 1] != 0) {// add or for elements above
						// System.out.println("This:"+ board[i][j]);
						repeat = true;
					}
				}
				if (i < rows - 1) {

					if (board[i][j] != 0 && board[i + 1][j] != 0) {
						repeat = true;
					}

				}

				if (board[i][j] != 0 && repeat == false) {
					Pair newindex = new Pair(i, j);
					indeces.add(newindex);
					// System.out.println(newindex);
				}
			}
		}

		// if repeat = true..do the call a function to do the program again
		ArrayList<Pair<Integer, Integer>> reursionIndexes = new ArrayList<Pair<Integer, Integer>>();
		;
		if (repeat == true) {
			reursionIndexes = solve(board);
		}
		for (Pair p : reursionIndexes) {
			indeces.add(p);
		}
		// reursionIndexes.clear();
		// System.out.println("Rows:" + rows);
		// System.out.println("Repeat: " + repeat);
		ArrayList<Pair<Integer, Integer>> updatedIndeces = new ArrayList<Pair<Integer, Integer>>(
				new HashSet<Pair<Integer, Integer>>(indeces));
		return updatedIndeces;
	}

	
	  public static void main(String[] args) { int[][] board ={ {5,28,36,81,94},
	  {22,34,20,69,99}, {4,95,77,86,89}, {26,88,56,3,68}, {65,81,60,100,100} };
	  
	  System.out.println(solve(board));
	  
	  }
	 

}

/*
 * {35,90,54,62,62,69}, {89,17,59,13,76,24}, {73,1,57,11,60,34},
 * {52,94,21,67,9,77}
 */
/*
 * {9,94,51,29,76}, {92,68,23,62,42}, {93,64,22,5,51}, {31,17,24,21,49},
 * {17,45,47,71,35}}
 */
/*
 * {98,38,6}, {73,99,35}, {26,6,48}, {34,78,92}, {21,46,65}, {55,5,66},
 * {76,99,20}};
 */
/*
 * {48,93,18}, {79,1,66}, {89,83,38}, {34,4,34}, {37,49,17}, {75,23,55},
 * {35,45,84}};
 */
/*
 * {5,28,36,81,94}, {22,34,20,69,99}, {4,95,77,86,89}, {26,88,56,3,68},
 * {65,81,60,100,100}
 */