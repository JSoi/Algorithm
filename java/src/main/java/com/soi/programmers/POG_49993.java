package com.soi.programmers;

public class POG_49993 {

    public static void main(String[] args) {

        System.out.println(solution("CBD", new String[]{"BACDE", "CBADF", "AECB", "BDA"}));
    }

    public static int solution(String skill, String[] skill_trees) {
        int anscount = 0;
        char[] splitskill = skill.toCharArray();
        for (String test : skill_trees) {
            char[] splittest = test.toCharArray();
            int index = 0;
            boolean check = true;
            loop:
            for (int i = 0; i < splittest.length; i++) {
                for (int j = 0; j < splitskill.length; j++) {
                    if (splittest[i] == splitskill[j]) {
                        if (index == j) {
                            index++;
                        } else {
                            check = false;
                            break loop;
                        }
                    }
                }
            }
            if (check) anscount++;

        }
        return anscount;
    }
}
