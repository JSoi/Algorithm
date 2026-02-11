package com.soi.programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class POG_43164 {

    public static void main(String[] args) {

        Solution43164[] sol = new Solution43164[7];
        sol[0].solution(new String[][]{{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}});
        sol[1].solution(new String[][]{{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}});
        sol[2].solution(new String[][]{{"ICN", "A"}, {"ICN", "B"}, {"B", "ICN"}});
        sol[3].solution(new String[][]{{"ICN", "COO"}, {"COO", "ICN"}, {"ICN", "COO"}});
        sol[4].solution(new String[][]{{"ICN", "A"}, {"ICN", "A"}, {"A", "ICN"}});
        sol[5].solution(new String[][]{{"ICN", "COO"}, {"ICN", "BOO"}, {"COO", "ICN"}, {"BOO", "DOO"}});
        sol[6].solution(new String[][]{{"ICN", "A"}, {"ICN", "A"}, {"A", "ICN"}, {"A", "ICN"}});
    }
}

class Solution43164 {
    ArrayList<String> airport = new ArrayList<String>();
    int N;
    ArrayList<String> arr = new ArrayList<String>();
    String[] answer;

    public String[] solution(String[][] tickets) {
        N = tickets.length + 1;
        for (int i = 0; i < tickets.length; i++) {
            if (!airport.contains(tickets[i][0]))
                airport.add(tickets[i][0]);
            if (!airport.contains(tickets[i][1]))
                airport.add(tickets[i][1]);
        }
        Collections.sort(airport, (a1, a2) -> a1.compareTo(a2));
        int[][] visit = new int[airport.size()][airport.size()];
        for (int i = 0; i < tickets.length; i++) {
            visit[airport.indexOf(tickets[i][0])][airport.indexOf(tickets[i][1])]++;
        }
        answer = new String[N];
        addAns(visit, 0, airport.indexOf("ICN"), answer);
        Collections.sort(arr);
        answer = arr.get(0).split(" ");
        return answer;
    }

    public void addAns(int[][] visit, int idx, int target, String[] ans) {
        ans[idx] = airport.get(target);
//		System.out.println("ans : " + Arrays.toString(ans));
        ArrayList<Integer> order = new ArrayList<Integer>();
        for (int i = 0; i < visit[0].length; i++) {
            if (visit[target][i] > 0 && i != target) {
                order.add(i);
            }
        }
        if (idx >= N - 1) {
            String str = "";
            for (String s : ans) {
                str += s + " ";
            }
            arr.add(str.trim());
        }
        Collections.sort(order, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                boolean b1 = isEmpty(visit, o1);
                boolean b2 = isEmpty(visit, o2);
                if (b1 && b2 || !b1 && !b2) {
                    return o1 - o2;
                } else if (b1 && !b2) {// 0,
                    return -1;
                } else if (!b1 && b2) { // 2, 0
                    return -1;
                } else {
                    return o1 - o2;
                }
            }
        });
        for (int k : order) {
            if (visit[target][k] <= 0)
                continue;
            visit[target][k]--;
            addAns(visit, idx + 1, k, ans);
            visit[target][k]++;
        }
    }

    public boolean isEmpty(int[][] visit, int target) {
        for (int i = 0; i < visit[0].length; i++) {
            if (visit[target][i] > 0) {
                return false;
            }
        }
        return true;
    }
}
