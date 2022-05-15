package thisiscodingtest.baekjoon.bruteforce.p4673;

import java.io.*;

public class Main {
    public static boolean[] constructor;
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        constructor = new boolean[10001];
        for (int i = 1; i <= 10000; i++) {
            checkD(i);
            if (!constructor[i]) {
                bw.write(String.valueOf(i));
                bw.newLine();
            }
        }
        bw.flush();
        bw.close();
    }

    private static void checkD(int i) {
        int sum = i;
        while (i > 0) {
            sum += (i % 10);
            i /= 10;
        }
        if (sum <= 10000) {
            constructor[sum] = true;
        }
    }
}