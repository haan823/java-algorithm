package thisiscodingtest.baekjoon.twopointer.p2003;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] input = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        int s = 0;
        int e = 0;
        int cnt = 0;
        int sum = 0;
        while (true) {
            if (sum >= m) {
                sum -= input[s++];
            } else if (e == n) {
                break;
            } else {
                sum += input[e++];
            }

            if (sum == m) {
                cnt++;
            }

        }
        bw.write(String.valueOf(cnt));
        bw.flush();
    }
}