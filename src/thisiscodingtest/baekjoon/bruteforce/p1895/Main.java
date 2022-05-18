package thisiscodingtest.baekjoon.bruteforce.p1895;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int[][] board = new int[40][40];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int t = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < r - 1; i++) {
            for (int j = 1; j < c - 1; j++) {
                list.add(applyFilter(i, j));
            }
        }
        int cnt = 0;
        for (Integer integer : list) {
            if (integer >= t) {
                cnt++;
            }
        }
        bw.write(String.valueOf(cnt));
        bw.flush();
        br.close();
        bw.close();
    }

    private static Integer applyFilter(int x, int y) {
        int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
        int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
        List<Integer> list = new ArrayList<>();
        list.add(board[x][y]);
        for (int i = 0; i < 8; i++) {
            list.add(board[x + dx[i]][y + dy[i]]);
        }
        Collections.sort(list);
        return list.get(4);
    }
}
