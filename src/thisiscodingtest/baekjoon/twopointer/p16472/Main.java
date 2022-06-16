package thisiscodingtest.baekjoon.twopointer.p16472;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String string = br.readLine();
        char[] array = string.toCharArray();

        int s = 0;
        int e = 0;
        int maxValue = 0;
        int cnt = 0;
        int[] alphabet = new int[26];
        while (true) {
            if (e - s > maxValue) {
                maxValue = e - s;
            }
            if (e == array.length) {
                break;
            }
            int i = alphabet[array[e] - 'a'];
            alphabet[array[e++] - 'a']++;
            if (i == 0) {
                cnt++;
            }
            while (cnt > n) {
                alphabet[array[s] - 'a']--;
                if (alphabet[array[s] - 'a'] == 0) {
                    cnt--;
                }
                s++;
            }
        }
        bw.write(String.valueOf(maxValue));
        bw.flush();
    }
}