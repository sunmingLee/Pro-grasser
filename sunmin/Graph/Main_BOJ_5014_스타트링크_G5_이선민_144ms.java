package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 스타트링크는 총 F층으로 이루어진 고층 건물에 사무실이 있고, 스타트링크가 있는 곳의 위치는 G층이다. 강호가 지금 있는 곳은 S층이고,
 * 이제 엘리베이터를 타고 G층으로 이동하려고 한다.
 * 
 * 보통 엘리베이터에는 어떤 층으로 이동할 수 있는 버튼이 있지만, 강호가 탄 엘리베이터는 버튼이 2개밖에 없다. U버튼은 위로 U층을 가는
 * 버튼, D버튼은 아래로 D층을 가는 버튼이다. (만약, U층 위, 또는 D층 아래에 해당하는 층이 없을 때는, 엘리베이터는 움직이지
 * 않는다)
 * 
 * 강호가 G층에 도착하려면, 버튼을 적어도 몇 번 눌러야 하는지 구하는 프로그램을 작성하시오. 만약, 엘리베이터를 이용해서 G층에 갈 수
 * 없다면, "use the stairs"를 출력한다. (1 ≤ S, G ≤ F ≤ 1000000, 0 ≤ U, D ≤ 1000000)
 *
 */
public class Main_BOJ_5014_스타트링크_G5_이선민_144ms {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int F = Integer.parseInt(st.nextToken()); // 건물의 높이
		int S = Integer.parseInt(st.nextToken()); // 현재 층
		int G = Integer.parseInt(st.nextToken()); // 가야하는 층
		int U = Integer.parseInt(st.nextToken()); // 한번에 올라가는 층 수
		int D = Integer.parseInt(st.nextToken()); // 한번에 내려가는 층 수

		if ((S > G && D == 0) || (S < G && U == 0)) { // 가야하는 층이 현재 층보다 낮은데 D=0이거나, 가야하는 층이 현재 층보다 높은데 U=0인 경우
			System.out.print("use the stairs");
			return;
		}

//		dfs(F, G, U, D, S, 0); // 현재 층부터 탐색 시작
		int answer = bfs(F, G, U, D, S); // 눌러야 하는 버튼의 수의 최솟값
		if (answer == -1) {
			System.out.print("use the stairs");
		} else {
			System.out.print(answer);
		}

	} // end of main

	private static int bfs(int F, int G, int U, int D, int start) {
		Queue<Integer> queue = new ArrayDeque<Integer>();
		int[] visit = new int[F + 1]; // 방문 깊이를 저장할 배열
		queue.offer(start);
		visit[start] = 1; // 시작점도 방문한것이므로 0으로 두면 안됨

		int current; // 현재 층수
		while (!queue.isEmpty()) {
			current = queue.poll();
			if (current == G) { // 해당 층에 도착했다면
				return visit[current] - 1; // 시작층에서 +1이 되었기때문에 1을 빼줌
			}

			int up = current + U; // 올라갈 높이
			int down = current - D; // 내려갈 높이
			if (up <= F && visit[up] == 0) { // 올라갈 층을 방문한 적이 없고 건물의 최고층수보다 낮다면
				queue.offer(up); // 위로 올라가기
				visit[up] = visit[current] + 1;
			}

			if (down > 0 && visit[down] == 0) { // 내려갈 층을 방문한 적이 없고 1층 이상이라면
				queue.offer(down); // 아래로 내려가기
				visit[down] = visit[current] + 1;
			}

		}

		return -1;

	} // end of bfs

	// 시간초과
//	private static void dfs(int F, int G, int U, int D, int temp, int cnt) {
//		if (temp > F || temp < 0 || cnt > ans) { // 건물의 층수를 벗어났거나 현재까지의 버튼누른 횟수가 최소횟수를 넘어간다면,
//			return;
//		}
//
//		if (temp == G) { // 가야하는 층에 도착
//			ans = cnt;
//			return;
//		}
//
//		dfs(F, G, U, D, temp + U, cnt + 1); // 위로 올라가기
//		dfs(F, G, U, D, temp - D, cnt + 1); // 아래로 내려가기
//	} // end of dfs

} // end of class
