package baekjoon.queue.p18258;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Deque<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            String[] strings = br.readLine().split(" ");
            switch (strings[0]) {
                case "push":
                    list.addLast(Integer.valueOf(strings[1]));
                    break;
                case "pop":
                    if (list.isEmpty()) {
                        bw.write("-1");
                        bw.newLine();
                    } else {
                        bw.write(list.removeFirst().toString());
                        bw.newLine();
                    }
                    break;
                case "size":
                    bw.write(String.valueOf(list.size()));
                    bw.newLine();
                    break;
                case "empty":
                    if (list.isEmpty()) {
                        bw.write("1");
                        bw.newLine();
                    } else {
                        bw.write("0");
                        bw.newLine();
                    }
                    break;
                case "front":
                    if (list.isEmpty()) {
                        bw.write("-1");
                        bw.newLine();
                    } else {
                        bw.write(list.getFirst().toString());
                        bw.newLine();
                    }
                    break;
                case "back":
                    if (list.isEmpty()) {
                        bw.write("-1");
                        bw.newLine();
                    } else {
                        bw.write(list.getLast().toString());
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
