package baekjoon;

import java.util.Scanner;

public class N10870
{
	public static void main (String[] args)
	{
		Scanner scan = new Scanner(System.in);
		int input = scan.nextInt();
		scan.close();
		System.out.println(fibo(input));
	}
	public static int fibo(int input){
		if(input == 0) return 0;
		else if (input == 1) return 1;
		else return fibo(input-1)+fibo(input-2);
	}
	
}
