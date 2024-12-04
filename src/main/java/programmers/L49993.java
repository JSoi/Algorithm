package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class L49993 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution("CBD", new String[] { "BACDE", "CBADF", "AECB", "BDA" }));
	}

	public static int solution(String skill, String[] skill_trees) {
		int anscount = 0;
		char[] splitskill = skill.toCharArray();
		for (String test : skill_trees) { // 모든 케이스에 대해 검사
			char[] splittest = test.toCharArray();
			int index = 0;
			boolean check = true;
			loop:
			for(int i = 0; i < splittest.length; i ++) {
				for(int j = 0 ; j < splitskill.length; j++) {
					if(splittest[i]==splitskill[j]) {
						if(index==j) {
							index++;
						}
						else {
							check = false;
							break loop;
						}
					}
				}
			}
			if(check) anscount++;
			
		}
		return anscount;
	}
}
