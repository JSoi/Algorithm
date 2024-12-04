package programmers;

public class L42842 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] ans = solution(10, 2);
		System.out.println("ANSWER : " + ans[0] + " , " + ans[1]);
	}

	// 카펫의 가로 길이는 세로 길이와 같거나, 세로 길이보다 깁니다.
	// 갈색 두께는 1
	public static int[] solution(int b, int y) {
		int[] answer = new int[2];
		for (int g = (b + y) / 2; g >= (int) Math.sqrt(b + y); g--) {
			if ((b + y) % g != 0) {
				continue;
			}
			int garo = g;
			int sero = (b + y) / garo;
			if ((garo - 2) * (sero - 2) == y) {
				answer[0] = garo;
				answer[1] = sero;
				break;
			}
		}
		return answer;
	}
	// garo >=3

}
