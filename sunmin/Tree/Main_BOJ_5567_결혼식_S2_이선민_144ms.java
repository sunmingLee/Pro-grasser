package Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 상근이는 자신의 결혼식에 학교 동기 중 자신의 친구와 친구의 친구를 초대하기로 했다. 상근이의 동기는 모두 N명이고, 이 학생들의 학번은
 * 모두 1부터 N까지이다. 상근이의 학번은 1이다.
 * 
 * 상근이는 동기들의 친구 관계를 모두 조사한 리스트를 가지고 있다. 이 리스트를 바탕으로 결혼식에 초대할 사람의 수를 구하는 프로그램을
 * 작성하시오.
 */
public class Main_BOJ_5567_결혼식_S2_이선민_144ms {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine()); // 상근이의 동기의 수(2 ≤ n ≤ 500)
		int m = Integer.parseInt(br.readLine()); // 리스트의 길이(1 ≤ m ≤ 10000)

		ArrayList<Integer>[] list = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			list[i] = new ArrayList<Integer>();
		}

		int a, b;
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			// 연결된 두 정점을 잠시 담아둘 변수
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());

			if (a == 1 || b == 1) {
				list[1].add(a == 1 ? b : a); // 1이 아닌 숫자가 1의 자식노드 번호
				continue;
			}

			list[a].add(b);
			list[b].add(a);

		}

		int invite = 0; // 초대할 친구의 수
		int ffriend, friend;
		boolean[] visited = new boolean[n + 1]; // 해당 노드가 이미 출력한 노드인지 확인
		for (int i = 0; i < list[1].size(); i++) { // 상근이의 친구를 다 탐색할때까지
			friend = list[1].get(i); // 상근이의 친구
			if (!visited[friend]) {
				invite++;
				visited[friend] = true;
			}

			for (int j = 0; j < list[friend].size(); j++) {
				ffriend = list[friend].get(j); // 친구의 친구
				if (visited[ffriend]) {
					continue;
				}

				invite++;
				visited[ffriend] = true;
			}

		}

		System.out.println(invite);
	} // end of main

} // end of class
