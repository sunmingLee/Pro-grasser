import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_18352_특정거리의도시찾기_S2_이재순_1280ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());//2 ≤ N ≤ 300,000
		int M = Integer.parseInt(st.nextToken());//1 ≤ M ≤ 1,000,000
		int K = Integer.parseInt(st.nextToken());//1 ≤ K ≤ 300,000
		int X = Integer.parseInt(st.nextToken());//1 ≤ X ≤ N
		ArrayList<Integer>[] road = new ArrayList[N+1]; //
		for (int i = 1; i <= N; i++) {
			road[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			road[Integer.parseInt(st.nextToken())].add(Integer.parseInt(st.nextToken()));
		}
		
		boolean[] visited = new boolean[N+1];
		Queue<Integer> q = new ArrayDeque<Integer>();
		q.add(X);
		visited[X]=true;
		int depth = 0;
		PriorityQueue<Integer> ans = new PriorityQueue<Integer>();
		while (!q.isEmpty()) {
			depth++;
			if (depth == K) {
				int qSize = q.size();
				for (int j = 0; j < qSize; j++) {
					int cur = q.poll();
					int arraysize = road[cur].size();
					for (int i = 0; i < arraysize; i++) {
						int temp = road[cur].get(i);
						if (!visited[temp]) {
							visited[temp]=true;
							ans.offer(temp);
						}
					}
					
				}
				break;
			}
			int qSize = q.size();
			for (int j = 0; j < qSize; j++) {
				int cur = q.poll();
				int arraysize = road[cur].size();
				for (int i = 0; i < arraysize; i++) {
					int temp = road[cur].get(i);
					if (!visited[temp]) {
						visited[temp]=true;
						q.offer(temp);
					}
				}
				
			}
		}
		if (ans.isEmpty()) {
			System.out.println(-1);
		}else {
			StringBuilder sb = new StringBuilder();
			int size = ans.size();
			for (int i = 0; i < size; i++) {
				sb.append(ans.poll()).append("\n");
			}
			System.out.println(sb);
		}
	}
}
