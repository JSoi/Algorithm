package baekjoon;

import java.io.*;
import java.util.Set;

public class N1264 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String line;
        final Set<Character> set = Set.of('a', 'e', 'i', 'o', 'u');
        while (!(line = br.readLine().toLowerCase()).equals("#")) {
            int vCount = 0;
            for (char l : line.toCharArray()) {
                if (set.contains(l)) {
                    vCount++;
                }
            }
            bw.append(String.valueOf(vCount)).append("\n");
        }
        bw.flush();
    }
}
