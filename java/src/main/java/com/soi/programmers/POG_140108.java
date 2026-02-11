package com.soi.programmers;

public class POG_140108 {
    public int solution(String s) {
        int answer = 0;
        Character now = null;
        int targetCount = 0;
        int otherCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (now == null) {
                now = s.charAt(i);
                targetCount = 1;
                answer++;
            } else {
                if (now == s.charAt(i)) {
                    targetCount++;
                } else {
                    otherCount++;
                }
                if (targetCount == otherCount) {
                    now = null;
                    targetCount = otherCount = 0;
                }
            }

        }
        return answer;
    }

}
