package com.soi.programmers;

import java.util.Collections;
import java.util.PriorityQueue;

public class POG_42629 {

    public static void main(String[] args) {

        System.out.println(solution(4, new int[]{4, 10, 15}, new int[]{20, 5, 10}, 30));
    }

    public static int solution(int stock, int[] dates, int[] supplies, int k) {
        int answer = 0;
        int day = stock;
        int index = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        while (day < k) {
            System.out.println("Day Index : " + day);
            while (index < dates.length && dates[index] <= day) {


                pq.add(supplies[index]);
                index++;
                System.out.println(pq);
            }
            day += pq.poll();

            answer++;
            System.out.println(pq);
        }
        return answer;
    }

}
