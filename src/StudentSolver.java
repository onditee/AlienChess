import java.util.ArrayList;
import java.util.Collections;

public class StudentSolver {
	public static ArrayList<Pair<Integer, Integer>> solve(int[][] board) {

		ArrayList<Pair<Integer, Integer>> indeces = new ArrayList<Pair<Integer, Integer>>();

		ArrayList<Integer> isolatedColumn = new ArrayList<Integer>();

		int rows = board.length;
		int columns = board[0].length;

		for (int j = 0; j < columns; j++) {
			for (int i = 0; i < rows; i++) {

				isolatedColumn.add(board[i][j]);
			}

			for (int i : isolatedColumn)// clear her
				System.out.println(i);
			boolean exit = false;
			while (exit == false) {
				
				int maxValue = Collections.max(isolatedColumn);
				System.out.println("Max Value " + maxValue);

				int indexOfMax = isolatedColumn.indexOf(maxValue);
				System.out.println("Index of Max Value " + indexOfMax);
				// Add the pair to indexes

				Pair index = new Pair(indexOfMax, j);
				// indeces.add(index);

				// Going to implement restrictions
				int m = (int) index.first;
				int n = (int) index.second;
				if (n == 0) {
					
					if (board[m][n]>board[m][n+1]) {
						exit =true;
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
					else {
						isolatedColumn.remove(indexOfMax);
					}

				} else if (n == columns - 1) {
					if(board[m][n]>board[m][n-1]) {
						exit =true;
						
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
					if(board[m][n]>board[m][n+1]) {
						exit =true;
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
					}
					else {
						isolatedColumn.remove(indexOfMax);
					}	
				}
				if (exit ==true) {
					indeces.add(index);
					board[m][n]=0;
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
				if (j<columns-1) {
					if (board[i][j+1] != 0) {
						repeat =true;
					}
				}
				if (board[i][j] != 0 && repeat ==false) {
					Pair newindex = new Pair(i, j);
					indeces.add(newindex);
				}
			}
		}

		System.out.println("Rows:" + rows);

		return indeces;
	}

	
	  public static void main(String[] args) { int[][] board ={ {9,94,51,29,76},
	  {92,68,23,62,42}, {93,64,22,5,51}, {31,17,24,21,49}, {17,45,47,71,35}};
	  System.out.println(solve(board));
	  
	  }
	 
	 

}
