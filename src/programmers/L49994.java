package programmers;


public class L49994 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		System.out.println(sol.solution("LULLLLLLU"));
	}

	public static class Solution {
		public int solution(String dirs) {
			int answer = 0;
			int dx[] = new int[] { 0, 0, -1, 1 };
			int dy[] = new int[] { 1, -1, 0, 0 };
			boolean visit[][][][] = new boolean[11][11][11][11];
			visit[5][5][5][5] = true;
			int startX = 5;
			int startY = 5;
			char[] arr = dirs.toCharArray();
			for (char a : arr) {
				int nextX = startX;
				int nextY = startY;
				int dIndex = -1;
				if (a == 'U') {
					dIndex = 0;
				} else if (a == 'D') {
					dIndex = 1;
				} else if (a == 'L') {
					dIndex = 2;
				} else {
					dIndex = 3;
				}

				nextX = startX + dx[dIndex];
				nextY = startY + dy[dIndex];
				if (nextX < 0 || nextY < 0 || nextX > 10 || nextY > 10) {
					continue;
				}
				if (!visit[startX][startY][nextX][nextY] && !visit[nextX][nextY][startX][startY]) {
					visit[startX][startY][nextX][nextY] = true;
					visit[nextX][nextY][startX][startY] = true;
					answer++;
				}
				startX = nextX;
				startY = nextY;
			}
			return answer;
		}
	}
}
