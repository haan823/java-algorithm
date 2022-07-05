package thisiscodingtest.baekjoon.prefixsum.p14453;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[][] prefix = new int[3][n + 1];
        char[] hps = {'H', 'P', 'S'};
        for (int i = 1; i <= n; i++) {
            char c = br.readLine().charAt(0);
            for (int j = 0; j < 3; j++) {
                if (hps[j] == c) {
                    prefix[j][i] = prefix[j][i - 1] + 1;
                } else {
                    prefix[j][i] = prefix[j][i - 1];
                }
            }
        }
        int result = 0;
        for (int i = 0; i <= n; i++) {
            int tmp = max(prefix[0][i], prefix[1][i], prefix[2][i]) + max(prefix[0][n] - prefix[0][i], prefix[1][n] - prefix[1][i], prefix[2][n] - prefix[2][i]);
            result = Math.max(result, tmp);
        }
        bw.write(String.valueOf(result));
        bw.flush();
        br.close();
        bw.close();
    }

    private static int max(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }
}
