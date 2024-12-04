package leetcode;

import java.util.ArrayList;
import java.util.List;

public class L46 {
    List<List<Integer>> answer = new ArrayList<>();
    boolean[] visit;
    int[] number;

    public List<List<Integer>> permute(int[] nums) {
        visit = new boolean[nums.length];
        number = nums;
        List<Integer> node = new ArrayList<Integer>();
        go(node);
        return answer;

    }

    public void go(List<Integer> node) {
        if (node.size() == number.length) {
            answer.add(new ArrayList<Integer>(node));
            return;
        }
        for (int i = 0; i < number.length; i++) {
            if (visit[i]) continue;
            visit[i] = true;
            node.add(number[i]);
            go(node);
            node.remove(node.size() - 1);
            visit[i] = false;

        }
    }
}
