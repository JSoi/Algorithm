package baekjoon;

import java.util.Scanner;

public class N1212 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String octalValue = scanner.nextLine();
        System.out.println(toBinaryStringOfOctal(octalValue));
    }

    private static String toBinaryStringOfOctal(String octal) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < octal.length(); i++) {
            StringBuilder binaryString = new StringBuilder(Integer.toBinaryString(octal.charAt(i) - '0'));
            while (binaryString.length() < 3) {
                binaryString.insert(0, "0");
            }
            builder.append(binaryString);
        }
        String result = builder.toString();
        while (result.startsWith("0")) {
            result = result.substring(1);
        }
        return result.isEmpty() ? "0" : result;
    }
}
