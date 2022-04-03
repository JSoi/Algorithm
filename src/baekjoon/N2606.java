package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N2606 {
	static int comCount;
	static boolean[][] map;
	static boolean[] visit;
	static int count;

	static void input() throws IOException {
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		comCount = Integer.parseInt(buf.readLine());
		int conn = Integer.parseInt(buf.readLine());
		map = new boolean[comCount + 1][comCount + 1];
		visit = new boolean[comCount + 1];
		for (int i = 0; i < conn; i++) {
			String thisLine = buf.readLine();
			int a = Integer.parseInt(thisLine.split(" ")[0]);
			int b = Integer.parseInt(thisLine.split(" ")[1]);
			map[a][b] = map[b][a] = true;
			
		}
		
	}

	static void go(int index) {
		visit[index] = true;
		// 배열크기는 +1
		for (int i = 1; i < comCount + 1; i++) {
			if (map[index][i] && !visit[i]) { // 연결 & notvisited
				count++;
				go(i);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		count = 0;
		input();
		go(1);
		System.out.println(count);
	}

}
