package programmers;

import java.util.Collections;
import java.util.PriorityQueue;

public class L42629 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution(4, new int[] { 4, 10, 15 }, new int[] { 20, 5, 10 }, 30));
	}

	public static int solution(int stock, int[] dates, int[] supplies, int k) {
		int answer = 0;
		int day = stock; // 재고가 소진될 날을 카운튼하는 변수
		int index = 0; // dates,supplies 배열의 index
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
		while (day < k) { // 주어진 날 동안에만 진행한다
			System.out.println("Day Index : " + day);
			while (index < dates.length && dates[index] <= day) { 
				// outofrange를 반지하기 위한 index의 범위 설정과 함께 재고가 부족한지 여부를 판단한다.
				// day(버틸 수 있는 재고) 와 재고가 들어오는 날(일)과 비교해 적거나 같으면 계속 PQ에 넣어준다.
				pq.add(supplies[index]); // 해당 조건을 만족할 시 pq에 넣어준다.
				index++;
				System.out.println(pq.toString());
			}
			day += pq.poll();// 최대값을 Poll해주어 day에 더해준다
			//dates의 배열값은 누적이기 때문에 day도 supplies를 누적해서 저장한다.
			answer++;
			System.out.println(pq.toString());
		}
		return answer;
	}

}
