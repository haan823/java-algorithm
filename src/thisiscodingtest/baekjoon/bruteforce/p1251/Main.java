package thisiscodingtest.baekjoon.bruteforce.p1251;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        List<String> list = new ArrayList<>();
        String s = br.readLine();
        int length = s.length();
        for (int i = 1; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                char[] s1 = s.substring(0, i).toCharArray();
                char[] s2 = s.substring(i, j).toCharArray();
                char[] s3 = s.substring(j, length).toCharArray();

                String result = reverseString(s1, s2, s3);
                list.add(result);
            }
        }
        Collections.sort(list);
        bw.write(list.get(0));
        bw.flush();
        br.close();
        bw.close();
    }

    private static String reverseString(char[] s1, char[] s2, char[] s3) {
        StringJoiner sj = new StringJoiner("");
        for (int i = s1.length - 1; i >= 0; i--) {
            sj.add(String.valueOf(s1[i]));
        }
        for (int i = s2.length - 1; i >= 0; i--) {
            sj.add(String.valueOf(s2[i]));
        }
        for (int i = s3.length - 1; i >= 0; i--) {
            sj.add(String.valueOf(s3[i]));
        }
        return sj.toString();
    }

}
