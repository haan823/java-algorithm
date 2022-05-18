package thisiscodingtest.baekjoon.bruteforce.p14503;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int[][] board = new int[50][50];
    static int n = 0;
    static int m = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int x = r;
        int y = c;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int cnt = 0;
        while (true) {
            if (board[x][y] == 0) {
                board[x][y] = 2;
                cnt++;
            }
            boolean flag = true;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[(d + 3) % 4];
                int ny = y + dy[(d + 3) % 4];
                d = (d + 3) % 4;
                if (inRange(nx, ny) && board[nx][ny] == 0) {
                    x = nx;
                    y = ny;
                    flag = false;
                    break;
                }
            }
            if (flag) {
                int nx = x - dx[d];
                int ny = y - dy[d];
                if (board[nx][ny] == 1) {
                    break;
                } else {
                    x = nx;
                    y = ny;
                }
            }

        }
        bw.write(String.valueOf(cnt));
        bw.flush();
        br.close();
        bw.close();
    }

    private static boolean inRange(int x, int y) {
        return x>=0 && x<n && y>=0 && y<m;
    }
}