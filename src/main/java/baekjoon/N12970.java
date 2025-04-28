package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class N12970 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        char[] s = new char[n];
        Arrays.fill(s, 'B');

        int aCount = 0;
        for (int i = 0; i < n; i++) {
            int cCount = n - i - 1;
            if (k >= cCount) {
                s[i] = 'A';
                k -= (cCount - aCount);
                aCount++;
            } else {
                int targetIdx = n - k + aCount - 1;
                if (targetIdx >= i && targetIdx < n) {
                    s[targetIdx] = 'A';
                    k = 0;
                }
                break;
            }
        }
        if (k != 0) {
            System.out.println(-1);
        } else {
            System.out.println(new String(s));
        }
    }

}
