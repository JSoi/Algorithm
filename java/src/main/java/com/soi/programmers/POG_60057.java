package com.soi.programmers;

import java.util.Scanner;

public class POG_60057 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String m = scan.next(); // M<=N
        scan.close();
        int smalllength = m.length();
        for (int i = 1; i < m.length() / 2; i++) {
            int smallsolval = smallsol(m, i);
            if (smallsolval <= smalllength)
                smalllength = smallsolval;
        }
        System.out.println(smalllength);
    }

    public static int smallsol(String s, int len) {
        String strs = "";
        String flen = "";
        int smallre = 1;
        for (int start = 0; start < s.length(); start += len) {
            if (start + len > s.length()) {
                if (smallre == 1) {
                    flen += strs;
                } else {
                    flen += smallre + strs;
                }
                flen += s.substring(start);
                //System.out.println("Bstart : " + start + " / Bend : " + (start + len));
                break;
            }
            //System.out.println("start : " + start + " / end : " + (start + len));
            String compare = s.substring(start, start + len);
            if (strs.equals(compare)) {
                smallre++;
            } else {

                if (smallre == 1) {
                    flen += strs;
                } else {
                    flen += smallre + strs;
                }
                strs = compare;
                smallre = 1;
            }
            if (start + len == s.length()) {
                if (smallre == 1) {
                    flen += strs;
                } else {
                    flen += smallre + strs;
                }
                //System.out.println("Estart : " + start + " / Eend : " + (start + len));
            }

        }
        //System.out.println(flen);
        return flen.length();
    }
}
