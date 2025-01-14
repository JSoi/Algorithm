package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class N1043 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        String[] truthLine = br.readLine().split(" ");

        int ppl = Integer.parseInt(input[0]);
        int partyCount = Integer.parseInt(input[1]);
        int truthCount = Integer.parseInt(truthLine[0]);

        boolean[] truthKnower = new boolean[ppl];

        // 진실 정리
        LinkedList<Integer> truthQueue = new LinkedList<>();
        for (int i = 0; i < truthCount; i++) {
            int truthKnowerIdx = Integer.parseInt(truthLine[i + 1]) - 1;
            truthKnower[truthKnowerIdx] = true;
            truthQueue.offer(truthKnowerIdx);
        }

        ArrayList<int[]> party = new ArrayList<>();
        boolean[] trueParty = new boolean[partyCount];
        boolean[][] participantMap = new boolean[ppl][partyCount];
        // 관계 정리
        for (int p = 0; p < partyCount; p++) {
            int finalP = p;
            int[] participants = Arrays.stream(br.readLine().split(" "))
                    .skip(1).mapToInt(Integer::parseInt).map(i -> i - 1)
                    .peek(a -> participantMap[a][finalP] = true).toArray();
            party.add(participants);
        }

        while (!truthQueue.isEmpty()) {
            int truthPerson = truthQueue.poll();
//            System.out.println(truthPerson);
            truthKnower[truthPerson] = true;
            for (int i = 0; i < partyCount; i++) {
                if (!participantMap[truthPerson][i]) {
                    continue;
                }
                trueParty[i] = true;
                for (int participants : party.get(i)) {
                    if (!truthKnower[participants]) {
                        truthQueue.offer(participants);
                    }
                }
            }
        }
        int answer = 0;
        for (boolean b : trueParty) {
            if (!b) {
                answer++;
            }
        }
        System.out.println(answer);
    }
}
