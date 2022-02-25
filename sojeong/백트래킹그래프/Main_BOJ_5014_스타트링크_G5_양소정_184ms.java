package 백트래킹그래프;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 현재 위치에서 시작해서 위로 가는 것과 아래로 가는 것 두가지 분기로 나누어 넓혀 나가며 탐색하면 된다.
public class Main_BOJ_5014_스타트링크_G5_양소정_184ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int F = Integer.parseInt(st.nextToken()); // 총 층수
		int S = Integer.parseInt(st.nextToken()); // 현재 층
		int G = Integer.parseInt(st.nextToken()); // 목표 층
		int U = Integer.parseInt(st.nextToken()); // 위
		int D = Integer.parseInt(st.nextToken()); // 아래
		
		Queue<Integer> q = new LinkedList<Integer>();
		
		q.offer(S);
		
		boolean visit[] = new boolean[F + 1];
		visit[S] = true; 
		int cnt = 0; //눌러야하는 버튼 수
		
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int now = q.poll();
				if (now == G) {
					System.out.println(cnt);
					return;

				}
				int up = now + U;
				if (up <= F  && !visit[up]) {
					visit[up] = true;
					q.offer(up);
				}
				int down = now - D;
				if ( down > 0 && !visit[down]) {
					visit[down] = true;
					q.offer(down);
				}
			}
			cnt++;
		}

		System.out.println("use the stairs");

	}

}
