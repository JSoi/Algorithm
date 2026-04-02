package com.soi.leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * <a href = "https://leetcode.com/problems/lru-cache/description/?envType=problem-list-v2&envId=ssd-ssd1-cache-system-design">Cache System Design</a>
 */
public class LC_lRU_cache {
    private final Queue<Integer> getQueue;
    private final int[] keyVal = new int[10001];
    private final int capacity;

    public LC_lRU_cache(int capacity) {
        this.capacity = capacity;
        getQueue = new ArrayDeque<>();
        Arrays.fill(keyVal, -1);
    }

    public int get(int key) {
        if (keyVal[key] != -1) {
            getQueue.remove(key);
            getQueue.offer(key);
        }
        return keyVal[key];
    }

    public void put(int key, int value) {
        if (getQueue.size() == capacity && keyVal[key] == -1) {
            int evictKey = getQueue.poll();
            keyVal[evictKey] = -1;
        }
        getQueue.remove(key);
        getQueue.offer(key);
        keyVal[key] = value;
    }
}
