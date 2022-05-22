package thisiscodingtest.baekjoon.backtracking.p15654;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int[] array = new int[8];
    public static boolean[] visited = new boolean[8];
    public static int[] input = new int[]{10001, 10001, 10001, 10001, 10001, 10001, 10001, 10001, 10001};
    public static int n;
    public static int m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(input);
        recur(0);
    }

    private static void recur(int cur) {
        if (cur == m) {
            for (int i = 0; i < m; i++) {
                System.out.print(array[i] + " ");
            }
            System.out.println();
            return;
        }
        for (int i = 0; i < n; i++) {
            if(visited[i]) continue;

            array[cur] = input[i];
            visited[i] = true;
            recur(cur + 1);
            visited[i] = false;
        }
    }
}