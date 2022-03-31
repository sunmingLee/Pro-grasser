package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_12851_숨바꼭질2_G5_이선민_136ms {

	private static int ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();

		// 0 ≤ 수빈이와 동생의 위치 ≤ 100,000
		int subin = Integer.parseInt(st.nextToken());
		int sister = Integer.parseInt(st.nextToken());

		// 둘의 위치가 같을 경우
		if(subin==sister) {
			sb.append(0).append("\n");
			sb.append(1).append("\n");
			System.out.print(sb.toString());
			return;
		}
		Queue<Integer> q = new ArrayDeque<Integer>();
		boolean[] visited = new boolean[100001];
		int[] timecnt = new int[100001]; // 해당 인덱스에 도착하는 최단 시간
		Arrays.fill(timecnt, Integer.MAX_VALUE);
		q.offer(subin);
		visited[subin] = true;
		timecnt[subin] = 0;
		int time = 1;
		while (!q.isEmpty()) {
			int size = q.size();
			while (size > 0) {
				int current = q.poll();
				if (current == sister) {
					sb.append(time-1).append("\n");
					sb.append(ans).append("\n");
					System.out.print(sb.toString());
					return;
				}

				// 한 칸 뒤로
				checknp(sister, current - 1, time, visited, timecnt, q);
				// 한 칸 앞으로
				checknp(sister, current + 1, time, visited, timecnt, q);
				// 순간이동
				checknp(sister, current * 2, time, visited, timecnt, q);

				size--;
			}

			time++;
		} // end of while
	} // end of main

	private static void checknp(int sister, int np, int currtime, boolean[] visited, int[] timecnt, Queue<Integer> q) {
		if (np >= 0 && np <= 100000 && (!visited[np] || timecnt[np] >= currtime)) {
			if (np == sister) {
				ans++;
			}
			visited[np] = true;
			timecnt[np] = currtime;
			q.offer(np);
		}
	} // end of checknp

} // end of class
