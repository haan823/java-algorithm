package thisiscodingtest.baekjoon.twopointer.p14465;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        boolean[] array = new boolean[100100];
        for (int i = 0; i < b; i++) {
            int i1 = Integer.parseInt(br.readLine());
            array[i1] = true;
        }
        int cnt = 0;
        for (int i = 1; i <= k; i++) {
            if (array[i]) {
                cnt++;
            }
        }
        int minVal = cnt;
        for (int i = 1; i + k - 1 < n; i++) {
            if (array[i]) {
                cnt--;
            }
            if (array[i+k]) {
                cnt++;
            }
            minVal = Math.min(minVal, cnt);
        }
        bw.write(String.valueOf(minVal));
        bw.flush();
    }
}