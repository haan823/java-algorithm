package thisiscodingtest.baekjoon.dijkstra.p2636;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static int n;
    public static int m;
    public static int[][] board;
    public static boolean[][] visited;
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};
    public static int time;
    public static int cnt;
    public static int total;
    public static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][m];
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 1) {
                    total++;
                }
            }
        }
        result = total;
        while (cnt < total) {
            time++;
            visited = new boolean[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (i == 0 || i == n - 1 || j == 0 || j == m - 1) {
                        q.add(new int[]{i, j});
                        visited[i][j] = true;
                    }
                }
            }
            while (!q.isEmpty()) {
                int cx = q.peek()[0];
                int cy = q.peek()[1];
                q.poll();
                if (board[cx][cy] == 1) {
                    cnt++;
                    board[cx][cy] = 0;
                    continue;
                }
                for (int i = 0; i < 4; i++) {
                    int nx = cx + dx[i];
                    int ny = cy + dy[i];
                    if (inRange(nx, ny) && !visited[nx][ny]) {
                        q.add(new int[]{nx, ny});
                        visited[nx][ny] = true;
                    }
                }
            }
            if (total != cnt) {
                result = total - cnt;
            }
        }

        bw.write(String.valueOf(time));
        bw.newLine();
        bw.write(String.valueOf(result));
        bw.flush();
        br.close();
        bw.close();
    }

    private static boolean inRange(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }
}