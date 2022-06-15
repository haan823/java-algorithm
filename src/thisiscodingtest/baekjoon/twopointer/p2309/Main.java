package thisiscodingtest.baekjoon.twopointer.p2309;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] input = new int[9];
        int x = 0;
        for (int i = 0; i < 9; i++) {
            input[i] = Integer.parseInt(br.readLine());
            x += input[i];
        }
        x -= 100;
        Arrays.sort(input);

        int s = 0;
        int e = 8;

        while (s < e) {
            if (input[s] + input[e] == x) {
                for (int i = 0; i < 9; i++) {
                    if (i == s || i == e) {
                        continue;
                    }
                    bw.write(String.valueOf(input[i]));
                    bw.newLine();
                }
                break;
            } else if (input[s] + input[e] < x) {
                s++;
            } else {
                e--;
            }
        }
        bw.flush();
    }
}