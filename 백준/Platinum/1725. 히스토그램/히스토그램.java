import java.io.*;
import java.util.Stack;

public class Main {

    public static int n;
    public static int[] array;
    public static int maxVal;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        array = new int[n + 2];
        for (int i = 1; i <= n; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }
        Stack<Integer> stack = new Stack<>();
        stack.add(0);
        for (int i = 1; i <= n + 1; i++) {
            while (!stack.isEmpty() && array[stack.peek()] > array[i]) {
                int tmp = stack.peek();
                stack.pop();
                maxVal = Math.max(maxVal, (i - stack.peek() - 1) * array[tmp]);
            }
            stack.push(i);
        }
        bw.write(String.valueOf(maxVal));
        bw.flush();
        br.close();
        bw.close();
    }
}