package programmers;

public class L12949 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solution(new int[][] { { 1, 4 }, { 3, 2 }, { 4, 1 } }, new int[][] { { 3, 3 }, { 3, 3 } });
	}

	static int[][] solution(int[][] arr1, int[][] arr2) {
		int[][] answer = new int[arr1.length][arr2[0].length];
		for (int i = 0; i < answer.length; i++) {
			for (int j = 0; j < answer[0].length; j++) {
				for (int a12 = 0; a12 < arr1[0].length; a12++) {
					answer[i][j] += arr1[i][a12] * arr2[a12][j];
				}

			}
		}
		return answer;
	}
}
