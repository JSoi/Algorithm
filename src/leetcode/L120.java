package leetcode;

import java.util.List;

public class L120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int size = triangle.size();
        int[] result = new int[size + 1];
        for (int i = size - 1; i >= 0; i--) {
            List<Integer> line = triangle.get(i);
            for (int j = 0; j < line.size(); j++) {
                result[j] = Math.min(result[j], result[j + 1]) + line.get(j);
            }
        }
        return result[0];
    }
}
