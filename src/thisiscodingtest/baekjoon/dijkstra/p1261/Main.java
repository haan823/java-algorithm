package thisiscodingtest.baekjoon.dijkstra.p1261;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static int n;
    public static int m;
    public static char[][] board;
    public static boolean[][] visited;
    public static int[][] dist;
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        board = new char[n][m];
        visited = new boolean[n][m];
        dist = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = s.charAt(j);
            }
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });

        pq.add(new int[]{0, 0, 0});
        dist[0][0] = 0;
        while (!pq.isEmpty()) {
            int cx = pq.peek()[0];
            int cy = pq.peek()[1];
            pq.poll();
            if (visited[cx][cy]) {
                continue;
            }
            visited[cx][cy] = true;
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if (inRange(nx, ny) && !visited[nx][ny]) {
                    int nd;
                    if (board[nx][ny] == '1') {
                        nd = dist[cx][cy] + 1;
                    } else {
                        nd = dist[cx][cy];
                    }
                    if (dist[nx][ny] > nd) {
                        dist[nx][ny] = nd;
                        pq.add(new int[]{nx, ny, nd});
                    }
                }
            }
        }
        bw.write(String.valueOf(dist[n - 1][m - 1]));
        bw.flush();
        br.close();
        bw.close();
    }

    private static boolean inRange(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }
}
