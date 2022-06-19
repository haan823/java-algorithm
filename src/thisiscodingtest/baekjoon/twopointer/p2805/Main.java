package thisiscodingtest.baekjoon.twopointer.p2805;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static int[] array;
    public static int n;
    public static int m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        array = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        int s = 0;
        int e = 1000000000;
        int ans = 0;
        while (s <= e) {
            int mid = (s + e) / 2;
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

    private static boolean check(int mid) {
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += Math.max(0, array[i] - mid);
        }
        return sum >= m;
    }
}
