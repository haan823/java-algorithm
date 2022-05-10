package thisiscodingtest.baekjoon.bruteforce.p6131;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int result = 0;

        for (int a = 1; a <= 500; a++) {
            for (int b = 1; b <= 500; b++) {
                if (Math.pow(a, 2) == Math.pow(b, 2) + n) {
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
