package leetcode;

import java.util.Arrays;

public class L567 {
    public boolean checkInclusion(String s1, String s2) {
        int[] check= new int[27];
        for(int i =0; i < s1.length(); i++){
            check[s1.charAt(i)-'a']++;
        }
        for(int i =0; i <= s2.length()-s1.length(); i++){
            int[] temp= new int[27];
            for(int j = i; j <i+s1.length(); j++){
                temp[s2.charAt(j)-'a']++;
            }
            if(Arrays.equals(temp,check)){
                return true;
            }
        }
        return false;
    }
}
