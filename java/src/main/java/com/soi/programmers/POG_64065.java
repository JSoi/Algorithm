package com.soi.programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class POG_64065 {

    public static void main(String[] args) {

        solution("{{2},{2,1},{2,1,3},{2,1,3,4}}");
        solution("{{1,2,3},{2,1},{1,2,4,3},{2}}");
        solution("{{20,111},{111}}");
    }

    public static int[] solution(String s) {
        String lists = s.substring(1, s.length() - 1);
        ArrayList<String> tArr = new ArrayList<String>();
        String tempStr = "";
        for (int k = 0; k < lists.length(); k++) {
            char compare = lists.charAt(k);
            if (compare == '{') {
                continue;
            } else if (compare == '}') {
                k += 2;
                tArr.add(tempStr);
                tempStr = "";
            } else {
                tempStr += compare;
            }
        }

        ArrayList<Integer> arr = new ArrayList<Integer>();
        Collections.sort(tArr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() > o2.length())
                    return 1;
                else
                    return -1;
            }
        });

        for (int i = 0; i < tArr.size(); i++) {
            String singleTuple = tArr.get(i);
            String[] sep = singleTuple.split(",");
            for (String a : sep) {
                int val = Integer.parseInt(a);
                if (!arr.contains(val))
                    arr.add(val);
            }
        }

        int[] answer = new int[arr.size()];
        int answerIndex = 0;
        for (int set : arr) {
            answer[answerIndex] = set;
            System.out.print(set + " / ");
        }
        System.out.println();

        return answer;
    }
}
