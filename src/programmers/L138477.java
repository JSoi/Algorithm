package programmers;

import java.util.*;
public class L138477 {
    public static void main(String[] args) {
        int[] solution = new L138477().solution(3, new int[]{10, 100, 20, 150, 1, 100, 200});
        System.out.println(Arrays.toString(solution));
    }

    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        int index = 0;
        LinkedList<Integer> queue = new LinkedList<>();
        for (int s : score) {
            add(queue, s);
            if (queue.size() > k) {
                queue.removeFirst();
            }
            answer[index++] = queue.get(0);
        }
        return answer;
    }

    public void add(List<Integer> list, int addElement) {
        list.add(addElement);
        Collections.sort(list);
    }
}
