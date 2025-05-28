package com.soi.baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class N14226 {
    static int min = Integer.MAX_VALUE;
    static int target;
    static boolean[][] visit;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        target = scanner.nextInt();
        visit = new boolean[2001][2001];
        visit[0][0] = true;
        bfs();
        System.out.println(min);
    }

    static void bfs() {
        Queue<Emoticon> queue = new LinkedList<>();
        queue.offer(new Emoticon(1, 0, 0));
        visit[1][0] = true;
        while (!queue.isEmpty()) {
            Emoticon emo = queue.poll();
            //System.out.println("emo.count = " + emo.count + " clipboard  = " + emo.clipboard);
            if (emo.count == target) {
                min = Math.min(emo.time, min);
                continue;
            }


            if (emo.count != emo.clipboard && condition(emo.count, emo.count)) { // 복사하기 - 계속 복사하는 걸 막아야..
                makevisit(emo.count, emo.count);
                queue.offer(new Emoticon(emo.count, emo.time + 1, emo.count)); // 덮어쓰게 된다.
            }

            if (emo.clipboard != 0 && emo.count + emo.clipboard <= target && condition(emo.count + emo.clipboard, 0)) { // 클립보드가 비어있지 않으면 붙여넣을 수 있다.
                makevisit(emo.count + emo.clipboard, emo.clipboard);
                queue.offer(new Emoticon(emo.count + emo.clipboard,
                        emo.time + 1, emo.clipboard)); // 붙여넣으면 클립보드가 비워짐
            }

            if (condition(emo.count - 1, emo.clipboard)) { // 한 개 삭제하기
                makevisit(emo.count - 1, emo.clipboard);
                queue.offer(new Emoticon(emo.count - 1, emo.time + 1, emo.clipboard));
            }
        }
    }

    static boolean condition(int count, int clipboard) {
        if (count >= 1 && count < 2001 && clipboard >= 0 && clipboard < 2001) {
            if (!visit[count][clipboard]) {
                return true;
            }
            return false;
        }
        return false;
    }

    static void makevisit(int count, int clipboard) {
        visit[count][clipboard] = true;
    }

    static class Emoticon {
        int count;
        int time;

        public void setClipboard(int clipboard) {
            this.clipboard = clipboard;
        }

        int clipboard;


        public Emoticon(int count, int time, int clipboard) {
            this.count = count;
            this.time = time;
            this.clipboard = clipboard;
        }

        public boolean clipEmpty() {
            if (clipboard == 0) {
                return true;
            } else {
                return false;
            }
        }

    }
}
