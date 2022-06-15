package thisiscodingtest.baekjoon.twopointer.p3273;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[] input;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        input = new int[n];
        for (int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(input);
        int x = Integer.parseInt(br.readLine());

        int s = 0;
        int e = n - 1;
        int cnt = 0;

        while (s < e) {
            int sum = input[s] + input[e];
            if (sum == x) {
                cnt++;
            }
            if (sum <= x) {
                s++;
            } else {
                e--;
            }
        }
        bw.write(String.valueOf(cnt));
        bw.flush();
    }
}
