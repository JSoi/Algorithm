package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class N1235 {
    static int length;
    static String[] input;
    static int originalLen;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        length = Integer.parseInt(br.readLine());
        input = new String[length];
        for (int k = 0; k < length; k++) {
            input[k] = br.readLine();
        }
        originalLen = input[0].length();
        int o;
        for (o = 1; o < originalLen; o++) {
            if (canMake(o)) {
                System.out.println(o);
                return;
            }
        }
        System.out.println(o);
    }

    static boolean canMake(int k) {
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < length; i++) {
            String putStr = input[i].substring(originalLen - k, originalLen);
            if (set.contains(putStr)) {
                return false;
            }
            set.add(putStr);
        }
        return true;
    }
}
