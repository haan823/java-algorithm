package baekjoon.stack.p2493;

import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        int[] input = new int[N];
        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(s[i]);
        }

        class Tuple {
            int first;
            int second;

            public Tuple(int first, int second) {
                this.first = first;
                this.second = second;
            }
        }
        Stack<Tuple> stack = new Stack<>();
        stack.push(new Tuple(100000001, 0));
        for (int i=0; i<input.length; i++) {
            while (stack.peek().first < input[i]) {
                stack.pop();
            }
            bw.write(stack.peek().second + " ");
            stack.push(new Tuple(input[i], i + 1));
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
