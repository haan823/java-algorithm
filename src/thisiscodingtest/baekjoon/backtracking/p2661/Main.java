package thisiscodingtest.baekjoon.backtracking.p2661;

import java.io.*;

public class Main {
    static int n;
    static int[] array = new int[80];
    static boolean fin;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        recur(0);
        bw.flush();
        br.close();
        bw.close();
    }

    private static void recur(int cur) throws IOException {
        if (fin) {
            return;
        }
        if (cur >= 2) {
            int k = cur / 2;
            boolean check;
            for (int i = 1; i <= k; i++) {
                check = true;
                for (int j = cur - 1; j >= cur - i; j--) {
                    if (array[j] != array[j - i]) {
                        check = false;
                        break;
                    }
                }
                if (check) {
                    return;
                }
            }
        }
        if (cur == n) {
            for (int i = 0; i < n; i++) {
                bw.write(String.valueOf(array[i]));
            }
            bw.newLine();
            fin = true;
            return;
        }
        for (int i = 1; i <= 3; i++) {
            array[cur] = i;
            recur(cur + 1);
        }
    }
}
