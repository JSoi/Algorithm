package com.soi.programmers;

import java.util.Scanner;

public class POG_12930 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        scan.close();
        System.out.println(Solution(input));
    }

    public static String Solution(String s) {
        String[] chunk = s.split(" ", -1);
        String wholeword = "";
        for (int i = 0; i < chunk.length; i++) {
            String eachword = chunk[i];
            String newword = "";
            for (int k = 0; k < eachword.length(); k++) {
                if (k % 2 == 1) {
                    newword += (eachword.charAt(k) + "").toLowerCase();
                } else {
                    newword += (eachword.charAt(k) + "").toUpperCase();
                }
            }
            wholeword += newword + " ";
        }
        return wholeword.substring(0, wholeword.length() - 1);

    }
}
