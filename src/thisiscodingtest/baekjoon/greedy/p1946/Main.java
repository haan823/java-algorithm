package thisiscodingtest.baekjoon.greedy.p1946;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st;
            int[][] array = new int[n][2];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                array[i][0] = Integer.parseInt(st.nextToken());
                array[i][1] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(array, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0] - o2[0];
                }
            });
            int rank = array[0][1];
            int cnt = 1;
            for (int i = 1; i < n; i++) {
                if (array[i][1] < rank) {
                    rank = array[i][1];
                    cnt++;
                }
            }
            bw.write(String.valueOf(cnt));
            bw.newLine();
        }
        bw.flush();
    }
}