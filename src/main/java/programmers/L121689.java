package programmers;

import java.util.Comparator;
import java.util.PriorityQueue;

public class L121689 {
    public static void main(String[] args) {
        int solution = new L121689().solution(new int[]{5, 12, 30}, new int[]{1, 2, 0, 1}, 10);
    }


    public int solution(int[] menu, int[] order, int k) {
        int answer = 0;
        int time = 0;
        PriorityQueue<Order> oq = new PriorityQueue<>(Comparator.comparingInt(order1 -> order1.orderTime));
        PriorityQueue<Order> waitingQueue = new PriorityQueue<>(Comparator.comparingInt(order1 -> order1.orderTime));
        for (int o : order) {
            oq.offer(new Order(time, menu[o]));
            time += k;
        }
        int endTime = 0;
        while (!oq.isEmpty() || !waitingQueue.isEmpty()) {
            Order targetOrder = waitingQueue.isEmpty() ? oq.poll() : waitingQueue.poll();
            endTime = Math.max(targetOrder.orderTime, endTime) + targetOrder.timeToSpend;
            while (!oq.isEmpty() && oq.peek().orderTime < endTime) {
                waitingQueue.offer(oq.poll());
            }
            answer = Math.max(answer, waitingQueue.size());
        }
        return answer + 1;
    }

    private static class Order {
        int orderTime;
        int timeToSpend;

        public Order(int orderTime, int timeToSpend) {
            this.orderTime = orderTime;
            this.timeToSpend = timeToSpend;
        }
    }
}
