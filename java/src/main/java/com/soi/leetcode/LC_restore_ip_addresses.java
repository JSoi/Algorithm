package com.soi.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC_restore_ip_addresses {
    public static void main(String[] args) {
        LC_restore_ip_addresses solution = new LC_restore_ip_addresses();
        String s = "25525511135";
        List<String> result = solution.restoreIpAddresses(s);
        System.out.println(result);
    }

    List<String> answer;
    String s;

    public List<String> restoreIpAddresses(String s) {
        answer = new ArrayList<>();
        this.s = s;
        createAddress(0, 0, new int[4]);
        return answer;
    }

    void createAddress(int idx, int choose, int[] curr) {
        if (choose == 4) {
            if (idx == s.length()) {
                answer.add(createAddressString(curr));
            }
            return;
        }
        for (int i = 0; i < 3; i++) {
            if (idx + i >= s.length()) break;
            String sub = s.substring(idx, idx + i + 1);
            int val = Integer.parseInt(sub);
            if (val > 255 || (sub.length() > 1 && sub.charAt(0) == '0')) break;
            curr[choose] = val;
            createAddress( idx + i + 1, choose + 1, curr);
        }
    }

    private String createAddressString(int[] curr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < curr.length; i++) {
            sb.append(curr[i]);
            if (i < curr.length - 1) {
                sb.append(".");
            }
        }
        return sb.toString();
    }
}
