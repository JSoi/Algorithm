package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class N1082 {
    private static String answer = "";
    private static int[] rooms;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int roomCount = Integer.parseInt(reader.readLine());
        StringTokenizer st = new StringTokenizer(reader.readLine(), " ");
        int money = Integer.parseInt(reader.readLine());
        rooms = new int[roomCount];
        int roomIndex = 0;
        while (st.hasMoreTokens()) {
            String tok = st.nextToken();
            rooms[roomIndex] = Integer.parseInt(tok);
            roomIndex++;
        }
        Set<Integer> moneySet = new HashSet<>();
        for (int i = roomCount - 1; i >= 0; i--) {
            if (moneySet.contains(rooms[i])) {
                rooms[i] = -1;
            } else {
                moneySet.add(rooms[i]);
            }
        }
        travel(roomCount - 1, "", money);
        System.out.println(answer);
        reader.close();
    }

    private static void travel(int index, String result, int leftMoney) {
//        System.out.println(index + " | " + result + " | " + leftMoney);
        if (leftMoney < 0) {
            return;
        }
        for (int i = index; i >= 0; i--) {
            if (rooms[i] == -1 || leftMoney < rooms[i]) {
                answer = larger(answer, result);
                continue;
            }
            travel(i, result + i, leftMoney - rooms[i]);
        }
    }

    private static String larger(String s1, String s2) {
        s1 = s1.replaceFirst("^0+", "");
        s2 = s2.replaceFirst("^0+", "");
        s1 = s1.isEmpty() ? "0" : s1;
        s2 = s2.isEmpty() ? "0" : s2;
        if (s1.length() != s2.length()) {
            return s1.length() > s2.length() ? s1 : s2;
        }
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == s2.charAt(i)) {
                continue;
            }
            return s1.charAt(i) > s2.charAt(i) ? s1 : s2;
        }
        return s1;
    }
}
