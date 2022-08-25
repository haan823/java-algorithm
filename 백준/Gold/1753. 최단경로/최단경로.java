import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static class Node implements Comparable<Node> {
		int distance;
		int index;

		public Node(int distance, int index) {
			super();
			this.distance = distance;
			this.index = index;
		}

		@Override
		public int compareTo(Node o) {
			return this.distance - o.distance;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(br.readLine()) - 1;
		List<Node>[] adj = new ArrayList[v];
		for (int i = 0; i < v; i++) {
			adj[i] = new ArrayList<>();
		}
		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken());
			adj[a].add(new Node(c, b));
		}
		int[] d = new int[v];
		Arrays.fill(d, Integer.MAX_VALUE);
		d[s] = 0;

		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(0, s));
		while (!pq.isEmpty()) {
			Node node = pq.poll();
			int cd = node.distance;
			int ci = node.index;
			if (d[ci] < cd) {
				continue;
			}
			for (int i = 0; i < adj[ci].size(); i++) {
				int cost = d[ci] + adj[ci].get(i).distance;
				if (cost < d[adj[ci].get(i).index]) {
					d[adj[ci].get(i).index] = cost;
					pq.add(new Node(cost, adj[ci].get(i).index));
				}
			}
		}
		for(int i=0; i<v; i++) {
			if(d[i] != Integer.MAX_VALUE) {
				bw.write(String.valueOf(d[i]));
				bw.newLine();
			} else {
				bw.write("INF");
				bw.newLine();
			}
		}
		bw.flush();
		br.close();
		bw.close();
	}
}