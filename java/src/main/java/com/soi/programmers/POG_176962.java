package com.soi.programmers;

import java.util.*;

/**
 * <a href="https://school.programmers.co.kr/learn/courses/30/lessons/176962">과제 진행하기</a>
 */
public class POG_176962 {
    public static void main(String[] args) {
        String[] s1 = new POG_176962().solution(new String[][]{{"korean", "11:40", "30"}, {"english", "12:10", "20"}, {"math", "12:30", "40"}});
        System.out.println(Arrays.toString(s1));
    }

    public String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];
        List<String> answerList = new ArrayList<>();

        Queue<Plan> newPlans = new PriorityQueue<>();
        Stack<Plan> delayedPlans = new Stack<>();
        for (String[] p : plans) {
            Plan newPlan = new Plan(p[0], p[1], Integer.parseInt(p[2]));
            newPlans.offer(newPlan);
        }
        int endTime = newPlans.peek().start + newPlans.peek().time;
        Plan planNow = null;
        while (!newPlans.isEmpty()) {
            if (newPlans.peek().start == endTime) {
                planNow = newPlans.poll();
            } else if (newPlans.peek().start < endTime) { // 새로운 일로 교체
                Plan delayedPlan = planNow;
                planNow = newPlans.poll();
                if (delayedPlan != null) {
                    delayedPlans.push(new Plan(delayedPlan.name, delayedPlan.start, delayedPlan.time - (planNow.start - delayedPlan.start)));
                }
            } else { // 새로운 일이 더 늦게 시작
                // 대기 목록이 있으면 먼저 처리
                if (!delayedPlans.isEmpty() && endTime < newPlans.peek().start) {
                    planNow = delayedPlans.pop();
                    planNow.setStart(endTime);
                } else {
                    planNow = newPlans.poll();
                }
            }
            endTime = planNow.start + planNow.time;
            // 계산이 모두 끝난 후 시간을 기준으로 답에 더해 줌
            if (newPlans.isEmpty() || endTime <= newPlans.peek().start) {
                answerList.add(planNow.name);
            }

        }
        while (!delayedPlans.isEmpty()) {
            answerList.add(delayedPlans.pop().name);
        }
        return answerList.toArray(answer);
    }

    static class Plan implements Comparable<Plan> {
        int start;
        int time;
        String name;

        public Plan(String name, String start, int time) {
            this.start = Integer.parseInt(start.split(":")[0]) * 60 +
                    Integer.parseInt(start.split(":")[1]);
            this.time = time;
            this.name = name;
        }

        public Plan(String name, int start, int time) {
            this.start = start;
            this.time = time;
            this.name = name;
        }

        public void setStart(int start) {
            this.start = start;
        }

        @Override
        public int compareTo(Plan plan) {
            return this.start - plan.start;
        }
    }

}
