package thisiscodingtest.baekjoon.twopointer.p1654;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static int[] array;
    public static int k;
    public static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        array = new int[k];
        for (int i = 0; i < k; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }
        long s = 1;
        long e = Integer.MAX_VALUE;
        long ans = 0;
        while (s <= e) {
            long mid = (s + e) / 2;
            if (check(mid)) {
                ans = mid;
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        bw.write(String.valueOf(ans));
        bw.flush();
    }

    private static boolean check(long mid) {
        long sum = 0;
        for (int i = 0; i < k; i++) {
            sum += array[i] / mid;
        }
        return sum >= n;
    }
}
