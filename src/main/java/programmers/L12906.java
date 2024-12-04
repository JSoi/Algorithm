package programmers;

import java.util.ArrayList;

public class L12906 {
	public static int[] solution(int[] arr) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		int bf = -1;
		for (int i : arr) {
			if (bf != i) {
				list.add(i);
			}
			bf = i;
		}
		int[] answer = new int[list.size()];
		int answers = 0;
		for (int j : list) {
			answer[answers++] = j;
			//System.out.println(j);
		}
		return answer;
	}

	public static void main(String[] args) {
		int arr[] = {1,1,3,3,0,1,1};
		solution(arr);
	}

}
