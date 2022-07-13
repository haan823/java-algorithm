package thisiscodingtest.baekjoon.greedy.p2437;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] array = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(array);
        int result = 0;
        for (int i = 0; i < n; i++) {
            if (result + 1 < array[i]) {
                break;
            }
            result += array[i];
        }
        bw.write(String.valueOf(result + 1));
        bw.flush();
    }
}
