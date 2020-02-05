package programmers;

import java.util.ArrayList;
import java.util.Arrays;

public class L42840 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,3,2,4,2};
		//System.out.println("first : " + Arrays.toString(solution(arr)));
	}
	//1�� �����ڰ� ��� ���: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
	//
	//2�� �����ڰ� ��� ���: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
	//3�� �����ڰ� ��� ���: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...
	
	/**
	 * 1) ������ �Ⱦ 1,2,3�� ������ �ϳ��� ���ϴ� ���
	 * 2) 1,2,3�� ��� �����ؼ� ����� �� ���ϴ� ���
	 * */
	
	public static int[] solution(int[] answers) {
    	int[] fo = {1, 2, 3, 4, 5};
    	int[] so = {2, 1, 2, 3, 2, 4, 2, 5};
    	int[] to = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
    	int corr_f = 0, corr_s = 0, corr_t = 0;
    	for(int i = 0; i < answers.length; i++) {
    		if(answers[i]==fo[i%5]) corr_f++;
    		if(answers[i]==so[i%8]) corr_s++;
    		if(answers[i]==to[i%10]) corr_t++;
    	}
    	int max = Math.max(Math.max(corr_f, corr_s), corr_t);
        ArrayList<Integer> list = new ArrayList<Integer>();
    	if(max==corr_f) list.add(1);
    	if(max==corr_s) list.add(2);
    	if(max==corr_t) list.add(3);
    	int answer[] = new int[list.size()];
    	for(int i = 0; i < list.size(); i++) {
    		answer[i] = list.get(i);
    	}
        return answer;
    }
}