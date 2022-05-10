package barkingdog.baekjoon.linkedlist.p1158;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);
        LinkedList<String> linkedList = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            String s = String.valueOf(i);
            linkedList.add(s);
        }
        StringJoiner stringJoiner = new StringJoiner(", ", "<", ">");
        while (!linkedList.isEmpty()) {
            for (int i = 0; i < K - 1; i++) {
                String removedString = linkedList.remove(0);
                linkedList.add(removedString);
            }
            String removedString = linkedList.remove(0);
            stringJoiner.add(removedString);
        }
        bw.write(stringJoiner.toString());
        br.close();
        bw.flush();
        bw.close();
    }
}