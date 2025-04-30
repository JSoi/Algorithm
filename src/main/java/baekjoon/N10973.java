package baekjoon;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class N10973 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int c = scan.nextInt();
        int[] arr = new int[c];
        for (int i = 0; i < c; i++) {
            arr[i] = scan.nextInt();
        }
        scan.close();
        int i = c - 1;
        boolean hasDecreased = false;
        while (i >= 1) {
            if (arr[i - 1] > arr[i]) {
                hasDecreased = true;
            }
            i--;
        }
        if (!hasDecreased) {
            System.out.println(-1);
            return;
        }

        int inc = c - 1;
        while (inc >= 1 && arr[inc - 1] < arr[inc]) {
            inc--;
        }

        if (inc == c - 1) { // 끝에서 시작해서 증가하는 부분이 없음
            loop:
            for (int j = c - 1; j >= i; j--) {
                for (int k = j - 1; k >= i; k--) {
                    if (arr[j] < arr[k]) {
                        int temp = arr[j];
                        arr[j] = arr[k];
                        arr[k] = temp;
                        break loop;
                    }
                }
            }
            printAnswer(arr);
        } else {
            int targetI = 0;
            int max = 0;
            for (int j = inc; j < c; j++) {
                if (arr[inc - 1] > arr[j] && arr[j] > max) {
                    max = arr[j];
                    targetI = j;
                }
            }
            swap(arr, targetI, inc - 1);
            sortDesc(arr, inc, c - 1);
            printAnswer(arr);
        }
    }

    private static void sortDesc(int[] arr, int start, int end) {
        int[] target = new int[end - start + 2];
        System.arraycopy(arr, start, target, 0, end - start + 1);
        Arrays.sort(target);
        for (int i = start; i <= end; i++) {
            arr[i] = target[end - start - (i - start) + 1];
        }
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void printAnswer(int[] arr) {
        System.out.println(Arrays.stream(arr).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
    }
}
