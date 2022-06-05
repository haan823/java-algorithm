package thisiscodingtest.baekjoon.backtracking.p1497;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int m;
    static String[][] array = new String[100][2];
    static int minVal = Integer.MAX_VALUE;
    static int mx = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            array[i][0] = st.nextToken();
            array[i][1] = st.nextToken();
        }

        recur(0, 0, "NNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNN");
        if (mx == 0) {
            minVal = -1;
        }
        bw.write(String.valueOf(minVal));
        bw.flush();
    }

    public static void recur(int cur, int cnt, String s) {
        int cntY = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'Y') {
                cntY++;
            }
        }
        if (cntY > mx) {
            mx = cntY;
            minVal = cnt;
        } else if (cntY == mx) {
            if (minVal > cnt) {
                minVal = cnt;
            }
        }
        if (cur == n) {
            return;
        }

        recur(cur + 1, cnt + 1, merge(s, array[cur][1]));
        recur(cur + 1, cnt, s);
    }

    private static String merge(String a, String b) {
        String c = "";
        for (int i = 0; i < b.length(); i++) {
            if (a.charAt(i) == 'Y' || b.charAt(i) == 'Y') {
                c += "Y";
            } else {
                c += "N";
            }
        }
        return c;
    }
}