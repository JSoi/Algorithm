package com.soi.programmers;

import java.util.Arrays;

public class POG_70130 {
    public static void main(String[] args) {
//        System.out.println(solution(new int[]{0}));
//        System.out.println(solution(new int[]{0, 1}));
        System.out.println(solution(new int[]{5, 2, 3, 3, 5, 3}));
//        System.out.println(solution(new int[]{0, 3, 3, 0, 7, 2, 0, 2, 2, 0}));
    }


    public static int solution(int[] a) {
        int len = a.length;
        if (len == 1) {
            return 0;
        }
        int[] count = new int[len + 1];
        int[] idxArr = new int[len + 1]; // 사용한 페어의 인덱스 저장
        Arrays.fill(idxArr, -1);

        if (a[0] != a[1]) {
            count[a[0]]++;
            idxArr[a[0]] = 1;
        }

        for (int i = 1; i < len - 1; i++) {
            if (a[i] != a[i - 1] && idxArr[a[i]] != i - 1) {
                idxArr[a[i]] = i - 1;
                count[a[i]]++;
            } else if (a[i] != a[i + 1] && idxArr[a[i]] != i + 1) {
                idxArr[a[i]] = i + 1;
                count[a[i]]++;
            }
        }

        if (a[len - 1] != a[len - 2] && idxArr[a[len - 1]] != len - 2) {
            count[a[len - 1]]++;
            idxArr[a[len - 1]] = len - 2;
        }

//        System.out.println(Arrays.toString(count));
        return Arrays.stream(count).max().orElse(0) * 2;
    }

}
