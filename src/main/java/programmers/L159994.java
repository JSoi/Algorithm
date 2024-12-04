package programmers;

/**
 * <a href="https://school.programmers.co.kr/learn/courses/30/lessons/159994">카드 뭉치</a>
 */
public class L159994 {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        int i1 = 0, i2 = 0;
        for (String g : goal) {
            if (i1 < cards1.length && cards1[i1].equals(g)) {
                i1++;
            } else if (i2 < cards2.length && cards2[i2].equals(g)) {
                i2++;
            } else {
                return "No";
            }
        }
        return "Yes";
    }

    public static void main(String[] args) {
        String a1 = new L159994().solution(new String[]{"i", "drink", "water"}, new String[]{"want", "to"}, new String[]{"i", "want", "to", "drink", "water"});
        String a2 = new L159994().solution(new String[]{"i", "water", "drink"}, new String[]{"want", "to"}, new String[]{"i", "want", "to", "drink", "water"});
        System.out.println(a1);
        System.out.println(a2);
    }
}
