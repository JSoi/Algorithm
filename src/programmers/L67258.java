package programmers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class L67258 {
    public static void main(String[] args) {
        int[] solution = new L67258().solution(new String[]{"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"});
        System.out.println("solution = " + Arrays.toString(solution));
    }


    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        int minLength = Integer.MAX_VALUE;
        Set<String> gemSet = new HashSet<>(Arrays.asList(gems));
        for (int s = 0; s < gems.length; s++) {
            HashSet<String> localGemSet = new HashSet<>();
            for (int e = s; e < gems.length; e++) {
                localGemSet.add(gems[e]);
                if (localGemSet.size() == gemSet.size()) {
                    if (minLength > e - s + 1) {
                        minLength = e - s + 1;
                        answer[0] = s + 1;
                        answer[1] = e + 1;
                    }
                    break;
                }
            }
        }
        return answer;
    }


}
