package baekjoon;
import java.util.Scanner;

public class N1110 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int origin = scan.nextInt();
		int target = -1;
		int trial = 0;
		if (origin < 10) {
			origin *= 10;
		}
		target = origin;
		while (true) {
			int sip = target / 10;
			int il = target % 10;
			int basetarget = (sip + il) % 10;
			target = il * 10 + basetarget;
			trial++;
			if(origin == target) {
				break;
			}
		} 
		System.out.println(trial);
		scan.close();
	}
}
