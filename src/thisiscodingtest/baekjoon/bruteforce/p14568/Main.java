package thisiscodingtest.baekjoon.bruteforce.p14568;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int result = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = i + 2; j <= n; j++) {
                int k = n - (i + j);
                if (k >= 1 && k % 2 == 0) {
                    result++;
                }
            }
        }
        bw.write(String.valueOf(result));
        bw.flush();
        br.close();
        bw.close();
    }
}
