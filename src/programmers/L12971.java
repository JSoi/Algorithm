package programmers;

public class L12971 {
    public static void main(String[] args) {
        int solution = new L12971().solution(new int[]{1, 3, 2, 5, 4});
        System.out.println("solution = " + solution);
    }

    public int solution(int[] sticker) {
        if (sticker.length == 1) {
            return sticker[0];
        }
        if (sticker.length == 2) {
            return Math.max(sticker[0], sticker[1]);
        }
        // 첫번째 미선택, 마지막 선택
        int[][] dp = new int[sticker.length][2];
        dp[1][1] = sticker[1];
        for (int i = 2; i < sticker.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][1], dp[i - 1][0]);
            dp[i][1] = sticker[i] + Math.max(dp[i - 1][0], dp[i - 2][1]);
        }
        int withoutFirstSticker = Math.max(dp[sticker.length - 1][0], dp[sticker.length - 1][1]);
        // 첫번째 선택, 마지막 미선택
        dp[0][1] = dp[1][0] = sticker[0];
        for (int i = 2; i < sticker.length - 1; i++) {
            dp[i][0] = Math.max(dp[i - 1][1], dp[i - 1][0]);
            dp[i][1] = sticker[i] + Math.max(dp[i - 1][0], dp[i - 2][1]);
        }
        return Math.max(withoutFirstSticker, Math.max(dp[sticker.length - 2][0], dp[sticker.length - 2][1]));
    }

}
