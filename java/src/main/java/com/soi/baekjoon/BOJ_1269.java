package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.stream.Collectors;

public class BOJ_1269 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        Set<Integer> A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).boxed()
                .collect(Collectors.toCollection(HashSet::new));
        Set<Integer> B = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).boxed()
                .collect(Collectors.toCollection(HashSet::new));
        Set<Integer> intersection = new HashSet<>();
        Iterator<Integer> iterator = A.iterator();
        while (iterator.hasNext()) {
            int a = iterator.next();
            if (B.contains(a)) {
                intersection.add(a);
                iterator.remove();
            }
        }
        B.removeAll(intersection);
        System.out.println(A.size() + B.size());
    }
}
