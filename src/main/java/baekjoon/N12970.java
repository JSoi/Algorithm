package baekjoon;

import java.util.Scanner;

public class N12970 {
    private static int k;
    private static int n;
    private static String answer = "";

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        k = scan.nextInt();
        scan.close();
        count("", 0, 0);
        System.out.println(answer.isEmpty() ? -1 : answer);
    }

    static void count(String curr, int bCount, int conditionCount) {
        if (curr.length() == n) {
            if (conditionCount == k) {
                answer = curr;
            }
            return;
        }
        count("A" + curr, bCount, conditionCount + bCount);
        count("B" + curr, bCount + 1, conditionCount);
    }
}
