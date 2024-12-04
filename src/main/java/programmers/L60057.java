package programmers;

import java.util.Scanner;

public class L60057 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		String m = scan.next(); // M<=N
		scan.close();
		int smalllength = m.length();
		for (int i = 1; i < m.length() / 2; i++) {
			int smallsolval = smallsol(m, i);
			if (smallsolval <= smalllength)
				smalllength = smallsolval;
		}
		System.out.println(smalllength);
	}

	public static int smallsol(String s, int len) {
		String strs = "";
		String flen = "";
		int smallre = 1;
		for (int start = 0; start < s.length(); start += len) {
			if (start + len > s.length()) {
				if (smallre == 1) { // 중복이 없는 문자일경우 그대로 더해준다
					flen += strs;
				} else { // 중복이 있는 문자일경우 그 횟수와 함께 더해준다
					flen += smallre + strs;
				}
				flen += s.substring(start, s.length());
				//System.out.println("Bstart : " + start + " / Bend : " + (start + len));
				break;
			}
			//System.out.println("start : " + start + " / end : " + (start + len));
			String compare = s.substring(start, start + len);
			if (strs.equals(compare)) {// 이전 문자열과 같을때
				smallre++; // 반복횟수를 1 더해준다
			} else { // 이전 문자열과 다를때
				// [변수에 있는 값 되돌려주자]
				if (smallre == 1) { // 중복이 없는 문자일경우 그대로 더해준다
					flen += strs;
				} else { // 중복이 있는 문자일경우 그 횟수와 함께 더해준다
					flen += smallre + strs;
				}
				strs = compare; // 기준이 되는 문자열을 업데이트
				smallre = 1;
			}
			if (start + len == s.length()) {
				if (smallre == 1) { // 중복이 없는 문자일경우 그대로 더해준다
					flen += strs;
				} else { // 중복이 있는 문자일경우 그 횟수와 함께 더해준다
					flen += smallre + strs;
				}
				//System.out.println("Estart : " + start + " / Eend : " + (start + len));
			}

		}
		//System.out.println(flen);
		return flen.length();
	}
}
