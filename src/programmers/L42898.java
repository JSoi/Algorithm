package programmers;

public class L42898 {
	public static void main(String[] args) {
		Solution42898 sol = new Solution42898();
		System.out.println(sol.solution(4, 3, new int[][] { { 2, 2 } }));
	}
}

class Solution42898 {
	public int solution(int m, int n, int[][] puddles) {
		int map[][] = new int[n + 1][m + 1];
		for (int p[] : puddles) {
			map[p[1]][p[0]] = -1;
		}
		map[1][1] = 1;
		for (int x = 1; x <= n; x++) {
			for (int y = 1; y <= m; y++) {
				if (x == 1 && y == 1)
					map[x][y] = 1;
				else if (map[x][y] == -1)
					map[x][y] = 0;
				else
					map[x][y] = (map[x - 1][y] + map[x][y - 1]) % 1000000007;
			}
		}

//		System.out.println(map);
		return map[n][m] % 1000000007;
	}
}