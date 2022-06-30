package thisiscodingtest.baekjoon.binarysearch.p1300;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        long s = 1;
        long e = k;

        while (s <= e) {
            long mid = (s + e) / 2;
            long cnt = 0;
            for (int i = 1; i <= n; i++) {
                cnt += Math.min(mid / i, n);
            }
            if (cnt >= k) {
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        bw.write(String.valueOf(s));
        bw.flush();
        br.close();
        bw.close();
    }
}