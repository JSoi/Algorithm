package leetcode;

public class L231 {
    public boolean isPowerOfTwo(int n) {
        System.out.println(4 >> 1);
        if (n <= 0) return false;
        boolean oneExist = false;
        String num = Integer.toBinaryString(n);
        for (int i = 0; i < num.length(); i++) {
            if (num.charAt(i) == '1') {
                if (oneExist) {
                    return false;
                }
                oneExist = true;
            }
        }
        return true;
    }
}
