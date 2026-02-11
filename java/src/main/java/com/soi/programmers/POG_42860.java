package com.soi.programmers;

public class POG_42860 {

    public static void main(String[] args) {


        System.out.println(solution("JEROEN"));
    }

    public static int solution(String name) {
        int answer = 0;
        for (int i = 0; i < name.length(); i++) {

            int up = name.charAt(i) - 'A';
            int down = 'Z' + 1 - name.charAt(i);
            answer += Math.min(up, down);
        }
        int minMove = name.length() - 1;
        for (int j = 0; j < name.length(); j++) {
            if (name.charAt(j) != 'A') {
                int n;
                for (n = j + 1; n < name.length(); n++) {
                    if (name.charAt(n) != 'A') {
                        break;
                    }
                }
                int move = j * 2 + name.length() - n;
                minMove = Math.min(move, minMove);
            }
        }
        return answer + minMove;
    }

}
