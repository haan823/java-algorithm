package baekjoon.p1244;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int[] array = new int[n + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		int m = Integer.parseInt(br.readLine());
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(st.nextToken());
			int index = Integer.parseInt(st.nextToken());
			if (gender == 1) {
				for (int j = 1; j <= n; j++) {
					if (j % index == 0) {
						array[j] = (array[j] + 1) % 2;
					}
				}
			} else {
				int gap = 0;
				for (int j = 0; j < n; j++) {
					if (index - j >= 1 && index + j <= n && array[index - j] == array[index + j]) {
						gap = j;
					} else {
						break;
					}
				}
				for (int j = index - gap; j <= index + gap; j++) {
					array[j] = (array[j] + 1) % 2;
				}
			}
		}
		for (int i = 1; i <= n; i++) {
			bw.write(String.valueOf(array[i] + " "));
			if (i % 20 == 0) {
				bw.newLine();
			}
		}
		bw.flush();

	}
}