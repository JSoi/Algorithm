package com.soi.programmers;

public class L72410 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution("=.="));
	}

	/**
	 * 1�ܰ� new_id�� ��� �빮�ڸ� �����Ǵ� �ҹ��ڷ� ġȯ�մϴ�. 2�ܰ� new_id���� ���ĺ� �ҹ���, ����, ����(-), ����(_),
	 * ��ħǥ(.)�� ������ ��� ���ڸ� �����մϴ�. 3�ܰ� new_id���� ��ħǥ(.)�� 2�� �̻� ���ӵ� �κ��� �ϳ��� ��ħǥ(.)��
	 * ġȯ�մϴ�. 4�ܰ� new_id���� ��ħǥ(.)�� ó���̳� ���� ��ġ�Ѵٸ� �����մϴ�. 5�ܰ� new_id�� �� ���ڿ��̶��,
	 * new_id�� "a"�� �����մϴ�. 6�ܰ� new_id�� ���̰� 16�� �̻��̸�, new_id�� ù 15���� ���ڸ� ������ ������ ���ڵ���
	 * ��� �����մϴ�. ���� ���� �� ��ħǥ(.)�� new_id�� ���� ��ġ�Ѵٸ� ���� ��ġ�� ��ħǥ(.) ���ڸ� �����մϴ�. 7�ܰ�
	 * new_id�� ���̰� 2�� ���϶��, new_id�� ������ ���ڸ� new_id�� ���̰� 3�� �� ������ �ݺ��ؼ� ���� ���Դϴ�.
	 */

	public static String solution(String new_id) {
		new_id = new_id.toLowerCase();// 1
		String tempni = "";
		for (int j = 0; j < new_id.length(); j++) {// 2
			if ("abcdefghijklmnopqrstuvwxyz0123456789-_.".contains(new_id.charAt(j) + "")) {
				tempni += new_id.charAt(j);
			}
		}
		new_id = tempni;
		while (new_id.contains("..")) {// 3
			new_id = new_id.replace("..", ".");
		}
		if (new_id.length() > 0 && new_id.charAt(0) == '.') {// 4-1
			new_id = new_id.length() == 1 ? "" : new_id.substring(1, new_id.length());
		}
		if (new_id.length() > 0 && new_id.charAt(new_id.length() == 1 ? 0 : new_id.length() - 1) == '.') {// 4-2
			new_id = new_id.length() == 1 ? "" : new_id.substring(0, new_id.length() - 1);
		}
		if (new_id.length() == 0) {
			new_id = "a";
		}
		if (new_id.length() >= 16) {
			if (new_id.charAt(14) == '.') {
				new_id = new_id.substring(0, 14);
			} else {
				new_id = new_id.substring(0, 15);
			}
		}
		if (new_id.length() <= 2) {
			char target = new_id.charAt(new_id.length() - 1);
			while (new_id.length() < 3) {
				new_id += target;
			}
		}
		return new_id;
	}
}
