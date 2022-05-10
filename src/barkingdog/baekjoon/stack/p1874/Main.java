package barkingdog.baekjoon.stack.p1874;

import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] input = new int[n];
        for (int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(br.readLine());
        }
        Stack<Integer> stack = new Stack<>();
        int cur = 1;
        for (int i = 0; i < n; i++) {
            while (cur <= input[i]) {
                stack.push(cur++);
                sb.append("+\n");
            }
            if (!stack.peek().equals(input[i])) {
                bw.write("NO");
                bw.flush();
                br.close();
                bw.close();
                return;
            }
            stack.pop();
            sb.append("-\n");
        }
        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}
