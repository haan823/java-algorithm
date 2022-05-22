package thisiscodingtest.baekjoon.bruteforce.p1913;

import java.io.*;

public class Main {
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());
        int[][] board = new int[1000][1000];
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        int x = 0;
        int y = 0;
        int d = 0;
        int num = n * n;
        while (true) {
            if (board[x][y] != 0) {
                break;
            }
            board[x][y] = num--;
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (!inRange(nx, ny) || board[nx][ny] != 0) {
                d = (d + 1) % 4;
                nx = x + dx[d];
                ny = y + dy[d];
            }
            x = nx;
            y = ny;
        }
        int rx = 0;
        int ry = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == c) {
                    rx = i + 1;
                    ry = j + 1;
                }
                bw.write(board[i][j] + " ");
            }
            bw.newLine();
        }
        bw.write(rx + " " + ry);
        bw.flush();
        br.close();
        bw.close();
    }

    private static boolean inRange(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }
}
