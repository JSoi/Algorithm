package com.soi.leetcode;

/**
 * <a href = "https://leetcode.com/problems/lru-cache/description/?envType=problem-list-v2&envId=ssd-ssd1-cache-system-design">Cache System Design</a>
 */
public class LC_lRU_cache {
    private static class Node {
        int key;
        int value;
        Node prev;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final Node[] nodes = new Node[10001];
    private Node head, tail;
    private final int capacity;
    private int size;

    public LC_lRU_cache(int capacity) {
        this.capacity = capacity;
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
        this.size = 0;
    }

    public int get(int key) {
        // return available node
        Node node = nodes[key];
        if (node == null) return -1;
        remove(node);
        addToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node = nodes[key];
        if (node == null) {
            node = new Node(key, value);
            nodes[key] = node;
            if (size == capacity) {
                nodes[tail.prev.key] = null;
                remove(tail.prev);
            } else {
                size++;
            }
            addToHead(node);
        } else {
            remove(node);
            addToHead(node);
            node.value = value;
        }
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addToHead(Node node) {
        head.next.prev = node;
        node.next = head.next;
        node.prev = head;
        head.next = node;
    }

}
