package com.soi.baekjoon;

import java.util.Scanner;

public class BOJ_2941 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String input = scan.next();
        scan.close();
        char[] inputChar = input.toCharArray();
        int count = 0;
        for (int i = 0; i < inputChar.length; i++) {
            count++;
            if (inputChar[i] == '=') {
                if (inputChar[i - 1] == 'z' && i - 2 >= 0) {
                    if (inputChar[i - 2] == 'd') { // dz=
                        count -= 2;
                    } else { // cz=
                        count -= 1;
                    }
                } else { // z=, c=, s=, z=
                    if (inputChar[i - 1] == 'z' || inputChar[i - 1] == 'c' || inputChar[i - 1] == 's') {
                        count -= 1;
                    }
                }
            } else if (inputChar[i] == '-') { // c-, d-
                if (inputChar[i - 1] == 'c' || inputChar[i - 1] == 'd') {
                    count -= 1;
                }
            } else if (inputChar[i] == 'j' && i - 1 >= 0) {// lj, nj
                if (inputChar[i - 1] == 'l' || inputChar[i - 1] == 'n') {
                    count -= 1;
                }
            }
        }
        System.out.println(count);
    }

}
