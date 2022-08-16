import java.io.*;

public class Main {

	public static int n;
	public static int result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		n = Integer.parseInt(br.readLine());
		while (n > 0) {
			if (n % 5 == 0) {
				result += n / 5;
				n %= 5;
				break;
			}
			n -= 3;
			result++;
		}
		if (n == 0) {
			bw.write(String.valueOf(result));
		} else {
			bw.write("-1");
		}
		bw.flush();
		br.close();
		bw.close();
	}
}
