package baekjoon;

import java.util.Scanner;

public class N1111 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }
        scan.close();
        if (arr.length <= 2) {
            if (arr.length == 1) {
                System.out.println("A");
            } else if (arr[0] == arr[1]) {
                System.out.println(arr[0]);
            } else {
                System.out.println("A");
            }
            return;
        }
        for (int i = -200; i <= 200; i++) {
            int num = arr[1] - arr[0] * i;
            int cnt = 2;
            while (arr[cnt] - arr[cnt - 1] * i == num) {
                if (cnt == n - 1) {
                    System.out.println(arr[n - 1] * i + num);
                    return;
                }
                cnt++;
            }
        }
        System.out.println("B");
    }
}
