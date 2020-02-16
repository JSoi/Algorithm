package baekjoon;

import java.util.Scanner;

public class N9517 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int startperson = scan.nextInt();
		int questionnum = scan.nextInt();
		int boomperson = startperson;
		int time = 0;
		for (int i = 0; i < questionnum; i++) {
			int sec = scan.nextInt();
			String tnp = scan.next();
			time += sec;
			if (time >= 210) {
				System.out.println(boomperson);
				return;
			}
			if (tnp.equals("T")) {
				boomperson++;
				if (boomperson > 8) {
					boomperson = 1;
				}
			}
		}
		scan.close();
		System.out.println(boomperson);
	}

}
