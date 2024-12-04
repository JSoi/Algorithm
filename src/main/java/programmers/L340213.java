package programmers;

import java.util.Arrays;

public class L340213 {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int videoLen = toSecond(video_len);
        int opStart = toSecond(op_start);
        int opEnd = toSecond(op_end);
        int now = toSecond(pos);
        now = adjustPosition(now, opStart, opEnd);
        for (String command : commands) {
            if (command.equals("prev")) {
                now = Math.max(0, now - 10);
            } else {
                now = Math.min(videoLen, now + 10);
            }
            now = adjustPosition(now, opStart, opEnd);
        }
        return toTimeStr(now);
    }

    private int adjustPosition(int now, int opStart, int opEnd) {
        if (now >= opStart && now <= opEnd) {
            now = opEnd;
        }
        return now;
    }

    private int toSecond(String timeStr) {
        int[] hourAndMinute = Arrays.stream(timeStr.split(":")).mapToInt(Integer::parseInt).toArray();
        return hourAndMinute[0] * 60 + hourAndMinute[1];
    }

    private String toTimeStr(int second) {
        return String.format("%02d:%02d", second / 60, second % 60);
    }
}
