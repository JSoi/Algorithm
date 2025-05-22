package programmers;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class L340210 {
    public static void main(String[] args) {
        String[] solution = new Solution().solution(new String[]{"2 - 1 = 1", "2 + 2 = X", "7 + 4 = X", "8 + 4 = X"});
        System.out.println(Arrays.toString(solution));
    }

    static class Solution {
        private List<String> question;
        private Set<String> evidence;

        public String[] solution(String[] expressions) {
            question = new ArrayList<>();
            evidence = new HashSet<>();
            boolean[] isValidNum = new boolean[10];
            Arrays.fill(isValidNum, true);
            isValidNum[0] = isValidNum[1] = false;
            for (String e : expressions) {
                for (int i = 0; i <= getMaxNum(e); i++) {
                    isValidNum[i] = false;
                }
                if (e.contains("X")) {
                    question.add(e);
                } else {
                    evidence.add(e);
                }
            }
            for (String e : evidence) {
                for (int i = 2; i <= 9; i++) {
                    if (!isValidNum[i]) {
                        continue;
                    }
                    if (!isValid(e, i)) {
                        isValidNum[i] = false;
                    }
                }
            }
            String[] answer = new String[question.size()];
            int answerIndex = 0;
            for (String q : question) {
                List<Integer> answerList =
                        IntStream.range(2, 10).filter(i -> isValidNum[i])
                                .map(i -> calculate(q, i)).distinct().boxed().collect(Collectors.toList());
                answer[answerIndex++] = q.replace("X", answerList.size() == 1 ? String.valueOf(answerList.get(0)) : "?");
            }
            return answer;
        }

        private boolean isValid(String question, int a) {
            String[] val = question.split(" ");// num, operand, num, = , num
            try {
                int num1 = Integer.parseInt(val[0], a);
                int num2 = Integer.parseInt(val[2], a);
                int result = Integer.parseInt(val[4], a);
                int calculatedResult = switch (val[1]) {
                    case "+" -> num1 + num2;
                    case "-" -> num1 - num2;
                    default -> throw new IllegalStateException("Unexpected value: " + val[1]);
                };
                return calculatedResult == result;
            } catch (NumberFormatException e) {
                return false;
            }
        }

        private int calculate(String question, int a) {
            String[] val = question.split(" ");// num, operand, num, = , num
            try {
                int num1 = Integer.parseInt(val[0], a);
                int num2 = Integer.parseInt(val[2], a);
                int calculatedResult = switch (val[1]) {
                    case "+" -> num1 + num2;
                    case "-" -> num1 - num2;
                    default -> throw new IllegalStateException("Unexpected value: " + val[1]);
                };
                return Integer.parseInt(Integer.toUnsignedString(calculatedResult, a));
            } catch (NumberFormatException e) {
                return -1;
            }
        }

        private int getMaxNum(String string) {
            char[] onlyNum = string.replaceAll("[X+\\-,= ]", "").toCharArray();
            Arrays.sort(onlyNum);
            return Character.getNumericValue(onlyNum[onlyNum.length - 1]);
        }
    }
}
