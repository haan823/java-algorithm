package thisiscodingtest.baekjoon.binarysearch.p13423;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int n;
    public static int[] array;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());
            array = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                array[j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(array);
            int cnt = 0;
            for (int k = 1; k < n-1; k++) {
                int s = 0;
                int e = n - 1;
                while (s < e) {
                    int l = array[k] - array[s];
                    int r = array[e] - array[k];
                    if (l == r) {
                        cnt++;
                        s++;
                    } else if (l < r) {
                        e--;
                    } else {
                        s++;
                    }
                }
            }
            bw.write(String.valueOf(cnt));
            bw.newLine();
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
