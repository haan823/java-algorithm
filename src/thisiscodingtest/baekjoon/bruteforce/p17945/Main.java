package thisiscodingtest.baekjoon.bruteforce.p17945;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        List<Integer> collect = Arrays.stream(input).map(s -> Integer.valueOf(s)).collect(Collectors.toList());
        StringJoiner sj = new StringJoiner(" ");
        for (int i = -1000; i <= 1000; i++) {
            if ((i * i) + (2 * collect.get(0) * i) + collect.get(1) == 0) {
                sj.add(String.valueOf(i));
            }
        }
        bw.write(sj.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}
