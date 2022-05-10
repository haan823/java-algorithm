package thisiscodingtest.baekjoon.bruteforce.p1145;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= 1000000; i++) {
            int cnt = 0;
            if (i % a == 0) {
                cnt++;
            }
            if (i % b == 0) {
                cnt++;
            }
            if (i % c == 0) {
                cnt++;
            }
            if (i % d == 0) {
                cnt++;
            }
            if (i % e == 0) {
                cnt++;
            }
            if (cnt >= 3) {
                bw.write(String.valueOf(i));
                break;
            }
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
