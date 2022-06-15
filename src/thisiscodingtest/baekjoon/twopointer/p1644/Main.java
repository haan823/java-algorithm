package thisiscodingtest.baekjoon.twopointer.p1644;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        boolean[] array = new boolean[n + 1];
        for (int i = 2; i * i <= n; i++) {
            if (!array[i]) {
                for (int j = i * i; j <= n; j += i) {
                    array[j] = true;
                }
            }
        }
        for (int i = 2; i <= n; i++) {
            if (!array[i]) {
                list.add(i);
            }
        }
        int s = 0;
        int e = 0;
        int sum = 0;
        int cnt = 0;
        while (true) {
            if (sum >= n) {
                sum -= list.get(s++);
            } else if (e == list.size()) {
                break;
            } else {
                sum += list.get(e++);
            }

            if (sum == n) {
                cnt++;
            }
        }
        bw.write(String.valueOf(cnt));
        bw.flush();
    }
}