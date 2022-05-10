package barkingdog.baekjoon.deque.p1021;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int result = 0;

        LinkedList<Integer> deque = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            deque.addLast(i);
        }
        List<Integer> collect = Arrays.stream(br.readLine().split(" "))
                .map(val -> Integer.parseInt(val)).collect(Collectors.toList());

        for (int i = 0; i < m; i++) {
            int read = collect.get(i);
            int idx = deque.indexOf(read);
            if (idx <= deque.size() - 1 - idx) {
                while (true) {
                    if (deque.getFirst() == read) {
                        deque.removeFirst();
                        break;
                    }
                    deque.addLast(deque.removeFirst());
                    result++;
                }
            } else {
                while (true) {
                    if (deque.getFirst() == read) {
                        deque.removeFirst();
                        break;
                    }
                    deque.addFirst(deque.removeLast());
                    result++;
                }
            }
        }
        bw.write(String.valueOf(result));
        bw.flush();
        br.close();
        bw.close();
    }
}
