package programmers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a href = "https://school.programmers.co.kr/learn/courses/30/lessons/138476">귤 고르기</a>
 */
public class L138476 {
    public static void main(String[] args) {
            int k = 6;
        int[] tangerine = new int[]{1, 3, 2, 5, 4, 5, 2, 3};
        System.out.println(solution(k, tangerine));
    }

    public static int solution(int k, int[] tangerine) {
        int answer = 0;
        HashMap<Integer, Integer> weightMap = new HashMap<>();
        for (int t : tangerine) {
            weightMap.put(t, weightMap.getOrDefault(t, 0) + 1);
        }
        System.out.println(weightMap);
        List<Map.Entry<Integer, Integer>> entryList = weightMap.entrySet().stream()
                .sorted((e1,e2)->(e2.getValue()-e1.getValue())).toList();
        for (int count = 0; count < k; count++) {
            count += entryList.get(answer++).getValue();
        }
        return answer;
    }
}
