package barkingdog.baekjoon.array.p2577;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Long result = scanner.nextLong() * scanner.nextLong() * scanner.nextLong();
        String s = result.toString();
        int[] intArray = new int[10];
        int length = s.length();
        for (int i = 0; i < length; i++) {
            intArray[s.charAt(i) - '0'] += 1;
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(intArray[i]);
        }
    }
}
