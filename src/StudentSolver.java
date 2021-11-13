import java.util.ArrayList;

public class StudentSolver {
	public static ArrayList<Pair<Integer,Integer>> solve(int[][] board){
		ArrayList<Pair<Integer, Integer>> indeces = new ArrayList<Pair<Integer, Integer>>();
		ArrayList<Integer> max = new ArrayList<Integer>();
		
		int rows = board.length;
		int columns = board[0].length;
		
		for (int i=0; i<rows; i++) {
			max.add(board[i][0]);
		}
		
		for (int i : max)
			System.out.println(i);
		
		
		return indeces; 
	}
	public static void main(String[] args) {
		int[][] board ={{35,90,54,62,62,69}, 
						{89,17,59,13,76,24},
						{73,1,57,11,60,34},
						{54,94,21,67,9,77}};
		solve (board);
	}

}
