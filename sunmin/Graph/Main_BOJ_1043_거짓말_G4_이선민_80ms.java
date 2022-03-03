package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_BOJ_1043_거짓말_G4_이선민_80ms {

	static int[] parents;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); // 사람의 수
		int M = Integer.parseInt(st.nextToken()); // 파티의 수

		// 단위 집합 생성
		parents = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			parents[i] = i;
		}

		st = new StringTokenizer(br.readLine(), " ");
		int truth = Integer.parseInt(st.nextToken()); // 진실을 아는 사람의 수
		boolean[] knowTruth = new boolean[N + 1]; // 해당 인덱스의 사람이 진실을 안다면 true
		Stack<Integer> stack = new Stack<Integer>(); // 사람들을 잠시 담아둘 스택
		for (int i = 0; i < truth; i++) {
			int person = Integer.parseInt(st.nextToken());
			knowTruth[person] = true;
			stack.push(person);
		}

		// 진실을 아는 사람이 2명 이상이면 union해줌
		if (truth > 1) {
			for (int i = 0; i < stack.size() - 1; i++) {
				int personA = stack.get(i);
				int personB = stack.get(i + 1);
				union(personA, personB);
			}
		}
		stack.clear();

		List[] party = new ArrayList[M]; // 파티 정보를 담을 리스트
		for (int i = 0; i < M; i++) {
			party[i] = new ArrayList<Integer>();

			st = new StringTokenizer(br.readLine(), " ");
			int num = Integer.parseInt(st.nextToken()); // 파티에 오는 사람의 수
			for (int j = 0; j < num; j++) {
				int person = Integer.parseInt(st.nextToken()); // 파티에 참석한 사람의 번호
				stack.push(person);
				party[i].add(person); // 해당 파티에 온 사람들을 party 리스트에 담아줌
			}

			// 같은 파티에 오는 사람들 union
			if(num>1) {
				for (int j = 0; j < stack.size() - 1; j++) {
					int personA = stack.get(j);
					int personB = stack.get(j + 1);
					union(personA, personB);
				}
			}
			stack.clear(); // 다음 파티를 위해 초기화
		} // 파티 전체 탐색 완료

		boolean[] visited = new boolean[N + 1]; // 이미 탐색한 사람이면 true
		// 진실을 아는 사람과 같은 집합이면 진실을 알게됨
		for (int i = 1; i <= N; i++) {
			if (knowTruth[i] && !visited[i]) {
				int root = findSet(i); // 진실을 알고있는 사람이 속한 집합의 대표자
				for (int j = 1; j <= N; j++) {
					if (findSet(j) == root) { // 같은 집합에 속한 사람들이라면
						knowTruth[j] = true;
						visited[j] = true;
					}
				}
			}
		}

		int ans = M; // 과장된 이야기를 할 수 있는 파티 개수
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < party[i].size(); j++) { // 파티를 순서대로 돌면서 진실을 아는 사람이 속해있다면 답을 1 줄이고 다음 파티로 넘어감
				int person = (int) party[i].get(j);
				if (knowTruth[person]) {
					ans--;
					break;
				}
			}
		}

		System.out.print(ans);

	} // end of main

	/**
	 * a, b 두 집합 합치기
	 */
	private static void union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if (aRoot == bRoot) { // 두 집합의 대표자가 같다면 이미 같은 집합에 속해있음
			return;
		}

		parents[bRoot] = aRoot;
	} // end of union

	/**
	 * a의 대표자 찾기
	 */
	private static int findSet(int a) {
		if (parents[a] == a) { // 내가 나의 부모인 경우
			return a;
		}
		return parents[a] = findSet(parents[a]); // path compression
	} // end of findSet

} // end of class
