package thisiscodingtest.baekjoon.binarysearch.p1637;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static int minValue;
    public static int maxValue;
    public static int n;
    public static int[] a;
    public static int[] c;
    public static int[] b;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        minValue = Integer.MAX_VALUE;
        maxValue = Integer.MIN_VALUE;

        n = Integer.parseInt(br.readLine());
        a = new int[n];
        c = new int[n];
        b = new int[n];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            a[i] = Integer.parseInt(st.nextToken());
            c[i] = Integer.parseInt(st.nextToken());
            b[i] = Integer.parseInt(st.nextToken());
            minValue = Math.min(minValue, a[i]);
            maxValue = Math.max(maxValue, c[i]);
        }
        long s = minValue;
        long e = maxValue;

        boolean flag = false;
        while (s <= e) {
            long mid = (s + e) / 2;
            long sum = getSum(mid);
            if (sum % 2 == 0) {
                s = mid + 1;
            } else {
                flag = true;
                e = mid - 1;
            }
        }
        if (!flag) {
            bw.write("NOTHING");
        } else {
            long result = getSum(s) - getSum(s - 1);
            bw.write(s + " " + result);
        }
        bw.flush();
        br.close();
        bw.close();
    }

    private static long getSum(long mid) {
        long sum = 0;
        for (int i = 0; i < n; i++) {
            if (mid >= a[i]) {
                sum += (Math.min(mid, c[i]) - a[i]) / b[i] + 1;
            }
        }
        return sum;
    }
}