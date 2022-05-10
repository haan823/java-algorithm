package barkingdog.baekjoon.stack.p17298;

import java.io.*;
import java.util.Stack;
import java.util.StringJoiner;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] strings = br.readLine().split(" ");
        int[] intArray = new int[n];
        for (int i = 0; i < n; i++) {
            intArray[i] = Integer.parseInt(strings[i]);
        }
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> result = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= intArray[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                result.push(-1);
            } else {
                result.push(stack.peek());
            }
            stack.push(intArray[i]);
        }
        StringJoiner sj = new StringJoiner(" ");
        while (!result.isEmpty()) {
            sj.add(result.pop().toString());
        }
        bw.write(sj.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}
