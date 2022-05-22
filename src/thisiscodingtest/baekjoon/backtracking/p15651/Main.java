package thisiscodingtest.baekjoon.backtracking.p15651;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static int n;
    public static int m;
    static int[] array = new int[110];
    public static BufferedWriter bw;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        recur(0);
        bw.flush();
    }

    private static void recur(int cur) throws IOException {
        if (cur == m) {
            for (int i = 0; i < m; i++) {
                bw.write(array[i] + " ");
            }
            bw.newLine();
            return;
        }
        for (int i = 1; i <= n; i++) {
            array[cur] = i;
            recur(cur + 1);
        }
    }
}
