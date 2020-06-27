package programmers;

import java.util.Stack;

public class L1829_2 {
	static Stack<Integer> sx = new Stack<Integer>();
	static Stack<Integer> sy = new Stack<Integer>();
	static boolean visit[][];
	static int dx[] = { 0, 0, -1, 1 };
	static int dy[] = { -1, 1, 0, 0 };

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int ans[] = solution(6, 4, new int[][] { { 1, 1, 1, 0 }, { 1, 2, 2, 0 }, { 1, 0, 0, 1 }, { 0, 0, 0, 1 },
				{ 0, 0, 0, 3 }, { 0, 0, 0, 3 } });
		System.out.println("area count : " + ans[0]);
		System.out.println("maxSizeOfOneArea : " + ans[1]);

	}

	public static int[] solution(int m, int n, int[][] picture) {
		visit = new boolean[m][n];
		int[] answer = new int[2];
		for (int i = 0; i < m; i++) { // picture를 모두 돌면서 해당 색의 영역을 돈다.
			for (int j = 0; j < n; j++) {
				int count = 0; // 각각의 원소 설정(i,j)
				if (!visit[i][j] & picture[i][j] != 0) { // 만약 한번도 방문하지 않았거나, 사진에서 색이 있는 경우
					go(i, j); // 스택에 x,y 좌표 더해주기
					count++; // 현재 색에 해당하는 영역 수 증가
					answer[0]++; // 영역 개수 1 증가
				}
				while (!sx.empty()) {
					// 스택은 영역 색이 변할 때마다 비워지게 된다*
					int x = sx.pop(); // 직전의 x,y 좌표 꺼내오기
					int y = sy.pop();
					for (int k = 0; k < 4; k++) { // 상,하,좌,우 모두 검사함
						int nx = x + dx[k];
						int ny = y + dy[k];
						if (nx < 0 || nx >= picture.length || ny < 0 || ny >= picture[0].length) {
							// 배열 범위를 벗어나는지 체크
							continue;
						}
						if (picture[nx][ny] != picture[x][y] || visit[nx][ny]) {
							// Stack에서 pop한 좌표의 색상과 같은지, 방문한 곳인지 검사
							continue;
						}
						// 필터를 통과했다면 스택과 방문 배열을 업데이트하고, 해당 색상의 영역을 1 넓혀준다.
						go(nx, ny);
						count++;
					}
				}
				answer[1] = Math.max(answer[1], count);
			}
		}
		return answer;
	}

	public static void go(int x, int y) {
		sx.add(x);
		sy.add(y);
		visit[x][y] = true;
	}
}
