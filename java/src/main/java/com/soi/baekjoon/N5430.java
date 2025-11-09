package com.soi.baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class N5430 {
    public static final String ERRORSTR = "error";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCase = Integer.parseInt(br.readLine());
        while (testCase-- > 0) {
            String commands = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String[] split = br.readLine()
                    .replaceAll("\\[|\\]", "")
                    .split(",");
            List<Integer> arr = new ArrayList<>();
            for (String s : split) {
                if (s.isEmpty()) continue;
                arr.add(Integer.parseInt(s));
            }
            AC ac = new AC(arr);
            String result = ac.execute(commands);
            bw.append(result).append('\n');
        }
        bw.flush();
    }

    private static class AC {
        boolean isFront = true;
        Deque<Integer> queue;

        public AC(List<Integer> arr) {
            this.queue = new LinkedList<>();
            queue.addAll(arr);
        }

        public void executeCommand(char command) {
            if (command == 'D') {
                if (queue.isEmpty()) {
                    throw new RuntimeException();
                } else {
                    if (isFront) {
                        queue.poll();
                    } else {
                        queue.pollLast();
                    }
                }
            } else {
                isFront = !isFront;
            }
        }

        public String execute(String commands) {
            for (char c : commands.toCharArray()) {
                try {
                    executeCommand(c);
                } catch (Exception e) {
                    return ERRORSTR;
                }
            }
            return printQueue();
        }

        public String printQueue() {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            while (!queue.isEmpty()) {
                sb.append(isFront ? queue.pollFirst() : queue.pollLast()).append(',');
            }
            if (sb.lastIndexOf(",") >= 0) {
                sb.deleteCharAt(sb.lastIndexOf(","));
            }
            sb.append("]");
            return sb.toString();
        }
    }

}
