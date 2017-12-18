import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class N2108 {

	public static void main(String[] args) {
		int inputNumber;
		ArrayList<Integer> arr = new ArrayList<Integer>();
		ArrayList<Integer> frequency = new ArrayList<Integer>();
		Scanner scan = new Scanner(System.in);

		inputNumber = scan.nextInt();

		for (int i = 0; i < inputNumber; i++) {
			int num = scan.nextInt();
			arr.add(num);
		}

		scan.close();
		Collections.sort(arr);

		int max = 1;
		int nowfreq = 0;
		int bfNum = -4001; // 첫번째 숫자가 아닌 수로 진행한다
		int hap = 0;
		for (int k = 0; k < inputNumber; k++) {
			int Number = arr.get(k);
			hap += Number;
			nowfreq++;
			if (bfNum != Number) {
				nowfreq = 1;
				bfNum = Number;
			}
			
			if (nowfreq == max) { // 빈도수 같으면 같은 빈도수 리스트에 넣어줌
				frequency.add(arr.get(k));
			} else if (nowfreq > max) { // 현재 빈도수가 더 크면!
				max = nowfreq;
				frequency.clear();
				frequency.add(Number);
			}
		}

		int middleCount = inputNumber / 2;
		int most = (frequency.size() >= 2) ? 1 : 0;
		double avr = (double)hap / (double)inputNumber;
		System.out.println(Math.round(avr));
		System.out.println(arr.get(middleCount)); // 중앙값
		System.out.println(frequency.get(most)); // 최빈값
		System.out.println(arr.get(inputNumber - 1) - arr.get(0)); // 범위
	}

}
