package thisiscodingtest.baekjoon.bruteforce.p22351;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();
        for (int i = 1; i <= 3; i++) {
            int startNum = Integer.parseInt(input.substring(0, i));
            int lastNum = findLastNum(input, startNum);
            if (lastNum != -1) {
                bw.write(startNum + " " + lastNum);
                bw.flush();
                return;
            }
        }
    }

    private static int findLastNum(String input, int num) {
        String s = String.valueOf(num);
        while (s.length() <= 2889) {
            if (input.equals(s)) {
                return num;
            }
            s += String.valueOf(++num);
        }
        return -1;
    }
}
