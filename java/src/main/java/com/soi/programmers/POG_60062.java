package com.soi.programmers;

public class POG_60062 {
    static int answer;
    static int[] extendedWeak;
    static int nWeak;
    static int nDist;

    public static void main(String[] args) {
        int solution = solution(200, new int[]{0, 10, 50, 80, 120, 160}, new int[]{1, 10, 5, 40, 30});
        System.out.println(solution);
    }

    public static int solution(int n, int[] weak, int[] dist) {
        nWeak = weak.length;
        nDist = dist.length;
        answer = nDist + 1;

        extendedWeak = new int[nWeak * 2];
        for (int i = 0; i < nWeak; i++) {
            extendedWeak[i] = weak[i];
            extendedWeak[i + nWeak] = weak[i] + n;
        }

        // dist 순열 생성
        boolean[] used = new boolean[nDist];
        int[] friendsPerm = new int[nDist];
        permute(dist, used, friendsPerm, 0);

        return answer > nDist ? -1 : answer;
    }

    static void permute(int[] dist, boolean[] used, int[] friendsPerm, int depth) {
        if (depth == nDist) {
            simulate(friendsPerm);
            return;
        }
        for (int i = 0; i < nDist; i++) {
            if (used[i]) continue;
            used[i] = true;
            friendsPerm[depth] = dist[i];
            permute(dist, used, friendsPerm, depth + 1);
            used[i] = false;
        }
    }

    static void simulate(int[] perm) {
        for (int start = 0; start < nWeak; start++) {
            int friendIdx = 0;
            int coverageEnd = extendedWeak[start] + perm[friendIdx];
            for (int idx = start; idx < start + nWeak; idx++) {
                if (extendedWeak[idx] > coverageEnd) {
                    friendIdx++;
                    if (friendIdx == nDist) {
                        break;
                    }
                    coverageEnd = extendedWeak[idx] + perm[friendIdx];
                }
            }
            answer = Math.min(answer, friendIdx + 1);
        }
    }

}
