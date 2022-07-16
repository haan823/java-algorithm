package thisiscodingtest.baekjoon.greedy.p19590;

import java.io.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] array = new int[n];
        long sum = 0L;
        int maxVal = Integer.MIN_VALUE;
        for(int i=0; i<n; i++) {
            array[i] = Integer.parseInt(br.readLine());
            sum += array[i];
            maxVal = Math.max(maxVal, array[i]);
        }
        if(maxVal >= sum-maxVal) {
            bw.write(String.valueOf(maxVal - (sum - maxVal)));
        } else {
            bw.write(String.valueOf(sum%2));
        }

        bw.flush();
        bw.close();
        br.close();

    }

}