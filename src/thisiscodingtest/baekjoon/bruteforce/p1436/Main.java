package thisiscodingtest.baekjoon.bruteforce.p1436;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int i = 0;
        List<Integer> list = new ArrayList<>();
        while(true){
            if (list.size() == n) {
                bw.write(String.valueOf(list.get(n - 1)));
                break;
            }
            String s = String.valueOf(i);
            if (s.contains("666")) {
                list.add(i);
            }
            i++;
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
