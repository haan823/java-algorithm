package thisiscodingtest.baekjoon.bruteforce.p2948;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int months[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String weeks[] = {"Thursday", "Friday", "Saturday", "Sunday", "Monday", "Tuesday", "Wednesday"};
        StringTokenizer st = new StringTokenizer(br.readLine());
        int d = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int day = 0;
        for (int i = 1; i < m; i++) {
            day += months[i - 1];
        }
        day += (d-1);
        bw.write(weeks[day%7]);
        bw.flush();
        br.close();
        bw.close();
    }
}
