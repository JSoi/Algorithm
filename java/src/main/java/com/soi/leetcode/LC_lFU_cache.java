package com.soi.leetcode;

import java.util.HashMap;

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
            this.counter = 0;
        }

        private void increaseCounter() {
            this.counter++;
        }
    }

    private final HashMap<Integer, Node> map = new HashMap<>();
    private Node head, tail;
    private final int capacity;
    private int size;

    public LC_lFU_cache(int capacity) {
        this.capacity = capacity;
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
        this.size = 0;
    }

    public int get(int key) {
        // return available node
        Node node = map.get(key);
        if (node == null) return -1;
        remove(node);
        add(node);
        node.increaseCounter();
        return node.value;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if (node == null) {
            node = new Node(key, value);
            map.put(key, node);
            if (map.size() == capacity) {
                map.remove(tail.prev.key);
                remove(tail.prev);
            } else {
                size++;
            }
            node.increaseCounter();
            add(node);
        } else {
            node.increaseCounter();
            remove(node);
            add(node);
            node.value = value;
        }
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void add(Node node) {
        Node addNode = head;
        while (addNode.next.counter >= node.counter) {
            addNode = addNode.next;
            if (addNode.next == tail) break;
        }
        node.prev = addNode;
        node.next = addNode.next;
        addNode.next.prev = node;
        addNode.next = node;
    }

}
