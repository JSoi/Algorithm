package baekjoon;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class N1062 {
    static int min = Integer.MAX_VALUE;
    static int target;
    static boolean[][] visit;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        target = scanner.nextInt();
        visit = new boolean[2000][2000];
        bfs();
        System.out.println(min);
    }

    static void bfs() {
        Queue<Emoticon> queue = new LinkedList<>();
        queue.offer(new Emoticon(1, 0, 0));
        while (!queue.isEmpty()) {
            Emoticon emo = queue.poll();
            visit[emo.count][emo.clipboard] = true;
            System.out.println("emo.count = " + emo.count);
            if (emo.count == target) {
                min = Math.min(emo.time, min);
                continue;
            }
            if (emo.clipboard != 0 && !visit[emo.count][emo.clipboard]) { // 클립보드가 비어있지 않으면 붙여넣을 수 있다.
                queue.offer(new Emoticon(emo.count + emo.clipboard,
                        emo.time + 1, 0)); // 붙여넣으면 클립보드가 비워짐
            }
            if (emo.count != emo.clipboard && emo.count * 2 <= 2000 && !visit[emo.count][emo.count]) { // 복사하기 - 계속 복사하는 걸 막아야..
                queue.offer(new Emoticon(emo.count, emo.time + 1, emo.count)); // 덮어쓰게 된다.
            }

            if (emo.count >= 2 && !visit[emo.count - 1][emo.clipboard]) { // 한 개 삭제하기
                queue.offer(new Emoticon(emo.count - 1, emo.time + 1, emo.clipboard));
            }
        }
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
