package thisiscodingtest.baekjoon.backtracking.p15650;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static int n;
    public static int m;
    static int[] array = new int[110];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        recur(0, 1);
        bw.flush();
    }

    private static void recur(int cur, int start) {
        if (cur == m) {
            for (int i = 0; i < m; i++) {
                System.out.print(array[i] + " ");
            }
            System.out.println();
            return;
        }
        for (int i = start; i <= n; i++) {
            array[cur] = i;
            recur(cur + 1, i + 1);
        }
    }
}
