package thisiscodingtest.baekjoon.prefixsum.p14846;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[][][] prefix = new int[n + 1][n + 1][11];
        StringTokenizer st;
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                int x = Integer.parseInt(st.nextToken());
                for (int k = 1; k <= 10; k++) {
                    prefix[i][j][k] = prefix[i][j - 1][k] + prefix[i - 1][j][k] - prefix[i - 1][j - 1][k];
                }
                prefix[i][j][x]++;
            }
        }
        int q = Integer.parseInt(br.readLine());
        while (q-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int result = 0;
            for (int k = 1; k <= 10; k++) {
                int cnt = prefix[x2][y2][k] - prefix[x1 - 1][y2][k] - prefix[x2][y1 - 1][k] + prefix[x1 - 1][y1 - 1][k];
                if (cnt > 0) {
                    result++;
                }
            }
            bw.write(String.valueOf(result));
            bw.newLine();
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
