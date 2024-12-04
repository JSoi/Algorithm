package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N1049 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputLine = br.readLine();
        int brokenLine = Integer.parseInt(inputLine.split(" ")[0]);
        int count = Integer.parseInt(inputLine.split(" ")[1]);
        int oneMin = Integer.MAX_VALUE;
        int sixMin = Integer.MAX_VALUE;
        while (count-- > 0) {
            String[] lineStr = br.readLine().split(" ");
            oneMin = Math.min(oneMin, Integer.parseInt(lineStr[1]));
            sixMin = Math.min(sixMin, Integer.parseInt(lineStr[0]));
        }
        int answer = Integer.MAX_VALUE;
        answer = Math.min(answer, oneMin * brokenLine);
        answer = Math.min(answer, (sixMin) * (brokenLine / 6) + Math.min(oneMin * (brokenLine % 6), sixMin));
        System.out.println(answer);
    }
}
