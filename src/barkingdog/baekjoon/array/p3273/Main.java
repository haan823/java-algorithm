package barkingdog.baekjoon.array.p3273;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] intArray = new int[2000001];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int nextInt = scanner.nextInt();
            list.add(nextInt);
            intArray[nextInt] = 1;
        }
        int x = scanner.nextInt();
        int count = 0;

        for (int i : list) {
            if (x - i > 0 && intArray[x - i] == 1) {
                count++;
            }
        }
        System.out.println(count/2);
    }
}
