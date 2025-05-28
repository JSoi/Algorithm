package com.soi.baekjoon;

import java.io.*;
import java.util.*;

public class N1599 {
    static Map<String, Integer> minsikMap;
    public static void main(String[] args) throws IOException {
        String minsikStr = "a b k d e g h i l m n 0 o p r s t u w y";
        minsikMap = new HashMap<>();
        int idx = 0;
        for (String m : minsikStr.split(" ")) {
            minsikMap.put(m, idx++);
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        ArrayList<String> strings = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            strings.add(br.readLine().replace("ng", "0"));
        }
        Collections.sort(strings, (a, b) -> compareMinsikStr(a, b));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (String s : strings) {
            bw.append(s.replace("0", "ng")).append("\n");
        }
        bw.flush();
    }

    private static int compareMinsikStr(String a, String b) {
        for (int i = 0; i < Math.min(a.length(), b.length()); i++) {
            int compareTo = minsikMap.get(String.valueOf(a.charAt(i))).compareTo(minsikMap.get(String.valueOf(b.charAt(i))));
            if (compareTo != 0) {
                return compareTo;
            }
        }
        return a.length() > b.length() ? 1 : -1;
    }
}
