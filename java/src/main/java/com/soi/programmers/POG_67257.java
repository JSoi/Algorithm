package com.soi.programmers;

import java.util.ArrayList;
import java.util.HashSet;

public class POG_67257 {

    public static void main(String[] args) {

        System.out.println(solution("100-200*300-500+20"));
    }

    static long solution(String expression) {
        ArrayList<String> list = new ArrayList<String>();
        String strTemp = "";
        HashSet<String> set = new HashSet<String>();
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '-' || expression.charAt(i) == '+' || expression.charAt(i) == '*') {
                set.add(expression.charAt(i) + "");
                list.add(strTemp);
                list.add(expression.charAt(i) + "");
                strTemp = "";
            } else {
                strTemp += expression.charAt(i);
            }
        }
        list.add(strTemp);
        String[] op = new String[set.size()];
        System.arraycopy(set.toArray(), 0, op, 0, set.size());
        boolean[] visit = new boolean[op.length];
        ArrayList<String> priorList = new ArrayList<String>();
        mixOp(priorList, op, visit, "");
        long answer = 0;
        for (String p : priorList) {

            answer = Math.max(answer, Math.abs(miniSol(list, p)));
        }
        return answer;
    }

    static void mixOp(ArrayList<String> priorList, String[] opArr, boolean[] visit, String temp) {
        if (temp.length() == visit.length) {
            if (!priorList.contains(temp))
                priorList.add(temp);
            return;
        }
        for (int i = 0; i < opArr.length; i++) {
            if (!visit[i]) {
                visit[i] = true;
                mixOp(priorList, opArr, visit, temp + opArr[i]);
                visit[i] = false;
            }
        }
    }

    static Long miniSol(ArrayList<String> onv, String prior) {
        ArrayList<String> onv2 = new ArrayList<String>();
        onv2.addAll(onv);
        for (int p = 0; p < prior.length(); p++) {
            String target = prior.charAt(p) + "";
            while (true) {
                if (!onv2.contains(target)) {
                    break;
                }
                int targetIndex = onv2.indexOf(target);
                long a = Long.parseLong(onv2.get((targetIndex - 1)));
                long b = Long.parseLong(onv2.get(targetIndex + 1));
                long val = 0;
                switch (onv2.get(targetIndex)) {
                    case "+":
                        val = a + b;
                        break;
                    case "-":
                        val = a - b;
                        break;
                    case "*":
                        val = a * b;
                        break;
                }
                onv2.remove(targetIndex);
                onv2.remove(targetIndex);
                onv2.remove(targetIndex - 1);
                onv2.add(targetIndex - 1, val + "");
            }
        }
        return Long.parseLong(onv2.get(0));
    }
}
