package programmers;

import java.util.*;

public class L72412 {

    public static void main(String[] args) {
        String[] info = {"java backend junior pizza 150", "python frontend senior chicken 210",
                "python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80",
                "python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100",
                "python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250",
                "- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150"};
        L72412 l72412 = new L72412();
        System.out.println(Arrays.toString(l72412.solution(info, query)));
    }

    static Map<String, ArrayList<Integer>> map;

    public static int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        map = new HashMap<>();
        String[][] sortedInfo =
                Arrays.stream(info).map(i -> i.replace(" and ", " ").split(" "))
                        .sorted((s1, s2) -> Integer.parseInt(s1[4]) - Integer.parseInt(s2[4])).toArray(String[][]::new);
        for (String[] i : sortedInfo) {
            createKeys(0, "", i);
        }
        int index = 0;
        for (String string : query) {
            String[] split = string.replace(" and ", " ").split(" ");
            String joinCondition = String.join("", split).replaceAll("[0-9]", "");
//            System.out.println(map.get(joinCondition));
            answer[index++] = map.get(joinCondition) == null ? 0 : count(map.get(joinCondition), Integer.parseInt(split[4]));
        }
        return answer;
    }

    static int count(List<Integer> pplScore, int target) {
        int start = 0;
        int end = pplScore.size() - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (pplScore.get(mid) < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return pplScore.size() - start;
    }


    static void createKeys(int index, String str, String[] condition) {
        if (index == 4) {
            map.putIfAbsent(str, new ArrayList<>());
            map.get(str).add(Integer.parseInt(condition[index]));
            return;
        }
        createKeys(index + 1, str + condition[index], condition);
        createKeys(index + 1, str + "-", condition);
    }
}
