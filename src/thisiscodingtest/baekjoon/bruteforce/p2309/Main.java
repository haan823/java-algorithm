package thisiscodingtest.baekjoon.bruteforce.p2309;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Integer[] integers = new Integer[9];

        int sum = 0;

        for (int i = 0; i < 9; i++) {
            integers[i] = Integer.parseInt(br.readLine());
            sum += integers[i];
        }
        List<Integer> list = new ArrayList<>();
        for (int x = 0; x < 9; x++) {
            for (int y = x + 1; y < 9; y++) {
                if (integers[x] + integers[y] + 100 == sum) {
                    for (int i = 0; i < 9; i++) {
                        if (i != x && i != y) {
                            list.add(integers[i]);
                        }
                    }
                    Collections.sort(list);
                    for (Integer integer : list) {
                        bw.write(String.valueOf(integer));
                        bw.newLine();
                    }
                    bw.flush();
                    br.close();
                    bw.close();
                    return;
                }
            }
        }
    }
}
