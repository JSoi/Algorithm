package baekjoon;
import java.util.Scanner;

public class N2741 {
	public static void main(String[] args) {
		Scanner scan =  new Scanner(System.in);
		int myNum = scan.nextInt();
		for(int i = 1; i <= myNum; i++) {
			System.out.println(i);
		}
		scan.close();
	}
}
