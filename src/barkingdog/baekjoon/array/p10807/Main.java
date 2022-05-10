package barkingdog.baekjoon.array.p10807;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(scanner.nextInt());
        }
        int v = scanner.nextInt();
        long count = list.stream().filter(i -> i.equals(v)).count();
        System.out.println(count);
    }
}
