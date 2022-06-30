package thisiscodingtest.baekjoon.binarysearch.p1981;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static int n;
    public static int[][] array;
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};
    public static int minVal = Integer.MAX_VALUE;
    public static int maxVal = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        array = new int[n][n];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                array[i][j] = Integer.parseInt(st.nextToken());
                maxVal = Math.max(maxVal, array[i][j]);
                minVal = Math.min(minVal, array[i][j]);
            }
        }

        int s = 0;
        int e = maxVal - minVal;
        int answer = 0;
        while (s <= e) {
            int mid = (s + e) / 2;
            if (check(mid)) {
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

    private static boolean check(int mid) {
        for (int i = minVal; i + mid <= maxVal; i++) {
            int min = i;
            int max = i + mid;
            LinkedList<Integer> qx = new LinkedList<>();
            LinkedList<Integer> qy = new LinkedList<>();
            boolean[][] visited = new boolean[n][n];
            if (!(array[0][0] >= min && array[0][0] <= max)) {
                continue;
            }
            qx.add(0);
            qy.add(0);
            visited[0][0] = true;
            while (!qx.isEmpty()) {
                int cx = qx.removeFirst();
                int cy = qy.removeFirst();
                if (cx == n - 1 && cy == n - 1) {
                    return true;
                }
                for (int j = 0; j < 4; j++) {
                    int nx = cx + dx[j];
                    int ny = cy + dy[j];
                    if (inRange(nx, ny) && !visited[nx][ny] && array[nx][ny] >= min && array[nx][ny] <= max) {
                        qx.add(nx);
                        qy.add(ny);
                        visited[nx][ny] = true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean inRange(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }
}