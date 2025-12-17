package com.soi.baekjoon;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N9019 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCase = Integer.parseInt(br.readLine());
        while (testCase-- > 0) {
            StringTokenizer tok = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(tok.nextToken());
            int end = Integer.parseInt(tok.nextToken());
            Test test = new Test(start, end);
            bw.append(test.bfs()).append("\n");
        }
        bw.flush();
    }

    private static class Test {
        int from;
        int to;
        boolean[] visit;

        public Test(int from, int to) {
            this.from = from;
            this.to = to;
            visit = new boolean[10000];

        }

        String bfs() {
            visit[from] = true;
            Queue<Register> queue = new LinkedList<>();
            queue.offer(new Register(from, ""));
            while (!queue.isEmpty()) {
                Register cur = queue.poll();
                if (cur.num == this.to) {
                    return cur.command;
                }
                for (Command c : Command.values()) {
                    int result = c.calculator.calculate(cur.num);
                    if (visit[result]) {
                        continue;
                    }
                    visit[result] = true;
                    queue.offer(new Register(result, cur.command + c));
                }
            }
            return "";
        }
    }

    interface Calculator {

        int calculate(int input);
    }

    static class Double implements Calculator {
        static Double INSTANCE = new Double();

        @Override
        public int calculate(int input) {
            return (input * 2) % 10000;
        }
    }

    static class Minus implements Calculator {
        static Minus INSTANCE = new Minus();

        @Override
        public int calculate(int input) {
            return input == 0 ? 9999 : input - 1;
        }
    }

    static class RotateLeft implements Calculator {
        static RotateLeft INSTANCE = new RotateLeft();

        @Override
        public int calculate(int input) {
            return (input % 1000) * 10 + input / 1000;
        }
    }

    static class RotateRight implements Calculator {
        static RotateRight INSTANCE = new RotateRight();
        @Override
        public int calculate(int input) {
            return (input % 10) * 1000 + input / 10;
        }
    }

    enum Command {
        D(Double.INSTANCE), S(Minus.INSTANCE), L(RotateLeft.INSTANCE), R(RotateRight.INSTANCE);
        final Calculator calculator;

        Command(Calculator calculator) {
            this.calculator = calculator;
        }
    }

    private static class Register {
        int num;
        String command;

        public Register(int num, String command) {
            this.num = num;
            this.command = command;
        }
    }
}
