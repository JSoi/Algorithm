package programmers;

public class L72413 {
    public static void main(String[] args) {
        int solution = new L72413().solution(6, 4, 6, 2, new int[][]{{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}});
        System.out.println(solution);

    }

    static int[][] roads;
    static int answer = Integer.MAX_VALUE;
    static int aDestination;
    static int bDestination;

    public int solution(int n, int s, int a, int b, int[][] fares) {
        roads = new int[n][n];
        for (int[] fare : fares) {
            roads[fare[0] - 1][fare[1] - 1] = roads[fare[1] - 1][fare[0] - 1] = fare[2];
        }
        aDestination = a - 1;
        bDestination = b - 1;
        boolean[] visit = new boolean[n];
        visit[s - 1] = true;
        ride(0, s - 1, visit);
        return answer;
    }

    private static void ride(int totalFee, int visitSpot, boolean[] visit) {
        if (visit[aDestination] && visit[bDestination]) {
//            System.out.println(" = " + totalFee + "\n");
            answer = Math.min(answer, totalFee);
            return;
        }
        for (int i = 0; i < roads.length; i++) {
            if (roads[visitSpot][i] != 0 && !visit[i]) {
                visit[i] = true;
//                System.out.printf((visitSpot+1) + " -> " + (i+1) + " ");
                ride(totalFee + roads[visitSpot][i], i, visit);
                visit[i] = false;
            }
        }
    }
}
