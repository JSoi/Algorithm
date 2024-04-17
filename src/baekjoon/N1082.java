package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class N1082 {
    private static String answer = "";
    private static int[] rooms;
    private static List<Node> list;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int roomCount = Integer.parseInt(reader.readLine());
        rooms = new int[roomCount];
        int roomIndex = 0;
        StringTokenizer st = new StringTokenizer(reader.readLine(), " ");
        int money = Integer.parseInt(reader.readLine());
        list = new ArrayList<>();
        while (st.hasMoreTokens()) {
            String tok = st.nextToken();
            Node e = new Node(roomIndex, Integer.parseInt(tok));
            list.removeIf(n -> n.hasSameCostAndBiggerIndex(e));
            list.add(e);
            rooms[roomIndex] = Integer.parseInt(tok);
            roomIndex++;
        }
        Collections.sort(list);
        visit(0, money, "0");
        System.out.println(answer);
        reader.close();

    }


    private static class Node implements Comparable<Node> {
        int index;
        int cost;

        public Node(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node node) {
            if (node.index == this.index) {
                return node.cost - this.cost;
            } else {
                return node.index - this.index;
            }
        }

        public boolean hasSameCostAndBiggerIndex(Node node) {
            return this.cost == node.cost && this.index < node.index;
        }
    }

    private static void visit(int targetRoomIndex, int leftMoney, String aggNum) {
        if (targetRoomIndex >= list.size() || leftMoney <= 0) {
            answer = isGreaterOrSame(answer, aggNum) ? answer : aggNum;
            return;
        }
        if (leftMoney >= list.get(targetRoomIndex).cost) {
            // visit current index
            visit(targetRoomIndex, leftMoney - list.get(targetRoomIndex).cost, addString(aggNum, list.get(targetRoomIndex).index));
            // vistit next index
            visit(targetRoomIndex + 1, leftMoney - list.get(targetRoomIndex).cost, addString(aggNum, list.get(targetRoomIndex).index));

        }
        if (targetRoomIndex < list.size() - 1) {
            visit(targetRoomIndex + 1, leftMoney, aggNum);
        }
    }

    private static String addString(String src, int add) {
        if (src.length() > 5) return src + add;
        return String.valueOf(Integer.parseInt(src + add));
    }

    private static boolean isGreaterOrSame(String a, String b) {
        if (a.length() > b.length()) {
            return true;
        }
        if (a.length() < b.length()) {
            return false;
        }
        char[] aArr = a.toCharArray();
        char[] bArr = b.toCharArray();
        for (int j = 0; j < a.length(); j++) {
            if (aArr[j] == bArr[j]) {
                continue;
            }
            return aArr[j] > bArr[j];
        }
        return true;
    }
}
