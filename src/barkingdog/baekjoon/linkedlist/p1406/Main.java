package barkingdog.baekjoon.linkedlist.p1406;

import java.io.*;
import java.util.LinkedList;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String string = br.readLine();
        int M = Integer.parseInt(br.readLine());
        LinkedList<Character> linkedList = new LinkedList<>();
        for (char c : string.toCharArray()) {
            linkedList.add(c);
        }
        ListIterator<Character> iterator = linkedList.listIterator();
        while (iterator.hasNext()) {
            iterator.next();
        }
        for (int i = 0; i < M; i++) {
            String[] commands = br.readLine().split(" ");
            char command = commands[0].charAt(0);
            switch (command) {
                case 'L':
                    if (iterator.hasPrevious()) {
                        iterator.previous();
                    }
                    break;
                case 'D':
                    if (iterator.hasNext()) {
                        iterator.next();
                    }
                    break;
                case 'B':
                    if (iterator.hasPrevious()) {
                        iterator.previous();
                        iterator.remove();
                    }
                    break;
                case 'P':
                    char c = commands[1].charAt(0);
                    iterator.add(c);
                    break;
            }
        }
        for (Character character : linkedList) {
            bw.write(character);
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
