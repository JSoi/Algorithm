package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class L42891 {
    public static void main(String[] args) {
        int solution = new L42891().solution(new int[]{3, 1, 2}, 5);
        System.out.println("solution = " + solution);
    }

    public int solution(int[] food_times, long k) {
        Queue<Move> queue = new LinkedList<>();
        for (int f = 0; f < food_times.length; f++) {
            // 1 이상임
            queue.offer(new Move(f + 1, food_times[f]));
        }
        while (k-- > 0 && !queue.isEmpty()) {
            Move recent = queue.poll();
            recent.foodCount -= 1;
            if (recent.foodCount > 0)
                queue.offer(recent);
        }
        if (queue.isEmpty()) {
            return -1;
        }
        while (!queue.isEmpty() && queue.peek().foodCount == 0) {
            queue.poll();
        }
        return queue.peek().index;
    }

    private static class Move {
        int index;
        int foodCount;

        public Move(int index, int foodCount) {
            this.index = index;
            this.foodCount = foodCount;
        }
    }
}
