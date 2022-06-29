package thisiscodingtest.baekjoon.binarysearch.p2110;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int n;
    public static int c;
    public static int[] array;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(array);

        int s = 1;
        int e = array[n - 1] - array[0] + 1;
        int ans = 0;
        while (s <= e) {
            int mid = (s + e) / 2;
            if (check(mid) < c) {
                e = mid - 1;
            } else {
                ans = mid;
                s = mid + 1;
            }
        }

        bw.write(String.valueOf(ans));
        bw.flush();
        br.close();
        bw.close();
    }

    private static int check(int mid) {
        int sum = 1;
        int pre = array[0];
        for (int i = 1; i < array.length; i++) {
            int l = array[i];
            if (l - pre >= mid) {
                sum++;
                pre = l;
            }
        }
        return sum;
    }
}