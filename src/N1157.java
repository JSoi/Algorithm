import java.util.Scanner;

public class N1157 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		input = input.toLowerCase();
		int[] alpC = new int[26];
		char[] inputArr = input.toCharArray();
		for(int i = 0; i < inputArr.length; i++) {
			alpC[(int)inputArr[i]-97]++;
		}
		char OChar = 0;
		int large = 0;
		for(int k = 0; k < alpC.length; k++) {
			if(large < alpC[k]) {
				large = alpC[k];
				OChar = (char)(k+97);
			}
			else if( large == alpC[k]) {
				large = alpC[k];
				OChar = '?';
			}
			
		}
		scan.close();
		String forUpper = String.valueOf(OChar);
		System.out.println(forUpper.toUpperCase());
	}
}
