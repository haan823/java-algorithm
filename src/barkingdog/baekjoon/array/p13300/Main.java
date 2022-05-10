package barkingdog.baekjoon.array.p13300;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        int result = 0;
        int[][] intArray = new int[6][2];
        for (int i = 0; i < N; i++) {
            int s = scanner.nextInt();
            int y = scanner.nextInt();
            intArray[y-1][s] += 1;
        }
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 2; j++) {
                if (intArray[i][j] == 0) {
                    continue;
                }
                if (intArray[i][j] % K == 0) {
                    result += (intArray[i][j] / K);
                } else {
                    result += (intArray[i][j] / K) + 1;
                }
            }
        }
        System.out.println(result);
    }
}
