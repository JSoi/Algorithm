package com.soi.programmers;

import java.util.Collections;
import java.util.PriorityQueue;

public class L42629 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution(4, new int[] { 4, 10, 15 }, new int[] { 20, 5, 10 }, 30));
	}

	public static int solution(int stock, int[] dates, int[] supplies, int k) {
		int answer = 0;
		int day = stock; // ��� ������ ���� ī��ư�ϴ� ����
		int index = 0; // dates,supplies �迭�� index
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
		while (day < k) { // �־��� �� ���ȿ��� �����Ѵ�
			System.out.println("Day Index : " + day);
			while (index < dates.length && dates[index] <= day) { 
				// outofrange�� �����ϱ� ���� index�� ���� ������ �Բ� ��� �������� ���θ� �Ǵ��Ѵ�.
				// day(��ƿ �� �ִ� ���) �� ��� ������ ��(��)�� ���� ���ų� ������ ��� PQ�� �־��ش�.
				pq.add(supplies[index]); // �ش� ������ ������ �� pq�� �־��ش�.
				index++;
				System.out.println(pq.toString());
			}
			day += pq.poll();// �ִ밪�� Poll���־� day�� �����ش�
			//dates�� �迭���� �����̱� ������ day�� supplies�� �����ؼ� �����Ѵ�.
			answer++;
			System.out.println(pq.toString());
		}
		return answer;
	}

}
