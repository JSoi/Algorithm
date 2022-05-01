package leetcode;

public class L3 {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0|| s.length()==1){
            return s.length();
        }
        int count = 0;
        for(int i = 0 ; i < s.length()-1; i++){
            String temp  = s.charAt(i)+"";
            for(int j =i+1; j < s.length(); j++){
                if(temp.contains(s.charAt(j)+"")){
                    break;
                }
                temp+=s.charAt(j);
            }
            count = Math.max(count, temp.length());
        }
        return count;
    }
}
