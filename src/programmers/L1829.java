package programmers;

public class L1829 {

	static int dx[] = { 0, 0, -1, 1 };
	static int dy[] = { -1, 1, 0, 0 };
	static int[] answer = new int[2];
	static boolean visited[][];
	static int picture[][];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		answer = solution(6, 4, new int[][] { { 1, 1, 1, 0 }, { 1, 2, 2, 0 }, { 1, 0, 0, 1 }, { 0, 0, 0, 1 },
				{ 0, 0, 0, 3 }, { 0, 0, 0, 3 } });
		System.out.println("area count : " + answer[0]);
		System.out.println("maxSizeOfOneArea : " + answer[1]);

	}

	public static int[] solution(int m, int n, int[][] image) {
		visited = new boolean[m][n];
		picture = image.clone();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (image[i][j] > 0) {
					int count = dfs(i, j, image[i][j]);
					answer[0] = count > 0 ? answer[0] + 1 : answer[0];
					answer[1] = Math.max(count, answer[1]);
				}
			}
		}
		return answer;
	}

	public static int dfs(int x, int y, int thiscolor) {

		int val = 1;
		if (x < 0 || x >= picture.length || y < 0 || y >= picture[0].length)
			return 0;
		if (visited[x][y] || thiscolor != picture[x][y])
			return 0;
		else {
			visited[x][y] = true;
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				val += dfs(nx, ny, thiscolor);
			}
			return val;
		}
	}
}
