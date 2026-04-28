package com.soi.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class LC_implement_stack_using_queues {
    private static class MyStack {
        Queue<Integer> desc;
        Queue<Integer> asc;

        public MyStack() {
            desc = new LinkedList<>();
            asc = new LinkedList<>();
        }

        public void push(int x) {
            asc.offer(x);
            while (!desc.isEmpty()) {
                asc.offer(desc.poll());
            }
            Queue<Integer> temp = desc;
            desc = asc;
            asc = temp;
        }

        public int pop() {
            return desc.poll();
        }

        public int top() {
            return desc.peek();
        }

        public boolean empty() {
            return desc.size() == 0;
        }
    }
}
