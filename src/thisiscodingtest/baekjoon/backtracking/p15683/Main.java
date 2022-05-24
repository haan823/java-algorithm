package thisiscodingtest.baekjoon.backtracking.p15683;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][][] cctv = {{{0}, {1}, {2}, {3}}, {{0, 2}, {1, 3}}, {{0, 1}, {1, 2}, {2, 3}, {3, 4}}, {{0, 1, 3}, {0, 1, 2}, {1, 2, 3}, {0, 2, 3}}, {{0, 1, 2, 3}}};
    static int[] cctvDir = {4, 2, 4, 4, 1};
    static int[][] board = new int[8][8];
    static int minVal = Integer.MAX_VALUE;
    static int[][] array = new int[8][4]; // x, y, type, dir
    static int cnt;
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] != 0 && board[i][j] != 6) {
                    array[cnt][0] = i;
                    array[cnt][1] = j;
                    array[cnt][2] = board[i][j];
                }
            }
        }
        recur(0);
        bw.write(String.valueOf(minVal));
        bw.flush();
        br.close();
        bw.close();
    }

    private static void recur(int cur) {
        if (cur == cnt) {
            int[][] tmpBoard = makeTmpBoard();
            for (int i = 0; i < cur; i++) {
                checkBoard(i, tmpBoard);
            }
            int tmp = countBoard(tmpBoard);
            if (tmp < minVal) {
                minVal = tmp;
            }
            return;
        }
        int cctvType = array[cur][2] - 1;
        for (int i = 0; i < cctvDir[cctvType]; i++) {
            array[cur][4] = i;
            recur(cur + 1);
        }
    }

    private static void checkBoard(int cur, int[][] tmpBoard) {

    }

    private static int[][] makeTmpBoard() {
        int[][] tmpBoard = new int[8][8];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                tmpBoard[i][j] = board[i][j];
            }
        }
        return tmpBoard;
    }

    private static int countBoard(int[][] tmpBoard) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (tmpBoard[i][j] == 0) {
                    sum++;
                }
            }
        }
        return sum;
    }

}
