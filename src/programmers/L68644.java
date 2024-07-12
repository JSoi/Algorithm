package programmers;


import java.util.Arrays;
import java.util.HashSet;

public class L68644 {
    public static void main(String[] args) throws Exception {
        int[] solution = new L68644().solution(new int[]{2, 1, 3, 4, 1});
        System.out.println(Arrays.toString(solution));
    }

    public int[] solution(int[] numbers) {
        HashSet<Integer> integers = new HashSet<>();
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                integers.add(numbers[i] + numbers[j]);
            }
        }
        return integers.stream().mapToInt(i -> i).sorted().toArray();
    }
}
