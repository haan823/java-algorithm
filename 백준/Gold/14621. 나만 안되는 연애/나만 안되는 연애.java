import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static int n;
	public static int m;
	public static char[] school;
	public static int[] par;
	public static int result;
	public static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		school = new char[n + 1];
		par = new int[n + 1];
		visited = new boolean[n + 1];
		for (int i = 0; i < n + 1; i++) {
			par[i] = i;
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			school[i] = st.nextToken().charAt(0);
		}
		List<int[]> list = new ArrayList<>();
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			list.add(new int[] { a, b, c });
		}
		Collections.sort(list, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2];
			}
		});
		for (int i = 0; i < list.size(); i++) {
			int a = list.get(i)[0];
			int b = list.get(i)[1];
			int c = list.get(i)[2];
			if (school[a] == school[b]) {
				continue;
			}
			if (find(a) == find(b)) {
				continue;
			}
			visited[a] = true;
			visited[b] = true;
			union(a, b);
			result += c;
		}
		boolean flag = true;
		for (int i = 1; i <= n; i++) {
			if (!visited[i]) {
				flag = false;
				break;
			}
		}
		if (flag) {
			bw.write(String.valueOf(result));
		} else {
			bw.write("-1");
		}
		bw.flush();
		br.close();
		bw.close();
	}

	private static int find(int x) {
		if (par[x] == x) {
			return x;
		} else {
			return par[x] = find(par[x]);
		}
	}

	private static void union(int x, int y) {
		x = find(x);
		y = find(y);
		par[x] = y;
	}
}
