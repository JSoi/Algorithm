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
                new int[][]{
                        {0, 0, 0, 1}, {2, 0, 0, 1}, {4, 0, 0, 1}, {0, 1, 1, 1}, {1, 1, 1, 1}, {2, 1, 1, 1}, {3, 1, 1, 1}, {2, 0, 0, 0}, {1, 1, 1, 0}, {2, 2, 0, 1}
                }
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
            Set<Node> targetSet = type == BO ? boSet : stickSet;
            if (isBuild) {
                targetSet.add(current);
                if (!isAvailable(boSet, stickSet)) {
                    targetSet.remove(current);
                }
            } else {
                targetSet.remove(current);
                if (!isAvailable(boSet, stickSet)) {
                    targetSet.add(current);
                }
            }
        }
        return buildAnswer(boSet, stickSet);
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


    private static boolean isAvailable(Set<Node> boSet, Set<Node> stickSet) {
        // 시작점을 기준으로 bo, stick 검증
        for (Node bo : boSet) {
            // bo 는 양 옆 검증 필요
            if (!stickSet.contains(new Node(bo.x, bo.y - 1))
                    && !stickSet.contains(new Node(bo.x + 1, bo.y - 1))
                    && !(boSet.contains(new Node(bo.x - 1, bo.y)) && boSet.contains(new Node(bo.x + 1, bo.y)))) {
                return false;
            }
        }

        for (Node stick : stickSet) {
            // 기둥 검증
            // 만일 기둥이 0이면 continue
            if (stick.y == 0) {
                continue;
            }
            // 그 외의 경우 검증 필요
            // 보의 끝 위에 있어야 함
            // 다른 기둥 위에 있어야 함
            if (!boSet.contains(new Node(stick.x - 1, stick.y)) &&
                    !boSet.contains(new Node(stick.x, stick.y)) &&
                    !stickSet.contains(new Node(stick.x, stick.y - 1))) {
                return false;
            }
        }
        return true;
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
