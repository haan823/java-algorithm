package baekjoon.stack.p10773;

import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int K = Integer.parseInt(br.readLine());
        int[] input = new int[K];
        int result = 0;
        for (int i = 0; i < K; i++) {
            input[i] = Integer.parseInt(br.readLine());
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < K; i++) {
            if (input[i] == 0) {
                stack.pop();
            } else {
                stack.push(input[i]);
            }
        }
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        bw.write(String.valueOf(result));
        bw.flush();
    }
}
