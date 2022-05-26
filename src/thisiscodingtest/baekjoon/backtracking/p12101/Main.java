package thisiscodingtest.baekjoon.backtracking.p12101;

import java.io.*;
import java.util.StringJoiner;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int k;
    static int cnt;
    static boolean flag;
    static int[] array = new int[10];
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        recur(0, 0);
        if (!flag) {
            bw.write(String.valueOf(-1));
        }
        bw.flush();
        br.close();
        bw.close();
    }

    private static void recur(int cur, int sum) throws IOException {
        if (cur > n || (cur == n && sum != n)) {
            return;
        }
        if (sum == n) {
            cnt++;
            if (k == cnt) {
                flag = true;
                StringJoiner sj = new StringJoiner("+");
                for (int i = 0; i < cur; i++) {
                    sj.add(String.valueOf(array[i]));
                }
                bw.write(sj.toString());
                bw.newLine();
            }
            return;
        }
        for (int i = 1; i <= 3; i++) {
            array[cur] = i;
            recur(cur + 1, sum + i);
        }
    }
}
