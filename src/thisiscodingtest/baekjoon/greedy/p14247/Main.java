package thisiscodingtest.baekjoon.greedy.p14247;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long maxVal = 0L;
        for (int i = 0; i < n; i++) {
            maxVal += Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = Integer.valueOf(st.nextToken());
        }
        Arrays.sort(array);
        for (int i = 0; i < n; i++) {
            maxVal += (array[i] * i);
        }
        bw.write(String.valueOf(maxVal));
        bw.flush();
    }
}