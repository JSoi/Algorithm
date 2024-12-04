package baekjoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class N2309_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		List<Integer> list = new ArrayList<>();
		int hapTotal = 0;
		for (int i = 0; i < 9; i++) {
			int val = scan.nextInt();
			list.add(val);
			hapTotal += val;
		}
		int diff = hapTotal - 100;
		int i, j = 0;
		loop: for (i = 0; i < 8; i++) {
			for (j = i + 1; j < 9; j++) {
				if (list.get(i) + list.get(j) == diff) {
					break loop;
				}
			}
		}
		list.remove(j);
		list.remove(i);
		Collections.sort(list);
		for (int l : list) {
			System.out.println(l);
		}
	}

}
