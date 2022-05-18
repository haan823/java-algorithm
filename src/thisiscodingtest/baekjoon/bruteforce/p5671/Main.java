package thisiscodingtest.baekjoon.bruteforce.p5671;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = "";
        while ((input = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(input);
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int cnt = 0;
            for (int i = n; i <= m; i++) {
                cnt += checkInt(i);
            }
            bw.write(String.valueOf(cnt));
            bw.newLine();
            bw.flush();
        }
    }

    private static int checkInt(int i) {
        int[] array = new int[10];
        while (i > 0) {
            int p = i % 10;
            if (array[p] != 0) {
                return 0;
            }
            array[p] = 1;
            i /= 10;
        }
        return 1;
    }
}
