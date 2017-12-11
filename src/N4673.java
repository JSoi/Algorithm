
public class N4673 {
	public static void main(String[] args) {
		int list[] = new int[10001];
		for (int i = 0; i < 10001; i++) {
			list[i] = i;
		}
		for (int k = 1; k < 10001; k++) {
			if (list[k] != 0) {
				int target = list[k];
				while ((target = hap(target)) <= 10000) {
					list[target] = 0;
				}
			}
		}
		for (int p = 1; p < 10001; p++) {
			if (list[p] != 0) {
				System.out.println(p);
			}
		}
	}

	public static int hap(int X) {
		int num = X;
		int sum = 0;
		while (num != 0) {
			sum += num % 10;
			num /= 10;
		}
		return X + sum;
	}
}
