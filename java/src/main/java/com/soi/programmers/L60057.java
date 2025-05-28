package com.soi.programmers;

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
				if (smallre == 1) { // �ߺ��� ���� �����ϰ�� �״�� �����ش�
					flen += strs;
				} else { // �ߺ��� �ִ� �����ϰ�� �� Ƚ���� �Բ� �����ش�
					flen += smallre + strs;
				}
				flen += s.substring(start, s.length());
				//System.out.println("Bstart : " + start + " / Bend : " + (start + len));
				break;
			}
			//System.out.println("start : " + start + " / end : " + (start + len));
			String compare = s.substring(start, start + len);
			if (strs.equals(compare)) {// ���� ���ڿ��� ������
				smallre++; // �ݺ�Ƚ���� 1 �����ش�
			} else { // ���� ���ڿ��� �ٸ���
				// [������ �ִ� �� �ǵ�������]
				if (smallre == 1) { // �ߺ��� ���� �����ϰ�� �״�� �����ش�
					flen += strs;
				} else { // �ߺ��� �ִ� �����ϰ�� �� Ƚ���� �Բ� �����ش�
					flen += smallre + strs;
				}
				strs = compare; // ������ �Ǵ� ���ڿ��� ������Ʈ
				smallre = 1;
			}
			if (start + len == s.length()) {
				if (smallre == 1) { // �ߺ��� ���� �����ϰ�� �״�� �����ش�
					flen += strs;
				} else { // �ߺ��� �ִ� �����ϰ�� �� Ƚ���� �Բ� �����ش�
					flen += smallre + strs;
				}
				//System.out.println("Estart : " + start + " / Eend : " + (start + len));
			}

		}
		//System.out.println(flen);
		return flen.length();
	}
}
