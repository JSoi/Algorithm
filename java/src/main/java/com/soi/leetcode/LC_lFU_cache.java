package com.soi.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href = "https://leetcode.com/problems/lru-cache/description/?envType=problem-list-v2&envId=ssd-ssd1-cache-system-design">Cache System Design</a>
 */
public class LC_lFU_cache {
    private static class Node {
        int key;
        int value;
        int counter;
        Node prev;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.counter = 1;
        }
    }

    private static class NodeLinkedList {
        Node head;
        Node tail;

        public NodeLinkedList() {
            head = new Node(-1, -1);
            tail = new Node(-1, -1);
            head.counter = -1;
            tail.counter = -1;
            head.next = tail;
            tail.prev = head;
        }

        public int remove(Node node) {
            node.next.prev = node.prev;
            node.prev.next = node.next;
            return node.key;
        }

        public int removeFirst() {
            return remove(tail.prev);
        }

        public void addFirst(Node node) {
            node.prev = head;
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
        }

        public boolean isEmpty() {
            return head.next == tail;
        }
    }

    private final Map<Integer, Node> nodes = new HashMap<>();
    private final Map<Integer, NodeLinkedList> freqMap = new HashMap<>();
    private final int capacity;
    private int minFreq;

    public LC_lFU_cache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        Node node = nodes.get(key);
        if (node == null) return -1;
        increaseCounter(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node = nodes.get(key);
        if (node == null) {
            if (nodes.size() == capacity) {
                int evictedKey = removeLFU();
                nodes.remove(evictedKey);
            }
            node = new Node(key, value);
            nodes.put(key, node);
            freqMap.computeIfAbsent(1, k -> new NodeLinkedList()).addFirst(node);
            minFreq = 1;
        } else {
            increaseCounter(node);
            node.value = value;
        }
    }

    private int removeLFU() {
        return freqMap.get(minFreq).removeFirst();
    }

    private void increaseCounter(Node node) {
        int freq = node.counter;
        freqMap.get(freq).remove(node);
        if (freqMap.get(freq).isEmpty()) {
            freqMap.remove(freq);
        }
        if(freqMap.get(minFreq) == null){
            minFreq++;
        }
        node.counter++;
        freqMap.computeIfAbsent(freq+1, k -> new NodeLinkedList()).addFirst(node);
    }
}
