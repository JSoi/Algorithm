package programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.stream.Collectors;

public class L131704 {
    public static void main(String[] args) {
        System.out.println(new L131704().solution(new int[]{4, 3, 1, 2, 5}));
        System.out.println(new L131704().solution(new int[]{5, 4, 3, 2, 1}));
    }

    public int solution(int[] order) {
        Queue<Integer> queue = new LinkedList<>(Arrays.stream(order).boxed().collect(Collectors.toList()));
        Stack<Integer> waitStack = new Stack<>();
        int count = 1;
        while (count < order.length+1) {
            if (queue.isEmpty() && waitStack.peek() != count) {
                break;
            }
            if (!queue.isEmpty()) {
                if (count != queue.peek()) {
                    waitStack.push(queue.poll());
                } else {
                    queue.poll();
                    count++;
                }
            } else if (!waitStack.isEmpty() && count == waitStack.peek()) {
                waitStack.pop();
                count++;
            }
        }
        return count;
    // 4 3 1 2 5
}
}
