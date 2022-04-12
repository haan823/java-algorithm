package baekjoon.array.p10808;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int[] answer = new int[26];
        int length = input.length();
        for (int i = 0; i < length; i++) {
            answer[input.charAt(i) - 'a'] += 1;
        }
        System.out.println(Arrays.stream(answer).boxed().map(i -> i.toString()).collect(Collectors.joining(" ")));
    }
}
