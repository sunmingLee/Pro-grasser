package Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 루트 없는 트리가 주어진다. 이때, 트리의 루트를 1이라고 정했을 때, 각 노드의 부모를 구하는 프로그램을 작성하시오.
 */
public class Main_BOJ_11725_트리의부모찾기_S2_이선민_ms {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine()); // 노드의 개수(2 ≤ N ≤ 100,000)

		int[] tree = new int[N + 1]; // 부모 노드 번호를 담을 배열(크기를 N+1로 정해 인덱스번호를 노드번호로 사용)
		ArrayList<Integer>[] list = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<Integer>();
		}

		int a, b;
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			// 연결된 두 정점을 잠시 담아둘 변수
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());

			// 루트와 연결된 정점은 배열에 1을 담지 않음
			if (a == 1 || b == 1) {
				list[1].add(a == 1 ? b : a); // 1이 아닌 숫자가 1의 자식노드 번호
				continue;
			}

			list[a].add(b);
			list[b].add(a);

		}

		int cnt = 0; // 모든 노드의 부모를 다 찾았는지를 카운트
		tree[1] = 1; // 배열에 0이 아닌 값이 있다면 부모노드를 찾은것으로 간주하려고 루트노드에 0이 아닌 다른수를 넣어줌
		for (int i = 1; cnt < N - 1; i++) {
			for (int j = 0; j < list[i].size(); j++) {
				a = list[i].get(j); // 부모노드를 확인할 노드
				if (tree[a] != 0) { // 해당 노드의 부모 노드가 밝혀졌다면
					if (tree[i] != 0) { // 인덱스의 부모도 이미 밝혀졌다면 두 노드 모두 값을 변경시켜주면 안됨
						continue;
					}
					tree[i] = a; // 현재 인덱스의 부모가 a가 됨
				} else { // 부모 노드가 없다면 현재 인덱스가 부모가 됨
					tree[a] = i;
				}
				cnt++;
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 2; i <= N; i++) {
			sb.append(tree[i]).append("\n");
		}
		System.out.print(sb);
	} // end of main

} // end of class
