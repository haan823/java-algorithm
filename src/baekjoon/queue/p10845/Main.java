package baekjoon.queue.p10845;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String[] strings = br.readLine().split(" ");
            Deque<Integer> list = new LinkedList<>();
            switch (strings[0]) {
                case "push":
                    list.addFirst(Integer.valueOf(strings[1]));
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
                        bw.write(list.getFirst());
                        bw.newLine();
                    }
                    break;
                case "back":
                    if (list.isEmpty()) {
                        bw.write("-1");
                        bw.newLine();
                    } else {
                        bw.write(list.getLast());
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
