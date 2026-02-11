package com.soi.programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class POG_17686 {

    public static void main(String[] args) {

        solution(new String[]{"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"});
    }

    static String[] solution(String[] files) {
        ArrayList<String> ans = new ArrayList<String>();
        Collections.addAll(ans, files);
        Comparator<String> comp = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {

                String[] arr1 = split(o1.toLowerCase());
                String[] arr2 = split(o2.toLowerCase());

                if (arr1[0].compareTo(arr2[0]) != 0) {
                    return arr1[0].compareTo(arr2[0]);
                } else {
                    int aa1 = Integer.parseInt(arr1[1]);
                    int aa2 = Integer.parseInt(arr2[1]);
                    if (aa1 == aa2)
                        return 0;
                    else if (aa1 > aa2)
                        return 1;
                    else {
                        return -1;
                    }
                }
            }
        };
        Collections.sort(ans, comp);
        String[] answer = new String[files.length];
        int answerI = 0;
        for (String a : ans) {
            answer[answerI++] = a;
            System.out.println(a);
        }
        return answer;
    }

    static String[] split(String input) {
        String head = "";
        String number = "";
        String tail = "";
        int index = 0;
        for (index = 0; index < input.length(); index++) {
            char c = input.charAt(index);
            char next = index + 1 < input.length() ? input.charAt(index + 1) : ' ';
            head += c;
            if (next >= '0' && next <= '9') {
                break;
            }
        }
        input = index + 1 < input.length() ? input.substring(index + 1) : "";
        index = 0;
        for (index = 0; index < input.length(); index++) {
            char c = input.charAt(index);
            char next = index + 1 < input.length() ? input.charAt(index + 1) : ' ';
            number += c;
            if (next < '0' || next > '9') {
                break;
            }
        }
        tail = index + 1 < input.length() ? input.substring(index + 1) : "";

        String[] ans = new String[3];
        ans[0] = head;
        ans[1] = number;
        ans[2] = tail;
        return ans;
    }
}
