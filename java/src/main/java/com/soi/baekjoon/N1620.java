package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class N1620 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        String line = buf.readLine();
        int dictCount = Integer.parseInt(line.split(" ")[0]);
        int questionCount = Integer.parseInt(line.split(" ")[1]);
        HashMap<String, Integer> nameToIndexMap = new HashMap<>();
        String[] nameArr = new String[dictCount + 1];
        for (int i = 0; i < dictCount; i++) {
            String name = buf.readLine();
            nameArr[i + 1] = name;
            nameToIndexMap.put(name, i + 1);
        }
        StringBuffer aBuf = new StringBuffer();
        for (int q = 0; q < questionCount; q++) {
            String question = buf.readLine();
            if (isDigit(question)) {
                aBuf.append(nameArr[Integer.parseInt(question)]).append("\n");
            } else {
                aBuf.append(nameToIndexMap.get(question)).append("\n");
            }
        }
        System.out.print(aBuf);
    }

    private static boolean isDigit(String input) {
        for (char i : input.toCharArray()) {
            if (i < '0' || i > '9') {
                return false;
            }
        }
        return true;
    }
}
