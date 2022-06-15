package thisiscodingtest.baekjoon.twopointer.p9007;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int[][] array = new int[4][n];
            for (int j = 0; j < 4; j++) {
                st = new StringTokenizer(br.readLine());
                for (int l = 0; l < n; l++) {
                    array[j][l] = Integer.parseInt(st.nextToken());
                }
            }
            int[] tmp1 = new int[n * n];
            int[] tmp2 = new int[n * n];
            int x = 0;
            for (int j = 0; j < n; j++) {
                for (int l = 0; l < n; l++) {
                    tmp1[x] = array[0][j] + array[1][l];
                    tmp2[x] = array[2][j] + array[3][l];
                    x++;
                }
            }
            Arrays.sort(tmp1);
            Arrays.sort(tmp2);
            int s = 0;
            int e = n * n - 1;
            int minVal = Integer.MAX_VALUE;
            int sum = 0;
            while (s < n * n && e >= 0) {
                int abs = Math.abs(tmp1[s] + tmp2[e] - k);
                if (abs < minVal) {
                    minVal = abs;
                    sum = tmp1[s] + tmp2[e];
                } else if (abs == minVal) {
                    if (tmp1[s] + tmp2[e] < sum) {
                        sum = tmp1[s] + tmp2[e];
                    }
                }

                if (tmp1[s] + tmp2[e] > k) {
                    e--;
                } else if (tmp1[s] + tmp2[e] < k) {
                    s++;
                } else {
                    s++;
                }
            }
            bw.write(String.valueOf(sum));
            bw.newLine();
        }
        bw.flush();
        br.close();
        bw.close();
    }
}