package baekjoon;
import java.util.Scanner;

public class N11720 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num = Integer.parseInt(scan.nextLine());
		String myInput = scan.next();
		char strtochar[] = new char[num];
		strtochar = myInput.toCharArray();
		int result = 0;
		for(int i = 0; i <strtochar.length; i++) {
			result+= strtochar[i]-48;
		}
		System.out.println(result);
		scan.close();
	
	}
}
