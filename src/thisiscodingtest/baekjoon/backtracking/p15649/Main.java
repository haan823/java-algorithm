package thisiscodingtest.baekjoon.backtracking.p15649;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static int[] array = new int[110];
    static boolean[] visited = new boolean[110];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        recur(0);
        bw.flush();
    }

    private static void recur(int cur) {
        if (cur == m) {
            for (int i = 0; i < m; i++) {
                System.out.print(array[i] + " ");
            }
            System.out.println();
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (visited[i]) {
                continue;
            }
            array[cur] = i;
            visited[i] = true;
            recur(cur + 1);
            visited[i] = false;
        }
    }
}