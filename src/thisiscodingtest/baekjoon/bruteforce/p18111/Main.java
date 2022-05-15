package thisiscodingtest.baekjoon.bruteforce.p18111;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int[][] board = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int height = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                height += board[i][j];
            }
        }
        height = (height + b) / (n * m);
        int minTime = Integer.MAX_VALUE;
        int maxHeight = 0;
        for (int i = 0; i <= height; i++) {
            int time = 0;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (board[j][k] >= i) {
                        time += 2 * (board[j][k] - i);
                    } else {
                        time += (i - board[j][k]);
                    }
                }
            }
            if (time < minTime) {
                minTime = time;
                maxHeight = i;
            } else if (time == minTime) {
                if (i > maxHeight) {
                    maxHeight = i;
                }
            }
        }
        bw.write(String.valueOf(minTime) + " " + String.valueOf(maxHeight));
        bw.flush();
        br.close();
        bw.close();
    }
}
