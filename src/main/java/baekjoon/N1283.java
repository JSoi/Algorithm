package baekjoon;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class N1283 {
    static Set<Character> shortcut = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int count = Integer.parseInt(br.readLine());
        for (int i = 0; i < count; i++) {
            String line = br.readLine();
            int idx = findIdx(line);
            if (idx == -1) {
                bw.append(line);
            } else {
                shortcut.add(Character.toUpperCase(line.charAt(idx)));
                bw.append(line.substring(0, idx));
                bw.append("[");
                bw.append(String.valueOf(line.charAt(idx)));
                bw.append("]");
                bw.append(line.substring(Math.min(idx + 1, line.length())));
            }
            bw.append('\n');
        }
        bw.flush();

    }

    static int findIdx(String line) {
        int wIdx = wordIdx(line);
        if (wIdx == -1) {
            return everyIdx(line);
        }
        return wIdx;
    }

    static int wordIdx(String line) {
        int idx = 0;
        for (String word : line.split(" ")) {
            if (!shortcut.contains(Character.toUpperCase(word.charAt(0)))) {
                return idx;
            }
            idx += word.length() + 1;
        }
        return -1;
    }

    static int everyIdx(String line) {
        int j;
        for (j = 0; j < line.length(); j++) {
            char ch = line.charAt(j);
            if (ch == ' ') continue;
            if (!shortcut.contains(Character.toUpperCase(ch))) {
                return j;
            }
        }
        return -1;
    }
}
