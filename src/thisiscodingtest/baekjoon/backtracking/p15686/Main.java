package thisiscodingtest.baekjoon.backtracking.p15686;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static int[][] board = new int[50][50];
    static int[][] home = new int[100][2];
    static int[][] chicken = new int[13][2];
    static int[][] array = new int[13][2];
    static int cntHome;
    static int cntChicken;
    static int minDistance = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 1) {
                    home[cntHome][0] = i;
                    home[cntHome][1] = j;
                    cntHome++;
                } else if (board[i][j] == 2) {
                    chicken[cntChicken][0] = i;
                    chicken[cntChicken][1] = j;
                    cntChicken++;
                }
            }
        }
        recur(0, 0);
        bw.write(String.valueOf(minDistance));
        bw.flush();
        br.close();
        bw.close();
    }

    private static void recur(int cur, int start) {
        if (cur == m) {
            int distance = calculateChickenDistance();
            if (distance < minDistance) {
                minDistance = distance;
            }
            return;
        }
        for (int i = start; i < cntChicken; i++) {
            array[cur][0] = chicken[i][0];
            array[cur][1] = chicken[i][1];
            recur(cur + 1, i + 1);
        }
    }

    private static int calculateChickenDistance() {
        int sum = 0;
        for (int i = 0; i < cntHome; i++) {
            int tmp = Integer.MAX_VALUE;
            for (int j = 0; j < m; j++) {
                int d = Math.abs(home[i][0] - array[j][0]) + Math.abs(home[i][1] - array[j][1]);
                if (d < tmp) {
                    tmp = d;
                }
            }
            sum += tmp;
        }
        return sum;
    }
}
