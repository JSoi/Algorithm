package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

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

            boolean[] trueParty = new boolean[partyCount];
            boolean[][] participantMap = new boolean[ppl][partyCount];
            // 관계 정리
            for (int p = 0; p < partyCount; p++) {
                StringTokenizer tok = new StringTokenizer(br.readLine(), " ");
                int participantCount = Integer.parseInt(tok.nextToken());
                while (participantCount > 0) {
                    int participant = Integer.parseInt(tok.nextToken()) - 1;
                    participantMap[participant][p] = true;
                    participantCount--;
                }
            }

            while (!truthQueue.isEmpty()) {
                int truthPerson = truthQueue.poll();
                truthKnower[truthPerson] = true;
                for (int party = 0; party < partyCount; party++) {
                    if (!participantMap[truthPerson][party]) {
                        continue;
                    }
                    trueParty[party] = true;
                    for(int participant = 0; participant < ppl; participant++) {
                        if (participantMap[participant][party] && !truthKnower[participant]) {
                            truthQueue.offer(participant);
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
