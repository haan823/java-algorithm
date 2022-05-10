package thisiscodingtest.baekjoon.bruteforce.p16283;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int a = Integer.valueOf(input[0]);
        int b = Integer.valueOf(input[1]);
        int n = Integer.valueOf(input[2]);
        int w = Integer.valueOf(input[3]);

        List<Integer> list = new ArrayList<>();

        for (int i = 1; i < n; i++) {
            int j = n - i;
            if (a * i + b * j == w) {
                list.add(i);
                list.add(j);
            }
        }

        if (list.size() == 2) {
            bw.write(String.valueOf(list.get(0)));
            bw.write(" ");
            bw.write(String.valueOf(list.get(1)));
        } else {
            bw.write(String.valueOf(-1));
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
