package baekjoon;

import java.io.*;

public class N1052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);
        int bottles = 0;
        while (Integer.bitCount(N) > K) {
            N++;
            bottles++;
        }
        bw.write(String.valueOf(bottles));
        bw.flush();
        bw.close();
        br.close();
    }
}
