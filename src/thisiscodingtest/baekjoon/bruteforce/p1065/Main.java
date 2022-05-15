package thisiscodingtest.baekjoon.bruteforce.p1065;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if (checkInt(i)) {
                cnt++;
            }
        }
        bw.write(String.valueOf(cnt));
        bw.flush();
        br.close();
        bw.close();
    }

    private static boolean checkInt(int i) {
        if (i < 10) {
            return true;
        }
        int gap = (i / 10) % 10 - (i % 10);
        while (i >= 10) {
            if ((i / 10) % 10 - (i % 10) == gap) {
                i /= 10;
            } else {
                return false;
            }
        }
        return true;
    }
}
