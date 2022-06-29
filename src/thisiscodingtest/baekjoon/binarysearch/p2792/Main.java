package thisiscodingtest.baekjoon.binarysearch.p2792;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static int n;
    public static int m;
    public static int[] array;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        array = new int[m];
        int s = 1;
        int e = 0;
        for (int i = 0; i < m; i++) {
            array[i] = Integer.parseInt(br.readLine());
            e = Math.max(e, array[i]);
        }
        int ans = 0;
        while (s <= e) {
            int mid = (s + e) / 2;
            if (check(mid)) {
                ans = mid;
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        bw.write(String.valueOf(ans));
        bw.flush();
        br.close();
        bw.close();
    }

    private static boolean check(int mid) {
        int sum = 0;
        for (int i = 0; i < m; i++) {
            if (array[i] % mid == 0) {
                sum += array[i] / mid;
            } else {
                sum += (array[i] / mid + 1);
            }
        }
        return sum <= n;
    }
}