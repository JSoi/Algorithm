package com.soi.leetcode;

import java.util.PriorityQueue;

public class LC_kth_largest {
    private static class KthLargest {
        PriorityQueue<Integer> pq;
        int k;

        public KthLargest(int k, int[] nums) {
            this.k = k;
            pq = new PriorityQueue<>(k);
            for (int n : nums) {
                pq.offer(n);
            }
        }

        public int add(int val) {
            pq.offer(val);
            while(pq.size() > k){
                pq.poll();
            }
            return pq.peek();
        }
    }
}
