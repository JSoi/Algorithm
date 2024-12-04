package programmers;

public class L17681 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(String s : solution(5, new int[] {9, 20, 28, 18, 11}, new int[] {30, 1, 21, 17, 28})) {
			System.out.println(s);
		}
	}

	public static String[] solution(int n, int[] arr1, int[] arr2) {
		String[] answer = new String[n];
		for (int i = 0; i < n; i++) {
			int num = arr1[i] | arr2[i];
			String line = "";
			for(int k = 0; k < n; k++) {
				int re = (num>>k)&1;
				if(re == 0) {
					line = " " + line;
				}else {
					line = "#" + line;
				}
			}
			answer[i] = line;
		}
		return answer;
	}
}
