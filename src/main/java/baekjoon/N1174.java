package baekjoon;

import java.util.*;

public class N1174 {
    public static void main(String[] args) {
        int n = Integer.parseInt(new Scanner(System.in).nextLine());
        Queue<Long> queue = new LinkedList<>();
        for (long i = 0; i <= 9; i++) {
            queue.offer(i);
        }
        int localN = 1;
        while (!queue.isEmpty()) {
            Long poll = queue.poll();
            if (poll > 1_000_000) {
                System.out.println(-1);
                return;
            }
            if (localN == n) {
                System.out.println(poll);
                return;
            }
            localN++;
            for (int i = 0; i < poll % 10; i++) {
                queue.offer(poll * 10 + i);
            }
        }
        System.out.println(-1);
    }

}
