package thisiscodingtest.baekjoon.bruteforce.p2851;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int sum = 0;
        int dif = 100;
        int result = 0;
        for (int i = 0; i < 10; i++) {
            int cur = Integer.parseInt(br.readLine());
            sum += cur;
            if (Math.abs(sum - 100) <= dif) {
                dif = Math.abs(sum - 100);
                result = sum;
            }
        }
        bw.write(String.valueOf(result));
        bw.flush();
        br.close();
        bw.close();
    }
}