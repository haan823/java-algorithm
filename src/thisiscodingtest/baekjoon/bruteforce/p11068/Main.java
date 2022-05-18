package thisiscodingtest.baekjoon.bruteforce.p11068;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            bw.write(String.valueOf(checkInt(Integer.parseInt(br.readLine()))));
            bw.newLine();
        }
        bw.flush();
        br.close();
        bw.close();
    }

    private static int checkInt(int x) {
        for (int i = 2; i <= 64; i++) {
            List<String> converted = convert(x, i);
            if (isPalindrome(converted)) {
                return 1;
            }
        }
        return 0;
    }

    private static boolean isPalindrome(List<String> s) {
        int lp = 0;
        int rp = s.size() - 1;
        while (lp < rp) {
            if (!s.get(lp).equals(s.get(rp))) {
                return false;
            }
            lp++;
            rp--;
        }
        return true;
    }

    private static List<String> convert(int x, int i) {
        List<String> list = new ArrayList<>();
        while (x > 0) {
            list.add(String.valueOf(x % i));
            x /= i;
        }
        return list;
    }
}