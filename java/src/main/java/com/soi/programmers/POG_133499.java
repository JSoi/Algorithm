package com.soi.programmers;

public class POG_133499 {

    public static final String[] WORDS = new String[]{"aya", "ye", "woo", "ma"};

    public static void main(String[] args) {
        POG_133499 l133499 = new POG_133499();
        int solution = l133499.solution(new String[]{"aya", "yee", "u", "maa"});
        System.out.println(solution);


    }

    public int solution(String[] babbling) {
        int answer = 0;
        for (String b : babbling) {
            if (isPossible(b)) {
                answer++;
            }
        }
        return answer;
    }

    public boolean isPossible(String input) {
        StringBuilder buf = new StringBuilder(input);
        String lastStr = "";
        while (!buf.isEmpty()) {
            for (int wIndex = 0; wIndex < WORDS.length; wIndex++) {
                String w = WORDS[wIndex];
                String leftFirstStr = buf.substring(0, Math.min(w.length(), buf.length()));
                if (leftFirstStr.equals(w)) {
                    if (leftFirstStr.equals(lastStr)) {
                        return false;
                    }
                    lastStr = w;
                    buf.delete(0, w.length());
                    break;
                }
                if (wIndex == WORDS.length - 1) {
                    return false;
                }
//                System.out.println(buf);
            }
        }
        return true;
    }
}
