package baekjoon.stack.p10828;

import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        String[] commands = new String[N];
        for (int i = 0; i < N; i++) {
            commands[i] = br.readLine();
        }
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            String[] s = commands[i].split(" ");
            switch (s[0]) {
                case "push":
                    stack.push(s[1]);
                    break;
                case "pop":
                    if (stack.isEmpty()) {
                        System.out.println("-1");
                    } else {
                        System.out.println(stack.pop());
                    }
                    break;
                case "size":
                    System.out.println(stack.size());
                    break;
                case "empty":
                    if (stack.isEmpty()) {
                        System.out.println("1");
                    } else {
                        System.out.println("0");
                    }
                    break;
                case "top":
                    if (stack.isEmpty()) {
                        System.out.println("-1");
                    } else {
                        System.out.println(stack.peek());
                    }
                    break;
            }
        }
    }
}
