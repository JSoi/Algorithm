package baekjoon;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

public class N1181 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int lineNum = scan.nextInt();
		ArrayList<String> arr = new ArrayList<String>();
		for (int i = 0; i < lineNum; i++) {
			arr.add(scan.next());
		}
		scan.close();
		
		TreeSet<String> distinctData = new TreeSet<String>(arr);
        arr = new ArrayList<String>(distinctData);
        
		Collections.sort(arr, new Comparator<String>() {

			@Override
			public int compare(String arg0, String arg1) {
				// TODO Auto-generated method stub
				if (arg0.length() > arg1.length()) {
					return 1;
				} 
				else if (arg0.length() == arg1.length()) {
					return arg0.compareTo(arg1);
				} else {
					return -1;
				}
			}

		});


		for (int k = 0; k < arr.size(); k++) {
			System.out.println(arr.get(k));
		}
	}
}
