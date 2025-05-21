package baekjoon;

import java.util.Scanner;
import java.util.Stack;
import java.util.stream.Collectors;

public class N9935 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String explodeStr = new StringBuilder(sc.nextLine()).reverse().toString();
        sc.close();
        int i = 0;
        Stack<Character> stack = new Stack<>();
        Stack<Character> tempStack = new Stack<>();
        while (i < s.length()) {
            stack.push(s.charAt(i++));
            if (stack.peek() != explodeStr.charAt(0)) {
                continue;
            }
            int count = 0;
            char[] arr = new char[explodeStr.length()];
            while (!stack.isEmpty() && count < explodeStr.length()) {
                if (stack.peek() != explodeStr.charAt(count)) {
                    break;
                }
                Character pop = stack.pop();
                tempStack.push(pop);
                arr[count++] = pop;
            }
            if (tempStack.size() != explodeStr.length()) {
                while (!tempStack.isEmpty()) {
                    stack.push(tempStack.pop());
                }
            }
            tempStack.clear();
        }
        System.out.println(stack.isEmpty() ? "FRULA" : stack.stream().map(String::valueOf).collect(Collectors.joining("")));
    }
}
