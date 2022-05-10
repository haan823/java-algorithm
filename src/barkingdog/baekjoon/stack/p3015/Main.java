package barkingdog.baekjoon.stack.p3015;

import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        class Pair {
            int h;
            int cnt;

            public Pair(int h, int cnt) {
                this.h = h;
                this.cnt = cnt;
            }
        }
        int n = Integer.parseInt(br.readLine());
        Stack<Pair> stack = new Stack<>();
        long result = 0;
        for (int i = 0; i < n; i++) {
            int h = Integer.parseInt(br.readLine());
            int cnt = 1;
            while (!stack.isEmpty() && stack.peek().h <= h) {
                result += stack.peek().cnt;
                if (stack.peek().h == h) {
                    cnt += stack.peek().cnt;
                }
                stack.pop();
            }
            if (!stack.isEmpty()) {
                result++;
            }
            stack.push(new Pair(h, cnt));
        }
        bw.write(Long.toString(result));
        bw.flush();
        br.close();
        bw.close();
    }
}