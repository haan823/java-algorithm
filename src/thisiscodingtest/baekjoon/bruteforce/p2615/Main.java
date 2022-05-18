package thisiscodingtest.baekjoon.bruteforce.p2615;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[][] baduk = new int[19][19];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < 19; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 19; j++) {
                baduk[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                if (baduk[i][j] != 0) {
                    int result = check5mok(i, j);
                    if (result != 0) {
                        bw.write(String.valueOf(result));
                        bw.newLine();
                        bw.write(String.valueOf(i + 1) + " " + String.valueOf(j + 1));
                        bw.flush();
                        return;
                    }
                }
            }
        }
        bw.write(String.valueOf(0));
        bw.flush();
    }

    private static int check5mok(int cx, int cy) {
        int[] dx = {-1, 0, 1, 1};
        int[] dy = {1, 1, 1, 0};
        int cur = baduk[cx][cy];
        for (int i = 0; i < 4; i++) {
            boolean flag = true;
            for (int j = 1; j < 5; j++) {
                int nx = cx + dx[i] * j;
                int ny = cy + dy[i] * j;
                if (!inRange(nx, ny) || cur != baduk[nx][ny]) {
                    flag = false;
                    break;
                }
            }
            if (inRange(cx + dx[i] * 5, cy + dy[i] * 5) && cur == baduk[cx + dx[i] * 5][cy + dy[i] * 5]) {
                flag = false;
            }
            if (inRange(cx - dx[i], cy - dy[i]) && cur == baduk[cx - dx[i]][cy - dy[i]]) {
                flag = false;
            }
            if (flag) {
                return cur;
            }
        }
        return 0;
    }

    private static boolean inRange(int nx, int ny) {
        return nx>=0 && nx<19 && ny>=0 && ny<19;
    }
}
