package thisiscodingtest.baekjoon.bruteforce.p15593;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] time = new int[1001];
        int sum = 0;
        int min = 0;
        int[] start = new int[n];
        int[] end = new int[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            start[i] = s;
            end[i] = e;
            for (int j = s; j < e; j++) {
                if (time[j] == 0) {
                    sum++;
                }
                time[j]++;
            }
        }
        for (int i = 0; i < n; i++) {
            int s = start[i];
            int e = end[i];
            int cnt = 0;
            for (int j = s; j < e; j++) {
                if (time[j] == 1) {
                    cnt++;
                }
            }
            if (sum - cnt > min) {
                min = sum - cnt;
            }
        }
        bw.write(String.valueOf(min));
        bw.flush();
        br.close();
        bw.close();
    }
}
