package programmers;

import java.util.Arrays;

public class L42885 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution_2(new int[] { 70, 50, 80, 50 }, 100));
		System.out.println(solution_2(new int[] { 70, 80, 50 }, 100));
	}

	public static int solution(int[] people, int limit) {
		// 구명 보트는 두 명 까지밖에 타지 못한다.

		int totalBoatCount = 0;
		int rescuedCount = 0;
		Arrays.sort(people);
		int f = 0;
		int b = people.length - 1;
		while (rescuedCount < people.length) {
			if (b == f) {
				totalBoatCount++;
				rescuedCount++;
				break;
			}
			if (people[f] + people[b] <= limit) {
				f++;
				b--;
				rescuedCount += 2;
				totalBoatCount++;
			} else {
				b--;
				totalBoatCount++;
				rescuedCount++;
			}
			// 50 50 70 80
		}
		return totalBoatCount;
	}

	public static int solution_2(int[] people, int limit) {
		// 구명 보트는 두 명 까지밖에 타지 못한다.
		Arrays.sort(people);
		int i = 0, j = people.length - 1;
		for (; i < j; j--) {
			if (people[i] + people[j] <= limit) {
				i++;
			}
		}
		return people.length - i;

	}
}
