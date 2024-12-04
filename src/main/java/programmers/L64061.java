package programmers;

import java.util.Stack;

public class L64061 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution(new int[][]{{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}}, new int[] {1,5,3,5,1,2,1,4}));
	}

	public static int solution(int[][] board, int[] moves) {
		int disappearCount = 0;
		Stack<Integer> pickstack = new Stack<Integer>();
		for (int k = 0; k < moves.length; k++) {
			int target = moves[k]-1;
			for (int i = 0; i < board.length; i++) {
				if(board[i][target]!=0) {
					if(pickstack.size()!=0) {
						if(pickstack.peek()!=board[i][target]) {
							pickstack.push(board[i][target]);
						}
						else {
							pickstack.pop();
							disappearCount+=2;
						}
					}
					else {
						pickstack.push(board[i][target]);
					}
					board[i][target] = 0;
					break;
				}
			}
		}
		
		int answer = disappearCount;
		return answer;
	}
}
