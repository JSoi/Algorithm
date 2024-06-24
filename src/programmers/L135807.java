package programmers;

import java.util.*;
import java.util.stream.Collectors;

public class L135807 {
    public static void main(String[] args) {
        int solution = new L135807().solution(new int[]{10, 17}, new int[]{5, 20});
        int solution2 = new L135807().solution(new int[]{10, 20}, new int[]{5, 17});
        int solution3 = new L135807().solution(new int[]{14, 35, 119}, new int[]{18, 30, 102});
        System.out.println(solution);
        System.out.println(solution2);
        System.out.println(solution3);
    }

    public int solution(int[] arrayA, int[] arrayB) {
        List<Integer> integers = Arrays.stream(arrayA).boxed().collect(Collectors.toList());
        List<Integer> answer = getYaksu(integers.get(0));
        for (int i = 1; i < integers.size(); i++) {
            if (answer.isEmpty()) {
                return 0;
            }
            Set<Integer> miniYaksu = new HashSet<>(getYaksu(integers.get(i)));
            answer.removeIf(a -> !miniYaksu.contains(a));
        }
        System.out.println(answer);
        HashSet<Integer> bSet = new HashSet<>();
        for (int i : arrayB) {
            bSet.addAll(getYaksu(i));
        }
        answer.removeIf(bSet::contains);
        return answer.isEmpty() ? 0 : answer.get(answer.size() - 1);
    }

    public List<Integer> getYaksu(int input) {
        ArrayList<Integer> yaksu = new ArrayList<>();
        for (int i = 1; i <= input; i++) {
            if (input % i == 0) {
                yaksu.add(i);
            }
        }
        return yaksu;
    }
}
