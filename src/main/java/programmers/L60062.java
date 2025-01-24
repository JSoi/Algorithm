package programmers;

import java.util.Arrays;

public class L60062 {
    public static void main(String[] args) {
        int solution = new L60062().solution(200, new int[]{0, 10, 50, 80, 120, 160}, new int[]{1, 10, 5, 40, 30});
        System.out.println(solution);
    }

    static int[] friendCleanArr;
    static int maxLen;
    static int maxUsedFriendsCount = Integer.MAX_VALUE;

    public static int solution(int n, int[] weak, int[] dist) {
        maxLen = n;
        friendCleanArr = Arrays.stream(dist.clone()).boxed().sorted().mapToInt(Integer::intValue).toArray();
        fixWeakness(friendCleanArr.length - 1, weak);
        return maxUsedFriendsCount == Integer.MAX_VALUE ? -1 : maxUsedFriendsCount;
    }

    static void fixWeakness(int friendIdx, int[] weakStatus) {
        int count = friendCleanArr.length - friendIdx;
        if (friendIdx < 0 || count >= maxUsedFriendsCount) {
            return;
        }
        int friendClean = friendCleanArr[friendIdx];
        for (int i = 0; i < weakStatus.length; i++) {
            int start = weakStatus[i];
            if (start == -1) {
                continue;
            }
            int[] subweakstatus = weakStatus.clone();
            for (int j = 0; j < subweakstatus.length; j++) {
                if (i == j || subweakstatus[j] == -1) {
                    continue;
                }
                if ((subweakstatus[i] + friendClean >= subweakstatus[j] && subweakstatus[i] <= subweakstatus[j]) || // 사이
                        ((subweakstatus[i] + friendClean > maxLen) && (subweakstatus[i] + friendClean) % maxLen >= subweakstatus[j])) {
                    subweakstatus[j] = -1;
                }
            }
            subweakstatus[i] = -1;
            if (isAllCovered(subweakstatus)) {
                maxUsedFriendsCount = Math.min(maxUsedFriendsCount, count);
            } else {
                fixWeakness(friendIdx - 1, subweakstatus);
            }
        }
    }

    static boolean isAllCovered(int[] weak) {
        return Arrays.stream(weak).filter(w -> w == -1).count() == weak.length;
    }


}
