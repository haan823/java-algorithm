package barkingdog.baekjoon.linkedlist.p5397;

import java.io.*;
import java.util.LinkedList;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String[] strings = new String[n];
        for (int i = 0; i < n; i++) {
            strings[i] = br.readLine();
        }
        for (int i = 0; i < n; i++) {
            String input = strings[i];
            LinkedList<Character> linkedList = new LinkedList<>();
            ListIterator<Character> listIterator = linkedList.listIterator();
            for (char c : input.toCharArray()) {
                switch (c) {
                    case '<':
                        if (listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        break;
                    case '>':
                        if (listIterator.hasNext()) {
                            listIterator.next();
                        }
                        break;
                    case '-':
                        if (listIterator.hasPrevious()) {
                            listIterator.previous();
                            listIterator.remove();
                        }
                        break;
                    default:
                        listIterator.add(c);
                        break;
                }
            }
            for (Character character : linkedList) {
                bw.write(character);
            }
            bw.newLine();
            bw.flush();
        }
        br.close();
        bw.close();
    }
}
