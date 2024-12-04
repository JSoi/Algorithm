package programmers;

import java.util.ArrayList;
import java.util.Collections;

public class L12939_lv2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution("1 2 3 4"));
	}

	static String solution(String s) {
		String split[] = s.split(" ");
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for (String str : split) {
			arr.add(Integer.parseInt(str));
		}
		Collections.sort(arr);
		return arr.get(0) + " " + arr.get(arr.size() - 1);
	}
}
