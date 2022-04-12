package baekjoon.array.p11328;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());
        String[] inputStrings = new String[N];
        for (int i = 0; i < N; i++) {
            inputStrings[i] = scanner.nextLine();
        }
        for (int i = 0; i < N; i++) {
            String[] strings = inputStrings[i].split(" ");
            int[] intArray = new int[26];
            for (char c : strings[0].toCharArray()) {
                intArray[c - 'a']++;
            }
            for (char c : strings[1].toCharArray()) {
                intArray[c - 'a']--;
            }
            boolean isImpossible = false;
            for (int j = 0; j < 26; j++) {
                if (intArray[j] != 0) {
                    System.out.println("Impossible");
                    isImpossible = true;
                    break;
                }
            }
            if (!isImpossible) {
                System.out.println(("Possible"));
            }
        }
    }
}
