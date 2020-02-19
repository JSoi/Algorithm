package programmers;

public class L12982_dfs {
	public static int bud;
	public static int answer;
	public static int[] arr;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution(new int[] { 1, 3, 2, 5, 4 }, 9));
	}

	public static int solution(int[] d, int budget) {
		bud = budget;
		answer = 0;
		arr = d;
		dfs(0, 0, 0);
		return answer;
	}

	public static void dfs(int count, int index, int sum) {
		if (sum > bud)
			return;
		if (index == arr.length) {
			if (sum <= bud)
				answer = Math.max(answer, count);
		} else {
			dfs(count, index + 1, sum);
			count += 1;
			if (sum + arr[index] <= bud)
				dfs(count, index + 1, sum + arr[index]);
		}
	}
}
