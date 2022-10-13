package programmers;

import java.util.HashMap;
import java.util.Map;

public class L118666 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new String[]{"AN", "CF", "MJ", "RT", "NA"}, new int[]{5, 3, 2, 7, 5}));
    }

    static class Solution {
        Map<String, Integer> scoreMap = new HashMap<>();

        public String solution(String[] survey, int[] choices) {
            init();
            for (int i = 0; i < survey.length; i++) {
                if (choices[i] <= 3) {
                    String key = survey[i].charAt(0) + "";
                    int val = 4 - choices[i];
                    scoreMap.put(key, scoreMap.get(key) + val);
                } else if (choices[i] >= 5) {
                    String key = survey[i].charAt(1) + "";
                    int val = choices[i] - 4;
                    scoreMap.put(key, scoreMap.get(key) + val);
                }
            }
            System.out.println("scoreMap = " + scoreMap);
            return getType();

        }

        public void init() {
            String[] character = {"R", "T", "C", "F", "J", "M", "A", "N"};
            for (String c : character) {
                scoreMap.put(c, 0);
            }
        }

        public String getType() {
            String type = "";
            if (scoreMap.get("R") >= scoreMap.get("T")) {
                type += "R";
            } else {
                type += "T";
            }

            if (scoreMap.get("C") >= scoreMap.get("F")) {
                type += "C";
            } else {
                type += "F";
            }

            if (scoreMap.get("J") >= scoreMap.get("M")) {
                type += "J";
            } else {
                type += "M";
            }

            if (scoreMap.get("A") >= scoreMap.get("N")) {
                type += "A";
            } else {
                type += "N";
            }
            return type;
        }

    }
}
