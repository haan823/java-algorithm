package barkingdog.baekjoon.array.p1919;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();
        int[] intArray = new int[26];
        int result = 0;
        for (char c : s1.toCharArray()) {
            intArray[c - 'a']++;
        }
        for (char c : s2.toCharArray()) {
            intArray[c - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (intArray[i] > 0) {
                result += intArray[i];
            } else if (intArray[i] < 0) {
                result -= intArray[i];
            }
        }
        System.out.println(result);
    }
}
