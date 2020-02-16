package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class N1271 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		BigInteger n = new BigInteger((line.split(" ")[0]));
		BigInteger m = new BigInteger((line.split(" ")[1]));
		StringBuffer buf = new StringBuffer();
		buf.append(n.divide(m) + "\n");
		buf.append(n.subtract(m.multiply(n.divide(m))));
		System.out.print(buf.toString());
	}

}
