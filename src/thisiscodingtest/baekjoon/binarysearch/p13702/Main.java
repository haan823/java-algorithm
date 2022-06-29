package thisiscodingtest.baekjoon.binarysearch.p13702;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static int n;
    public static int k;
    public static int[] array;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        array = new int[n];
        long e = 0;
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(br.readLine());
            e = Math.max(e, array[i]);
        }
        long s = 1;
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
        br.close();
        bw.close();
    }

    private static boolean check(long mid) {
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += array[i] / mid;
        }
        return sum >= k;
    }
}
