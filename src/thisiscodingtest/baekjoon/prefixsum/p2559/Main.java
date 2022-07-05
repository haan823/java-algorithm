package thisiscodingtest.baekjoon.prefixsum.p2559;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] array = new int[n + 1];
        int[] prefix = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
            prefix[i] = prefix[i - 1] + array[i];
        }
        int result = -10000000;
        for (int i = k; i <= n; i++) {
            result = Math.max(result, (prefix[i] - prefix[i - k]));
        }
        bw.write(String.valueOf(result));
        bw.flush();
        br.close();
        bw.close();
    }
}