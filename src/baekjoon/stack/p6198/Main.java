package baekjoon.stack.p6198;

import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        long result = 0;
        while (n-- > 0) {
            int h = Integer.parseInt(br.readLine());
            while (!stack.isEmpty() && stack.peek() <= h) {
                stack.pop();
            }
            result += stack.size();
            stack.push(h);
        }
        bw.write(String.valueOf(result));
        bw.flush();
        br.close();
        bw.close();
    }
}
