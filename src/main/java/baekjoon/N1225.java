package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N1225 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        String a = input[0];
        String b = input[1];
        long aa = 0;
        long bb = 0;
        for (char c : a.toCharArray()) {
            aa += c - '0';
        }

        for (char c : b.toCharArray()) {
            bb += c - '0';
        }
        System.out.println(aa * bb);
    }
}
