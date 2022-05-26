package thisiscodingtest.baekjoon.backtracking.p1182;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static int[] input = new int[20];
    public static int[] array = new int[20];
    public static int n;
    public static int s;
    public static int cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i <= n; i++) {
            recur(0, i, 0);
        }
        bw.write(String.valueOf(cnt));
        bw.flush();
        br.close();
        bw.close();
    }

    private static void recur(int cur, int m, int start) {
        if (cur == m) {
            int sum = 0;
            for (int i = 0; i < m; i++) {
                sum += array[i];
            }
            if (sum == s) {
                cnt++;
            }
            return;
        }
        for (int i = start; i < n; i++) {
            array[cur] = input[i];
            recur(cur + 1, m, i + 1);
        }
    }
}