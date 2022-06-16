package thisiscodingtest.baekjoon.twopointer.p20366;

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
        int minVal = Integer.MAX_VALUE;
        for (int i = 0; i < n - 3; i++) {
            for (int j = i + 3; j < n; j++) {
                int s = i + 1;
                int e = j - 1;
                while (s < e) {
                    int gap = array[s] + array[e] - array[i] - array[j];
                    if (Math.abs(gap) < minVal) {
                        minVal = Math.abs(gap);
                    }
                    if (gap > 0) {
                        e--;
                    } else {
                        s++;
                    }
                }
            }
        }
        bw.write(String.valueOf(minVal));
        bw.flush();
        br.close();
        bw.close();
    }
}