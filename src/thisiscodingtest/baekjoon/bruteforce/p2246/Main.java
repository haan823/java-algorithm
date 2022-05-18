package thisiscodingtest.baekjoon.bruteforce.p2246;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] d = new int[n];
        int[] c = new int[n];
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            d[i] = Integer.parseInt(s[0]);
            c[i] = Integer.parseInt(s[1]);
        }
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            boolean flag = true;
            for (int j = 0; j < n; j++) {
                if (d[j] < d[i]) {
                    if (c[j] <= c[i]) {
                        flag = false;
                        break;
                    }
                }
                if (c[j] < c[i]) {
                    if (d[j] <= d[i]) {
                        flag = false;
                        break;
                    }
                }
            }
            if (flag) {
                cnt++;
            }
        }
        bw.write(String.valueOf(cnt));
        bw.flush();
        br.close();
        bw.close();
    }
}
