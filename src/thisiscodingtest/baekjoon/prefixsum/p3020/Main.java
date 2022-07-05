package thisiscodingtest.baekjoon.prefixsum.p3020;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int[] array = new int[h + 1];
        int[] prefix = new int[h + 1];
        for (int i = 0; i < n; i++) {
            int tmp = Integer.parseInt(br.readLine());
            if (i % 2 == 0) {
                array[1] += 1;
                array[tmp + 1] -= 1;
            } else {
                array[h - tmp + 1] += 1;
            }
        }
        for (int i = 1; i <= h; i++) {
            prefix[i] = prefix[i - 1] + array[i];
        }
        int minVal = Integer.MAX_VALUE;
        int cnt = 0;
        for (int i = 1; i <= h; i++) {
            if (prefix[i] < minVal) {
                cnt=1;
                minVal = prefix[i];
            } else if (prefix[i] == minVal) {
                cnt++;
            }
        }

        bw.write(minVal + " " + cnt);
        bw.flush();
        br.close();
        bw.close();
    }
}