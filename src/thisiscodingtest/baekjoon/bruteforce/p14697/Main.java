package thisiscodingtest.baekjoon.bruteforce.p14697;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= 300; i++) {
            for (int j = 0; j <= 300; j++) {
                for (int k = 0; k <= 300; k++) {
                    if (a * i + b * j + c * k == n) {
                        bw.write(String.valueOf(1));
                        bw.flush();
                        br.close();
                        bw.close();
                        return;
                    }
                }
            }
        }
        bw.write(String.valueOf(0));
        bw.flush();
        br.close();
        bw.close();
    }
}
