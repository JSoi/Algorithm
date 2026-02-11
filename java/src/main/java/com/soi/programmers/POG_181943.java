package com.soi.programmers;

public class POG_181943 {
    public String solution(String myStr, String replaceStr, int s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < myStr.length(); i++) {
            if (i == s) {
                sb.append(replaceStr);
                i = i + (replaceStr.length() - 1);
                continue;
            }
            sb.append(myStr.charAt(i));
        }
        return myStr.substring(0, s + 1) + replaceStr + myStr.substring(s + replaceStr.length() + 1);
    }

    public String solution2(String myStr, String replaceStr, int s) {
        return myStr.substring(0, s) + replaceStr + myStr.substring(s + replaceStr.length());
    }
}
