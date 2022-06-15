package thisiscodingtest.baekjoon.twopointer.p2467;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(array);
        int s = 0;
        int e = n - 1;
        int i = 0;
        int j = 0;
        int minVal = Integer.MAX_VALUE;
        while (s < e) {
            int sum = array[s] + array[e];
            if (Math.abs(sum) < minVal) {
                minVal = Math.abs(sum);
                i = s;
                j = e;
            }
            if (sum >= 0) {
                e--;
            } else {
                s++;
            }
        }
        bw.write(array[i] + " " + array[j]);
        bw.flush();
    }
}