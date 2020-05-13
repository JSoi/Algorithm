package swacademy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class N5653 {

	public static void main(String[] args) {
		String path = N5653.class.getResource("").getPath(); // 현재 클래스의 절대 경로
		try {
			FileReader fr = new FileReader(path + "input_5653");
			BufferedReader br = new BufferedReader(fr);
			String content = br.readLine();
			int testcase = Integer.valueOf(content);
			for (int i = 0; i < testcase; i++) {
				String nmtimestr = br.readLine();
				String split[] = nmtimestr.split(" ");
				int n = Integer.valueOf(split[0]);
				int m = Integer.valueOf(split[1]);
				int time = Integer.valueOf(split[2]);
				int glass[][] = new int[n][m];
			}
		} catch (FileNotFoundException e) {
			System.out.println("파일이 존재하지 않습니다.");
			e.printStackTrace();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	

}
