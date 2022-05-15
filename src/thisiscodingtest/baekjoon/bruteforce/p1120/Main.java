package thisiscodingtest.baekjoon.bruteforce.p1120;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String a = st.nextToken();
        String b = st.nextToken();
        int lenA = a.length();
        int lenB = b.length();
        int result = 0;
        int maxVal = 0;
        for (int i = 0; i < lenB - lenA + 1; i++) {
            int cnt = 0;
            for (int j = 0; j < lenA; j++) {
                if (a.charAt(j) == b.charAt(i + j)) {
                    cnt++;
                }
            }
            if (cnt > maxVal) {
                maxVal = cnt;
            }
        }
        result = lenA - maxVal;
        bw.write(String.valueOf(result));
        bw.flush();
        br.close();
        bw.close();
    }
}
