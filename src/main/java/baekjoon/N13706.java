package baekjoon;
import java.math.BigInteger;
import java.util.Scanner;

public class N13706 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		String line = scan.nextLine();
		BigInteger n = new BigInteger(line);
		scan.close();
		sqrt(n);
	}

	static void sqrt(BigInteger num) {
		BigInteger start = BigInteger.ONE;
		BigInteger end = num;
		BigInteger mid, square;

		while (start.compareTo(end) <= 0) {
			mid = (start.add(end)).divide(new BigInteger("2"));
			square = mid.multiply(mid);

			int compare = square.compareTo(num);
			if (compare == 0) {
				System.out.println(mid.toString());
				break;
			} else if (compare == -1) {

				start = mid.add(BigInteger.ONE);
			} else if (compare == 1) {

				end = mid.subtract(BigInteger.ONE);
			}
		}
	}
}
