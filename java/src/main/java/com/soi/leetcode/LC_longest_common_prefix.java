package com.soi.leetcode;

public class LC_longest_common_prefix {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < 200; i++){
            if(isCommmon(i, strs)){
                sb.append(strs[0].charAt(i));
            } else {
                break;
            }
        }
        return sb.toString();
    }
    private boolean isCommmon(int idx, String[] strs){
        if(strs[0].length() <= idx ) return false;
        char c = strs[0].charAt(idx);
        for(String s : strs){
            if(s.length() <= idx || c != s.charAt(idx)) return false;
        }
        return true;
    }
}
