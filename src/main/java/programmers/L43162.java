package programmers;

import java.util.*;

public class L43162 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution43162 sol = new Solution43162();
		System.out.println(sol.solution(3, new int[][] { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } }));

	}

}

class Solution43162 {
	int[] root;
	boolean[] visit;

	public int solution(int n, int[][] computers) {
		HashSet<Integer> indexSet = new HashSet<Integer>();
		root = new int[computers.length];
		visit = new boolean[computers.length];
		for (int i = 0; i < root.length; i++) {
			root[i] = i;
		}
		for (int j = 0; j < root.length; j++) {
			if (root[j] == j) {
				// 자신==뿌리 라면 dfs를 실행한다
				dfs(computers, j, j);
			}
		}
		for (int k : root) {
			indexSet.add(k);
		}
		return indexSet.size();
	}

	public void dfs(int[][] computers, int index, int r) {
		for (int j = 0; j < computers[0].length; j++) {
			if (computers[index][j] == 1 && !visit[j] && index != j) {// 연결되어있는경우
				root[j] = r;
				visit[j] = true;
//				System.out.println("root  : " + Arrays.toString(root));
//				System.out.println("j : " + j);
				dfs(computers, j, r);
			}

		}
	}
}