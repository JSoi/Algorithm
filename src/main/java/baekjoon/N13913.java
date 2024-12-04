package baekjoon;

import java.util.*;
import java.util.stream.Stream;

public class N13913 {
    static int me, sis, maxCount;
    static int visit[];

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        me = scan.nextInt();
        sis = scan.nextInt();
        maxCount = Integer.MAX_VALUE;

        Queue<Point> queue = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();

        visit = new int[100001];
        Arrays.fill(visit, -1);
        visit[me] = 0;

        queue.offer(new Point(me, 0));
        while (!queue.isEmpty()) {
            Point now = queue.poll();
            if (now.x == sis) {
                if (maxCount >= now.count) {
                    maxCount = now.count;
                    continue;
                }
            }
            int[] dx = {now.x + 1, now.x - 1, now.x * 2};
            for (int d : dx) {
                if (isRange(d) && visit[d] == -1) {
                    visit[d] = now.x;
                    Point nP = new Point(d, now.count + 1);
                    queue.offer(nP);
                }
            }
        }

        stack.push(sis);
        int check = sis;
        while (check != me) {
            stack.push(visit[check]);
            check = visit[check];
        }

        System.out.println(maxCount);
        StringBuffer buf = new StringBuffer();
        while (!stack.isEmpty()) {
            buf.append(stack.pop() + " ");
        }
        System.out.println(buf.toString().trim());
    }

    static boolean isRange(int input) {
        if (input >= 0 && input < 100001) {
            return true;
        }
        return false;
    }

    static class Point {
        int x, count;

        public Point(int x, int count) {
            this.x = x;
            this.count = count;
        }
    }
}
