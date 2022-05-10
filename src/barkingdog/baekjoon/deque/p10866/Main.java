package barkingdog.baekjoon.deque.p10866;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            switch (s[0]) {
                case "push_front":
                    deque.addFirst(Integer.valueOf(s[1]));
                    break;
                case "push_back":
                    deque.addLast(Integer.valueOf(s[1]));
                    break;
                case "pop_front":
                    if (deque.isEmpty()) {
                        bw.write(String.valueOf(-1));
                        bw.newLine();
                    } else {
                        bw.write(String.valueOf(deque.removeFirst()));
                        bw.newLine();
                    }
                    break;
                case "pop_back":
                    if (deque.isEmpty()) {
                        bw.write(String.valueOf(-1));
                        bw.newLine();
                    } else {
                        bw.write(String.valueOf(deque.removeLast()));
                        bw.newLine();
                    }
                    break;
                case "size":
                    bw.write(String.valueOf(deque.size()));
                    bw.newLine();
                    break;
                case "empty":
                    if (deque.isEmpty()) {
                        bw.write(String.valueOf(1));
                        bw.newLine();
                    } else {
                        bw.write(String.valueOf(0));
                        bw.newLine();
                    }
                    break;
                case "front":
                    if (deque.isEmpty()) {
                        bw.write(String.valueOf(-1));
                        bw.newLine();
                    } else {
                        bw.write(String.valueOf(deque.getFirst()));
                        bw.newLine();
                    }
                    break;
                case "back":
                    if (deque.isEmpty()) {
                        bw.write(String.valueOf(-1));
                        bw.newLine();
                    } else {
                        bw.write(String.valueOf(deque.getLast()));
                        bw.newLine();
                    }
                    break;
            }
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
