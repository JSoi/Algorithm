package com.soi.programmers;

import com.soi.tool.Assertions;

/**
 * <a href ="https://school.programmers.co.kr/learn/courses/30/lessons/148653">마법의 엘리베이터</a>
 */
public class L148653 {
    public static void main(String[] args) throws Exception {
        Assertions.check(new L148653().solution(9555), 14);
    }

    // bottom-up
    public int solution(int storey) {
        int answer = 0;
        while (storey > 0) {
            int digit = storey % 10;
            int movePoint;
            int storeyChange;
            if (digit > 5) {
                movePoint = 10 - digit;
                storeyChange = movePoint;
            } else if (digit < 5) {
                movePoint = digit;
                storeyChange = -digit;
            } else {
                movePoint = digit;
                if (((storey + movePoint) / 10) % 10 == 0 || ((storey + movePoint) / 10) % 10 > 5) {
                    storeyChange = 5;
                } else {
                    storeyChange = -5;
                }
            }
            answer += movePoint;
            storey += storeyChange;
            storey /= 10;
        }
        return answer;
    }
}
