package com.soi.programmers;

import java.util.Arrays;
import java.util.Map;

public class L172928 {

    public static int[] solution(String[] park, String[] routes) {
        boolean[][] road = new boolean[park.length][park[0].length()];
        Map<Character, int[]> move = Map.of('N', new int[]{-1, 0}, 'S', new int[]{1, 0}, 'W', new int[]{0, -1}, 'E', new int[]{0, 1});
        int startX = 0, startY = 0;
        for (int x = 0; x < park.length; x++) {
            String oneLine = park[x];
            for (int y = 0; y < oneLine.length(); y++) {
                if (oneLine.charAt(y) == 'X') {
                    continue;
                }
                if (oneLine.charAt(y) == 'S') {
                    startX = x;
                    startY = y;
                }
                road[x][y] = true;
            }
        }
        int nowX = startX, nowY = startY;
        for (String r : routes) {
            Character dir = r.split(" ")[0].charAt(0);
            int amount = Integer.parseInt(r.split(" ")[1]);
            int tempX = nowX;
            int tempY = nowY;
            int i;
            for (i = 0; i < amount; i++) {
                tempX += move.get(dir)[0];
                tempY += move.get(dir)[1];
                if (tempX < 0 || tempX >= road.length || tempY < 0 || tempY >= road[0].length
                        || !road[tempX][tempY]) {
                    break;
                }
            }
            if (i < amount) {
                continue;
            }
            nowX = tempX;
            nowY = tempY;
        }
        return new int[]{nowX, nowY};
    }

    public static void main(String[] args) {
        String[] park = {"SOO", "OOO", "OOO" };
        String[] routes = {"E 2", "S 2", "W 1" };


        String[] park2 = {"SOO", "OXX", "OOO" };
        String[] routes2 = {"E 2", "S 2", "W 1" };


        String[] park3 = {"OSO", "OOO", "OXO", "OOO" };
        String[] routes3 = {"E 2", "S 3", "W 1" };
//        int[] result = solution(park, routes);
//        int[] result = solution(park2, routes2);
        int[] result = solution(park3, routes3);
        System.out.println(Arrays.toString(result));
    }

}
