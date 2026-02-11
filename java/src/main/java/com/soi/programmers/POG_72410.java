package com.soi.programmers;

public class POG_72410 {

    public static void main(String[] args) {

        System.out.println(solution("=.="));
    }


    public static String solution(String new_id) {
        new_id = new_id.toLowerCase();// 1
        String tempni = "";
        for (int j = 0; j < new_id.length(); j++) {// 2
            if ("abcdefghijklmnopqrstuvwxyz0123456789-_.".contains(new_id.charAt(j) + "")) {
                tempni += new_id.charAt(j);
            }
        }
        new_id = tempni;
        while (new_id.contains("..")) {// 3
            new_id = new_id.replace("..", ".");
        }
        if (new_id.length() > 0 && new_id.charAt(0) == '.') {// 4-1
            new_id = new_id.length() == 1 ? "" : new_id.substring(1);
        }
        if (new_id.length() > 0 && new_id.charAt(new_id.length() == 1 ? 0 : new_id.length() - 1) == '.') {// 4-2
            new_id = new_id.length() == 1 ? "" : new_id.substring(0, new_id.length() - 1);
        }
        if (new_id.length() == 0) {
            new_id = "a";
        }
        if (new_id.length() >= 16) {
            if (new_id.charAt(14) == '.') {
                new_id = new_id.substring(0, 14);
            } else {
                new_id = new_id.substring(0, 15);
            }
        }
        if (new_id.length() <= 2) {
            char target = new_id.charAt(new_id.length() - 1);
            while (new_id.length() < 3) {
                new_id += target;
            }
        }
        return new_id;
    }
}
