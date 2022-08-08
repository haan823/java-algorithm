import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        LinkedList<String> linkedList = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            String s = String.valueOf(i);
            linkedList.add(s);
        }
        StringJoiner stringJoiner = new StringJoiner(", ", "<", ">");
        while (!linkedList.isEmpty()) {
            for (int i = 0; i < k - 1; i++) {
                String removedString = linkedList.remove(0);
                linkedList.add(removedString);
            }
            String removedString = linkedList.remove(0);
            stringJoiner.add(removedString);
        }
        bw.write(stringJoiner.toString());
        br.close();
        bw.flush();
        bw.close();
    }
}