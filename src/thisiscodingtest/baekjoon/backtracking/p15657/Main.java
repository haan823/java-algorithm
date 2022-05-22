package thisiscodingtest.baekjoon.backtracking.p15657;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int[] array = new int[8];
    public static int[] input = new int[]{10001, 10001, 10001, 10001, 10001, 10001, 10001, 10001, 10001};
    public static int n;
    public static int m;
    public static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(input);
        recur(0);
        bw.flush();
    }

    private static void recur(int cur) throws IOException {
        if (cur >= 2) {
            if (array[cur - 2] > array[cur - 1]) {
                return;
            }
        }
        if (cur == m) {
            for (int i = 0; i < m; i++) {
                bw.write(array[i] + " ");
            }
            bw.newLine();
            return;
        }
        for (int i = 0; i < n; i++) {
            array[cur] = input[i];
            recur(cur + 1);
        }
    }
}


