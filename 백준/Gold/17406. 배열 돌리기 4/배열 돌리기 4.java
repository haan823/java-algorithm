import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static int n, m, k;
	public static int[][] array;
	public static int[][] clone;
	public static List<int[]> command = new ArrayList<>();
	public static int[] order;
	public static boolean[] visited;
	public static int minVal = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		array = new int[n][m];
		clone = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
				clone[i][j] = array[i][j];
			}
		}
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			int s = Integer.parseInt(st.nextToken());
			command.add(new int[] { r, c, s });
		}
		order = new int[command.size()];
		visited = new boolean[command.size()];
		recur(0);
		bw.write(String.valueOf(minVal));
		bw.flush();
		br.close();
		bw.close();
	}

	private static void recur(int cur) {
		if (cur == command.size()) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					array[i][j] = clone[i][j];
				}
			}
			for (int i = 0; i < command.size(); i++) {
				int r = command.get(order[i])[0];
				int c = command.get(order[i])[1];
				int s = command.get(order[i])[2];
				rotate(r - s, c - s, r + s, c + s);
			}
			for (int i = 0; i < n; i++) {
				int sum = 0;
				for (int j = 0; j < m; j++) {
					sum += array[i][j];
				}
				minVal = Math.min(minVal	, sum);
			}
			return;
		}
		for (int i = 0; i < command.size(); i++) {
			if (!visited[i]) {
				order[cur] = i;
				visited[i] = true;
				recur(cur + 1);
				visited[i] = false;
			}
		}
	}

	public static void rotate(int sx, int sy, int ex, int ey) {
		while (sx < ex && sy < ey) {
			int tmp = array[sx][sy];
			for (int i = sx + 1; i <= ex; i++) {
				array[i - 1][sy] = array[i][sy];
			}
			for (int j = sy + 1; j <= ey; j++) {
				array[ex][j - 1] = array[ex][j];
			}
			for (int i = ex - 1; i >= sx; i--) {
				array[i + 1][ey] = array[i][ey];
			}
			for (int j = ey - 1; j >= sy; j--) {
				array[sx][j + 1] = array[sx][j];
			}
			array[sx][sy + 1] = tmp;
			sx++;
			sy++;
			ex--;
			ey--;
		}
	}
}
