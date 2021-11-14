import java.util.ArrayList;
import java.util.Collections;

public class StudentSolver {
	public static ArrayList<Pair<Integer,Integer>> solve(int[][] board){
		ArrayList<Pair<Integer, Integer>> indeces = new ArrayList<Pair<Integer, Integer>>();
		ArrayList<Integer> isolatedColumn = new ArrayList<Integer>();
		
		int rows = board.length;
		int columns = board[0].length;
		int column = 0;
		
		for(int j=0; j<columns; j++) {
			for (int i=0; i<rows; i++) {
				
				isolatedColumn.add(board[i][j]);
			}
			
			for (int i : isolatedColumn)//clear her
				System.out.println(i);
			
			int maxValue = Collections.max(isolatedColumn);
			System.out.println("Max Value "+maxValue);
			
			int indexOfMax =isolatedColumn.indexOf(maxValue);
			System.out.println("Index of Max Value "+indexOfMax);
			//Add the pair to indexes 
			
			Pair index = new Pair(indexOfMax,j);
			//indeces.add(index);
			
			//Going to implement restrictions 
			int m = (int)index.first;
			int n = (int)index.second;
			if (n ==0) {
				
				if (m == 0) {
					board[m+1][n] =0;
					board[m][n+1] =0;
				}
				else if (m ==rows-1) {
					board[m-1][n] =0;
					board[m][n+1] =0;
				}
				else {
					board[m-1][n] =0;
					board[m+1][n] =0;
					board[m][n+1] =0;
				}
				
			}
			else if (n==columns-1) {
				if (m == 0) {
					board[m+1][n] =0;
					board[m][n-1] =0;
				}
				else if (m ==rows-1) {
					board[m-1][n] =0;
					board[m][n-1] =0;
				}
				else {
					board[m-1][n] =0;
					board[m+1][n] =0;
					board[m][n-1] =0;
				}
			}
			else {
				if (m == 0) {
					board[m+1][n] =0;
					board[m][n+1] =0;
					board[m][n-1] =0;
				}
				else if (m ==rows-1) {
					board[m-1][n] =0;
					board[m][n+1] =0;
					board[m][n-1] =0;
				}
				else {
					board[m-1][n] =0;
					board[m+1][n] =0;
					board[m][n+1] =0;
					board[m][n-1] =0;
				}
			}
			isolatedColumn.clear();
			
		}
		
		for (int i = 0; i<rows; i++){
		    for (int j = 0; j<columns; j++){
		        System.out.print(board[i][j]+" ");
		    }
		    System.out.println();
		}
		
		for (int i = 0; i<rows; i++){
		    for (int j = 0; j<columns; j++){
		    	if (board[i][j]!=0) {
		    		Pair newindex = new Pair(i,j);
					indeces.add(newindex);
		    	}
		    }
		}
		
		
		System.out.println("Rows:"+rows);
		
		
		return indeces; 
	}
	public static void main(String[] args) {
		int[][] board ={{35,90,54,62,62,69}, 
						{89,17,59,13,76,24},
						{73,1,57,11,60,34},
						{54,94,21,67,9,77}};
		System.out.println(solve(board));
		
	}

}
