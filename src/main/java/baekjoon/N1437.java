package baekjoon;

import java.io.IOException;
import java.util.Scanner;

public class N1437 {
    public static void main(String[] args) throws IOException {
        int n = new Scanner(System.in).nextInt();
        long answer = 1;
        if (n <= 3) {
            System.out.println(n);
            return;
        }
        while (n > 4) {
            answer *= 3;
            answer %= 10007;
            n -= 3;
        }
        answer *= n;
        answer %= 10007;
        System.out.println(answer);
    }
}
