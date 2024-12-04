package baekjoon;
import java.util.Scanner;

public class N2292 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		long userInteger = scan.nextInt();
		scan.close();
		long lastNum = 1;
		long timeCal = 0;
		while (true) {
			if (lastNum <= userInteger && userInteger <= lastNum + timeCal * 6) {
				break;
			}
			lastNum += timeCal * 6;
			timeCal++;
		}
		System.out.println(timeCal+1);
	}

}