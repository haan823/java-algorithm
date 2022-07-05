package thisiscodingtest.baekjoon.binarysearch.p15573;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    public static int n;
    public static int m;
    public static int k;
    public static int[][] array;
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        array = new int[n][m];
        k = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int s = 1;
        int e = 1000000;
        int answer = 0;
        while (s <= e) {
            int mid = (s + e) / 2;
            if (count(mid) >= k) {
                answer = mid;
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        bw.write(String.valueOf(answer));
        bw.flush();
        br.close();
        bw.close();
    }

    private static int count(int mid) {
        int cnt = 0;
        LinkedList<Integer> qx = new LinkedList<>();
        LinkedList<Integer> qy = new LinkedList<>();
        boolean visited[][] = new boolean[n][m];
        for (int i = 0; i < m; i++) {
            if (check(0, i, mid)) {
                qx.add(0);
                qy.add(i);
                visited[0][i] = true;
                cnt++;
            }
        }
        while (!qx.isEmpty()) {
            int cx = qx.removeFirst();
            int cy = qy.removeFirst();
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if (inRange(nx, ny) && check(nx, ny, mid) && !visited[nx][ny]) {
                    qx.add(nx);
                    qy.add(ny);
                    visited[nx][ny] = true;
                    cnt++;
                }
            }
        }
        return cnt;
    }

    private static boolean inRange(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }

    private static boolean check(int i, int j, int mid) {
        return array[i][j] <= mid;
    }
}
