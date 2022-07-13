package thisiscodingtest.baekjoon.greedy.p2138;

import java.io.*;

public class Main {
    public static int n;
    public static int[] tmp;
    public static int[] res;
    public static int cnt = 0;
    public static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        String input = br.readLine();
        String result = br.readLine();
        tmp = new int[n];
        res = new int[n];
        for (int i = 0; i < n; i++) {
            tmp[i] = Integer.parseInt(input.substring(i, i + 1));
            res[i] = Integer.parseInt(result.substring(i, i + 1));
        }
        int[] tmp2 = tmp.clone();

        solve(0);
        tmp = tmp2.clone();
        cnt = 0;
        solve(1);
        if (ans != Integer.MAX_VALUE) {
            bw.write(String.valueOf(ans));
        } else {
            bw.write(String.valueOf(-1));
        }
        bw.flush();
    }

    private static void solve(int x) {
        if (x == 0) {
            change(tmp, x);
            cnt++;
        }
        for (int i = 1; i < n; i++) {
            if (tmp[i - 1] != res[i - 1]) {
                change(tmp, i);
                cnt++;
            }
        }
        if (check(tmp, res)) {
            ans = Math.min(ans, cnt);
        }
    }

    private static boolean check(int[] array1, int[] array2) {
        for (int i = 0; i < array1.length; i++) {
            if (array1[i] != array2[i]) {
                return false;
            }
        }
        return true;
    }

    private static int[] change(int[] array, int index) {
        for (int i = index - 1; i <= index + 1; i++) {
            if (i >= 0 && i < array.length) {
                array[i] = (array[i] + 1) % 2;
            }
        }
        return array;
    }
}