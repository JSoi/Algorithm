package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class N1092_2 {
    static int[] crain;
    static int crainCount;
    static Queue<Integer> boxs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        crainCount = Integer.parseInt(br.readLine());
        crain = new int[crainCount];
        StringTokenizer tok = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < crainCount; i++) {
            crain[i] = Integer.parseInt(tok.nextToken());
        }
        boxs = new PriorityQueue<>(Collections.reverseOrder());
        int boxCount = Integer.parseInt(br.readLine());
        tok = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < boxCount; i++) {
            boxs.offer(Integer.parseInt(tok.nextToken()));
        }
        int time = 0;
        Arrays.sort(crain);
        while (!boxs.isEmpty()) {
            time++;
            for (int c = crainCount - 1; c >= 0; c--) {
                if (boxs.isEmpty()) {
                    break;
                }
                int crainWeight = crain[c];
                Iterator<Integer> boxIt = boxs.iterator();
                while (boxIt.hasNext()) {
                    int box = boxIt.next();
                    if (crainWeight >= box) {
                        boxIt.remove();
                        break;
                    }
                }
            }
        }
        System.out.println(time);
    }
}
