package thisiscodingtest.baekjoon.backtracking.p2529;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static String[] input = new String[9];
    public static int[] array = new int[10];
    public static boolean[] visited = new boolean[10];
    public static int[][] ints = {{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, {9, 8, 7, 6, 5, 4, 3, 2, 1, 0}};
    public static int k;
    public static boolean fin;
    public static BufferedWriter bw;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        k = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            input[i] = st.nextToken();
        }
        recur(0, 1);
        fin = false;
        recur(0, 0);
        bw.flush();
        br.close();
        bw.close();
    }

    private static void recur(int cur, int option) throws IOException {
        if (fin) {
            return;
        }
        if (cur >= 2) {
            if (input[cur - 2].equals("<") && array[cur - 2] >= array[cur - 1]) {
                return;
            }
            if (input[cur - 2].equals(">") && array[cur - 2] <= array[cur - 1]) {
                return;
            }
        }
        if (cur == k + 1) {
            for (int i = 0; i < cur; i++) {
                bw.write(String.valueOf(array[i]));
            }
            bw.newLine();
            fin = true;
            return;
        }
        for (int i = 0; i < 10; i++) {
            if (visited[i]) {
                continue;
            }
            array[cur] = ints[option][i];
            visited[i] = true;
            recur(cur + 1, option);
            visited[i] = false;
        }
    }
}