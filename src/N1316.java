import java.util.Scanner;

public class N1316 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int lineNum = scan.nextInt();
		scan.nextLine();
		int gNum = 0;
		for (int i = 0; i < lineNum; i++) {
			String line = scan.nextLine();
			if (group(line)) { // 이전거랑 다르면!
				gNum++;
			}
		}
		System.out.println(gNum);
		scan.close();
	}

	public static boolean group(String input) {
		boolean tf = true;
		char[] inputArr = input.toCharArray();
		boolean[] alpC = new boolean[26];
		for (int k = 0; k < alpC.length; k++) { // 초기화
			alpC[k] = false; // 발견되지 않았다! 처음이다 라고 false 표시
		}
		char check = 0;
		for (int i = 0; i < inputArr.length; i++) {
			if(inputArr[i] != check) { // 똑같은 문자가 아닌 경우에만 그룹 문자 체크해야 된다!
				if(!alpC[(int)inputArr[i]-97]) { // 처음등장_false, 최초
					check = inputArr[i];
					alpC[(int)inputArr[i]-97] = true; // 발견했다고 체크!
				}
				else { // 최초가 아니다 _> 그룹단어 만족하지 않음
					tf = false;
					break;
				}
			}
		}
		return tf;
	}
}
