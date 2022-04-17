package baekjoon.queue.p2164;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        Deque<Integer> deque = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            deque.addLast(i);
        }

        while (deque.size() > 1) {
            deque.removeFirst();
            Integer first = deque.removeFirst();
            deque.addLast(first);
        }

        bw.write(deque.getFirst().toString());
        bw.flush();
        br.close();
        bw.close();
    }
}
