package programmers;

import java.util.Map;

public class L84512 {
    final char[] characters = new char[]{'A', 'E', 'I', 'O', 'U'};
    final Map<Character, Integer> characterMap = Map.of('A', 0, 'E', 1, 'I', 2, 'O', 3, 'U', 4);

    public static void main(String[] args) {
        int solution = new L84512().solution("AAAAE");
        int solution2 = new L84512().solution("AAAE");
        int solution3 = new L84512().solution("I");
        int solution4 = new L84512().solution("EIO");
        System.out.println(solution);
        System.out.println(solution2);
        System.out.println(solution3);
        System.out.println(solution4);
    }

    public int solution(String word) {
        int answer = 1;
        StringBuilder builder = new StringBuilder("A");
        while (!builder.toString().equals(word)) {
            answer++;
            if (builder.length() < 5) {
                builder.append("A");
                continue;
            }
            while (builder.charAt(builder.length() - 1) == 'U') {
                builder.deleteCharAt(builder.length() - 1);
            }
            builder.setCharAt(builder.length() - 1, characters[characterMap.get(builder.charAt(builder.length() - 1)) + 1]);
        }
        return answer;
    }

}
