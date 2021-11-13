import java.util.ArrayList;
import java.util.Collections;

public class StudentSolver {
	public static ArrayList<Pair<Integer,Integer>> solve(int[][] board){
		ArrayList<Pair<Integer, Integer>> indeces = new ArrayList<Pair<Integer, Integer>>();
		ArrayList<Integer> isolatedColumn = new ArrayList<Integer>();
		
		int rows = board.length;
		int columns = board[0].length;
		int column = 0;
		
		for (int i=0; i<rows; i++) {
			isolatedColumn.add(board[i][column]);
		}
		
		for (int i : isolatedColumn)
			System.out.println(i);
		int maxValue = Collections.max(isolatedColumn);
		System.out.println("Max Value "+maxValue);
		int indexOfMax =isolatedColumn.indexOf(maxValue);
		System.out.println("Index of Max Value "+indexOfMax);
		
		//Going to implement restrictions 
		Pair index = new Pair(indexOfMax,column);
		
		indeces.add(index);
		
		
		
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
