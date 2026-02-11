package com.soi.programmers;

import java.util.ArrayList;

public class POG_17677 {

    public static void main(String[] args) {

        System.out.println(solution("FRANCE", "french"));
    }

    public static int solution(String str1, String str2) {
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();
        ArrayList<String> s1 = create(str1);
        ArrayList<String> s2 = create(str2);

        int hap = 0;
        int gyo = 0;
        for (int i = 0; i < s1.size(); i++) {
            for (int j = s2.size() - 1; j > -1; j--) {
                if (s1.get(i).equals(s2.get(j))) {
                    s2.remove(j);
                    gyo++;
                    break;
                }
            }
        }
        hap = s1.size() + s2.size();
        if (hap == 0)
            return 65336;
        int answer = (int) (((float) gyo / (float) hap) * 65536);
        return answer;
    }

    public static ArrayList<String> create(String input) {
        ArrayList<String> aList = new ArrayList<String>();
        for (int i = 0; i < input.length() - 1; i++) {
            char a = input.charAt(i);
            char b = input.charAt(i + 1);
            if (a < 'A' || a > 'Z' || b < 'A' || b > 'Z')
                continue;
            aList.add(input.charAt(i) + "" + input.charAt(i + 1));
        }
        return aList;
    }
}
