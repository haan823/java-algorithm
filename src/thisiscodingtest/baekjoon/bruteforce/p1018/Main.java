package thisiscodingtest.baekjoon.bruteforce.p1018;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static String[][] board;
    public static String[][] checkBoard = {{"B", "W", "B", "W", "B", "W", "B", "W"},
            {"W", "B", "W", "B", "W", "B", "W", "B"},
            {"B", "W", "B", "W", "B", "W", "B", "W"},
            {"W", "B", "W", "B", "W", "B", "W", "B"},
            {"B", "W", "B", "W", "B", "W", "B", "W"},
            {"W", "B", "W", "B", "W", "B", "W", "B"},
            {"B", "W", "B", "W", "B", "W", "B", "W"},
            {"W", "B", "W", "B", "W", "B", "W", "B"}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        board = new String[n][m];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = String.valueOf(s.charAt(j));
            }
        }
        int minVal = Integer.MAX_VALUE;
        for (int i = 0; i <= n - 8; i++) {
            for (int j = 0; j <= m - 8; j++) {
                int cnt = check(i, j);
                if (cnt < minVal) {
                    minVal = cnt;
                }
            }
        }
        bw.write(String.valueOf(minVal));
        bw.flush();
        br.close();
        bw.close();
    }

    private static int check(int x, int y) {
        int cnt = 0;
        for (int i = x; i < x + 8; i++) {
            for (int j = y; j < y + 8; j++) {
                if (board[i][j].equals(checkBoard[i - x][j - y])) {
                    cnt++;
                }
            }
        }
        return Math.min(cnt, 64 - cnt);
    }
}
