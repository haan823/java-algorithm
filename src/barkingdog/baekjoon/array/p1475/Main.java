package barkingdog.baekjoon.array.p1475;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String s = ((Integer) new Scanner(System.in).nextInt()).toString();
        int length = s.length();
        int minVal = Integer.MIN_VALUE;
        int[] numbers = new int[10];
        for (int i = 0; i < length; i++) {
            numbers[s.charAt(i) - '0'] += 1;
        }
        for (int i = 0; i < 10; i++) {
            if (i != 6 && i != 9) {
                if (numbers[i] > minVal) {
                    minVal = numbers[i];
                }
            }
        }
        int tmp = ((numbers[6] + numbers[9] + 1) / 2);
        if (tmp > minVal) {
            minVal = tmp;
        }
        System.out.println(minVal);
    }
}
