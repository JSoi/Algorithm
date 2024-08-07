package programmers;

/**
 * <a href="https://school.programmers.co.kr/learn/courses/30/lessons/159993">미로 탈출</a>
 */
public class L159993 {
    static char[][] mapChar;
    static int[][] point = new int[4][];
    static int answer = -1;
    static final int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static int solution(String[] maps) {
        mapChar = new char[maps.length][];
        for (int i = 0; i < maps.length; i++) {
            mapChar[i] = maps[i].toCharArray();
            if (maps[i].contains("S")) {
                point[0] = new int[]{i, maps[i].indexOf("S")};
            }
            if (maps[i].contains("C")) {
                point[1] = new int[]{i, maps[i].indexOf("C")};
            }
            if (maps[i].contains("L")) {
                point[2] = new int[]{i, maps[i].indexOf("L")};
            }
            if (maps[i].contains("E")) {
                point[3] = new int[]{i, maps[i].indexOf("E")};
            }
        }
        System.out.println(answer);
        int toLeverAndFinal;
        travel(point[0][0], point[0][1], point[3][0], point[3][1], new boolean[maps.length][maps[0].length()], 0);
        if (answer == -1) {
            return answer;
        }
        toLeverAndFinal = answer;
        answer = -1;
        travel(point[3][0], point[3][1], point[2][0], point[2][1], new boolean[maps.length][maps[0].length()], 0);
        if (answer == -1) {
            return answer;
        }
        toLeverAndFinal += answer;
        System.out.println(toLeverAndFinal);
        return toLeverAndFinal;
    }

    public static void travel(int h, int v, int endH, int endV, boolean[][] visited, int walkCount) {
        visited[h][v] = true;
        if (h == endH && v == endV && visited[endH][endV]) {
            answer = answer == -1 ? walkCount : Math.min(answer, walkCount);
            return;
        }
        for (int[] dir : directions) {
            int nextH = h + dir[0];
            int nextV = v + dir[1];
            if (nextH < 0 || nextH >= mapChar.length || nextV < 0 || nextV >= mapChar[0].length || visited[nextH][nextV]) {
                continue;
            }
            travel(nextH, nextV, endH, endV, visited, walkCount + 1);
        }
    }

    public static void main(String[] args) {
        String[] maps = {"SOOOL", "XXXXO", "OOOOO", "OXXXX", "OOOOE"};
//        String[] maps2 = {"LOOXS", "OOOOX", "OOOOO", "OOOOO", "EOOOO"};
//        String[] maps3 = {"LOEOS", "XXXXX", "XXXXX", "XXXXX", "XXXXX"};
        System.out.println(new L159993().solution(maps));
//        System.out.println(new L159993().solution(maps3));
    }
}
