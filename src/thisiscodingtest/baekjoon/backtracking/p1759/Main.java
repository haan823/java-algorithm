package thisiscodingtest.baekjoon.backtracking.p1759;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int l;
    static int c;
    static char[] input = new char[15];
    static char[] array = new char[15];
    static BufferedWriter bw;
    static int cnt1;
    static int cnt2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < c; i++) {
            input[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(input);
        recur(0, 15 - c);
        bw.flush();
        br.close();
        bw.close();
    }

    private static void recur(int cur, int start) throws IOException {
        if (cur == l) {
            if (cnt1 >= 2 && cnt2 >= 1) {
                for (int i = 0; i < l; i++) {
                    bw.write(String.valueOf(array[i]));
                }
                bw.newLine();
            }
            return;
        }
        for (int i = start; i < 15; i++) {
            array[cur] = input[i];
            if (input[i] == 'a' || input[i] == 'e' || input[i] == 'i' || input[i] == 'o' || input[i] == 'u') {
                cnt2++;
            } else {
                cnt1++;
            }
            recur(cur + 1, i + 1);
            if (input[i] == 'a' || input[i] == 'e' || input[i] == 'i' || input[i] == 'o' || input[i] == 'u') {
                cnt2--;
            } else {
                cnt1--;
            }
        }
    }
}
