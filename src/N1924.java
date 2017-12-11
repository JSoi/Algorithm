import java.util.Scanner;

public class N1924 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int month = scan.nextInt();
		int day = scan.nextInt();
		int date;
		int monthC = 0;
		switch (month) {
		case 1:
			monthC = 0;
			break;
		case 2:
			monthC = 31;
			break;
		case 3:
			monthC = 31 + 28;
			break;
		case 4:
			monthC = 31 + 28 + 31;
			break;
		case 5:
			monthC = 31 + 28 + 31 + 30;
			break;
		case 6:
			monthC = 31 + 28 + 31 + 30 + 31;
			break;
		case 7:
			monthC = 31 + 28 + 31 + 30 + 31 + 30;
			break;
		case 8:
			monthC = 31 + 28 + 31 + 30 + 31 + 30 + 31;
			break;
		case 9:
			monthC = 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31;
			break;
		case 10:
			monthC = 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + 30;
			break;
		case 11:
			monthC = 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + 31;
			break;
		case 12:
			monthC = 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + 31 + 30;
			break;
		default:
			break;
		}
		date = monthC + day;
		int dateC = date%7;
		String printStr = "";
		switch(dateC){
			case 0:
				printStr = "SUN";
				break;
			case 1:
				printStr = "MON";
				break;
			case 2:
				printStr = "TUE";
				break;
			case 3:
				printStr = "WED";
				break;
			case 4:
				printStr = "THU";
				break;
			case 5:
				printStr = "FRI";
				break;
			case 6:
				printStr = "SAT";
				break;
			default:
				break;
		}
		System.out.println(printStr);
		scan.close();
	}
}
