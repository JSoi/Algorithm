package com.soi.programmers;

public class L147355 {
    public int solution(String t, String p) {
        int answer = 0;
        long pToStr = Long.parseLong(p);
        int length = p.length();
        for(int i = 0; i <= t.length() - length; i++){
            long part = Long.parseLong(t.substring(i, Math.min(i+length, t.length()+1)));
            if(pToStr >= part){
                answer++;
            }
        }
        return answer;
    }
}
