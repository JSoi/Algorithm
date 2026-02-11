package com.soi.programmers;

public class POG_131705 {
    static int answer;
    static int[] studentNumArr;

    public static void main(String[] args) {
        System.out.println(solution(new int[]{-2, 3, 0, 2, -5}));
        System.out.println(solution(new int[]{-3, -2, -1, 0, 1, 2, 3}));
        System.out.println(solution(new int[]{-1, 1, -1, 1}));
    }

    public static int solution(int[] number) {
//        studentNumArr = number;
//        answer = 0;
//        search(0, 0, 0);
//        return answer;
        return countCombinations(number, 0, 0, 0);
    }

    static void search(int index, int selectedCount, int sum) {
        if (selectedCount == 3) {
            if (sum == 0) {
                answer++;
            }
            return;
        }
        if (index >= studentNumArr.length) {
            return;
        }
        search(index + 1, selectedCount + 1, sum + studentNumArr[index]);
        search(index + 1, selectedCount, sum);
    }


    private static int countCombinations(int[] numbers, int index, int selectedCount, int sum) {
        if (selectedCount == 3) {
            return sum == 0 ? 1 : 0;
        }
        if (index >= numbers.length) {
            return 0;
        }

        int include = countCombinations(numbers, index + 1, selectedCount + 1, sum + numbers[index]);
        int exclude = countCombinations(numbers, index + 1, selectedCount, sum);
        return include + exclude;
    }
}
