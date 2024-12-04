package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * DP 문제
 */

public class N1324 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        int[] firstTrashArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] secondTrashArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        solution(firstTrashArr, secondTrashArr);
    }

    public static void solution(int[] firstTrashArr, int[] secondTrashArr){
        int secondIndex = secondTrashArr.length - 1;
        int bf = -1;
        int answer = 0;
        for (int i = firstTrashArr.length - 1; i >= 0; i--) {
            if (bf != -1 && bf <= firstTrashArr[i]) {
                continue;
            }
            for (int j = secondIndex; j >= 0; j--) {
                if (firstTrashArr[i] == secondTrashArr[j] ) {
                    bf = firstTrashArr[i];
                    secondIndex = j - 1;
                    answer++;
                    break;
                }
            }
        }
        System.out.println(answer);
    }
}