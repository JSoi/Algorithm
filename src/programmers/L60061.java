package programmers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class L60061 {
    private static final int BO = 1;
    private static final int STICK = 0;

    public static void main(String[] args) {
        int[][] solution = new L60061().solution(
                5,
                new int[][]{{1, 0, 0, 1}, {1, 1, 1, 1}, {2, 1, 0, 1}, {2, 2, 1, 1}, {5, 0, 0, 1}, {5, 1, 0, 1}, {4, 2, 1, 1}, {3, 2, 1, 1}}
        );
        Arrays.stream(solution).map(Arrays::toString).forEach(System.out::println);

    }

    public int[][] solution(int n, int[][] build_frame) {
        Set<Node> boSet = new HashSet<>();
        Set<Node> stickSet = new HashSet<>();

        for (int[] build : build_frame) {
            int x = build[0];
            int y = build[1];
            int type = build[2];
            boolean isBuild = build[3] == 1;

            Node current = new Node(x, y);

            if (type == BO) {
                if (isBuild) {
                    if (canBuildBo(current, stickSet, boSet)) {
                        boSet.add(current);
                    }
                } else {
                    if (canRemoveBo(current, stickSet, boSet)) {
                        boSet.remove(current);
                    }
                }
            } else { // type == STICK
                if (isBuild) {
                    if (canBuildStick(current, stickSet, boSet)) {
                        stickSet.add(current);
                    }
                } else {
                    if (canRemoveStick(current, stickSet, boSet)) {
                        stickSet.remove(current);
                    }
                }
            }
        }

        return buildAnswer(boSet, stickSet);
    }

    private boolean canBuildBo(Node node, Set<Node> stickSet, Set<Node> boSet) {
        int x = node.x, y = node.y;
        return stickSet.contains(new Node(x, y - 1)) || stickSet.contains(new Node(x + 1, y - 1)) ||
                (boSet.contains(new Node(x - 1, y)) && boSet.contains(new Node(x + 1, y)));
    }

    private boolean canRemoveBo(Node node, Set<Node> stickSet, Set<Node> boSet) {
        int x = node.x, y = node.y;
        Node leftBo = new Node(x - 1, y);
        Node rightBo = new Node(x + 1, y);
        return !(boSet.contains(leftBo) && !stickSet.contains(new Node(x - 1, y - 1))) &&
                !(boSet.contains(rightBo) && !stickSet.contains(new Node(x + 1, y - 1)));
    }

    private boolean canBuildStick(Node node, Set<Node> stickSet, Set<Node> boSet) {
        int x = node.x, y = node.y;
        return y == 0 || stickSet.contains(new Node(x, y - 1)) || boSet.contains(new Node(x - 1, y));
    }

    private boolean canRemoveStick(Node node, Set<Node> stickSet, Set<Node> boSet) {
        int x = node.x, y = node.y;
        Node leftBo = new Node(x - 1, y + 1);
        Node rightBo = new Node(x, y + 1);
        Node higherStick = new Node(x, y + 1);
        return boSet.contains(leftBo) && boSet.contains(rightBo) && !stickSet.contains(higherStick);
    }

    private int[][] buildAnswer(Set<Node> boSet, Set<Node> stickSet) {
        int[][] result = new int[boSet.size() + stickSet.size()][3];
        int idx = 0;
        for (Node node : boSet) {
            result[idx++] = new int[]{node.x, node.y, BO};
        }
        for (Node node : stickSet) {
            result[idx++] = new int[]{node.x, node.y, STICK};
        }
        Arrays.sort(result, (n1, n2) -> (n1[0] == n2[0] && n1[1] == n2[1]) ? n1[2] - n2[2] : (n1[0] == n2[0] ? n1[1] - n2[1] : n1[0] - n2[0]));
        return result;
    }


    private static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return x == node.x && y == node.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

}
