package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N8394 {
	static int time = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		int input = Integer.parseInt(line);
		boolean shaked[] = new boolean[input];
		go(0, shaked);
		System.out.println(time);
	}

	public static void go(int shakeIndex, boolean[] shaked) {
		if (shakeIndex >= shaked.length - 1) {
			time++;
			return;
		}
		shaked[shakeIndex] = true;
		go(shakeIndex + 2, shaked);
		shaked[shakeIndex] = false;
		go(shakeIndex + 1, shaked);
	}
}
