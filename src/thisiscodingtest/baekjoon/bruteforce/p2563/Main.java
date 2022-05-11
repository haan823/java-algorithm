package thisiscodingtest.baekjoon.bruteforce.p2563;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[][] board = new int[100][100];
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            for (int j = x; j < x + 10; j++) {
                for (int k = y; k < y + 10; k++) {
                    if (board[j][k] == 0) {
                        board[j][k] = 1;
                        cnt++;
                    }
                }
            }
        }
        bw.write(String.valueOf(cnt));
        bw.flush();
        br.close();
        bw.close();
    }
}

