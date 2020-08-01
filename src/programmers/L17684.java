package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class L17684 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution("KAKAO"));
	}

	static int[] solution(String msg) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		ArrayList<Integer> list = new ArrayList<Integer>();
		int up = 27;
		for (int i = 65; i <= 90; i++) {
			String tar = String.valueOf((char) i + "");
			map.put(tar, i - 64);
		}
		int wIndex = 0;
		while (wIndex < msg.length()) {
			msg = msg.substring(wIndex);
			// System.out.println("msg : " + msg);
			wIndex = 0;
			int wEnd = -1;
			for (int k = wIndex + 1; k <= msg.length(); k++) {
				// System.out.println("sbscheck " + msg.substring(wIndex, k));
				if (map.containsKey(msg.substring(wIndex, k))) {
					wEnd = k;
				}
			}
			String w = msg.substring(wIndex, wEnd);
			String c = wEnd < msg.length() ? msg.charAt(wEnd) + "" : "";
			list.add(map.get(w));
			if (c.equals(""))
				break;
			if (!map.containsKey(w + c)) {
				map.put(w + c, up++);
			}
			wIndex = wEnd;
		}
		int a = 0;
		int answer[] = new int[list.size()];
		for (int q : list) {
			answer[a++] = q;
		}
		return answer;
	}
}
