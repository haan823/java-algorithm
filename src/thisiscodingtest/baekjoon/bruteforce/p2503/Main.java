package thisiscodingtest.baekjoon.bruteforce.p2503;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[][] input = new int[n][3];
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            input[i][0] = Integer.parseInt(st.nextToken());
            input[i][1] = Integer.parseInt(st.nextToken());
            input[i][2] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                for (int k = 1; k < 10; k++) {
                    if (i != j && i != k && j != k) {
                        int strike = 0;
                        int ball = 0;
                        boolean flag = false;
                        for (int l = 0; l < n; l++) {
                            ball = checkBall(i, j, k, String.valueOf(input[l][0]).toCharArray());
                            strike = checkStrike(i, j, k, String.valueOf(input[l][0]).toCharArray());
                            ball -= strike;
                            if (input[l][1] == strike && input[l][2] == ball) {
                                flag = true;
                            } else {
                                flag = false;
                                break;
                            }
                        }
                        if (flag) {
                            cnt++;
                        }
                    }
                }
            }
        }
        bw.write(String.valueOf(cnt));
        bw.flush();
        br.close();
        bw.close();
    }

    private static int checkStrike(int a, int b, int c, char[] charArray) {
        int cnt = 0;
        if (Character.getNumericValue(charArray[0]) == a) {
            cnt++;
        }
        if (Character.getNumericValue(charArray[1]) == b) {
            cnt++;
        }
        if (Character.getNumericValue(charArray[2]) == c) {
            cnt++;
        }
        return cnt;

    }

    private static int checkBall(int a, int b, int c, char[] charArray) {
        int cnt = 0;
        for (int i = 0; i < 3; i++) {
            if (Character.getNumericValue(charArray[i]) == a) {
                cnt++;
            } else if (Character.getNumericValue(charArray[i]) == b) {
                cnt++;
            } else if (Character.getNumericValue(charArray[i]) == c) {
                cnt++;
            }
        }
        return cnt;
    }

}
