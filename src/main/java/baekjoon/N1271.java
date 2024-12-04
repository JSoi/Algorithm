package baekjoon;

import java.math.BigInteger;
import java.util.Scanner;

public class N1271 {

	public static void main(String[] args){
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		String line = scan.nextLine();
		scan.close();
		BigInteger n = new BigInteger((line.split(" ")[0]));
		BigInteger m = new BigInteger((line.split(" ")[1]));
		System.out.print(n.divide(m) + "\n");
		System.out.print(n.subtract(m.multiply(n.divide(m))));
	}

}
