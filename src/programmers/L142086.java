package programmers;

import java.util.Arrays;

/**
 * @see <a href="https://programmers.co.kr/learn/courses/30/lessons/142086">가장 가까운 작은 글자</a>
 */
public class L142086 {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        int[] alphabet = new int[26];
        Arrays.fill(answer, -1);
        Arrays.fill(alphabet, -1);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (alphabet[c - 'a'] != -1) {
                answer[i] = i - alphabet[c - 'a'];
            }
            alphabet[c - 'a'] = i;
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new L142086().solution("banana")));
    }
}
