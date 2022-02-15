package Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
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
		Queue<Integer> input = new LinkedList<Integer>(); // 1의 자식노드들을 찾기 전까지 입력값을 담아놓을 배열
		int a, b, index;
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			// 연결된 두 정점을 잠시 담아둘 변수
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());

			if (a == 1 || b == 1) {
				index = a == 1 ? b : a; // 1이 아닌 숫자가 1의 자식노드 번호
				tree[index] = 1;
				continue;
			}

			// 어떤 정점이 부모노드인지 모르기때문에 우선 다 스택에 넣어둠
			input.offer(a);
			input.offer(b);

		} // end of for

		while (!input.isEmpty()) {
			a = input.poll();
			b = input.poll();

			if (tree[a] != 0) { // 해당 인덱스의 값이 0이 아니라면 이미 언급된 노드이므로 해당 노드가 부모노드가 됨
				tree[b] = a;
			} else if (tree[b] != 0) {
				tree[a] = b;
			} else {	// 두 노드 모두 아직 부모노드를 찾지 못했다면 큐에 다시 넣음
				input.offer(a);
				input.offer(b);
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 2; i <= N; i++) {
			sb.append(tree[i]).append("\n");
		}
		System.out.print(sb);
	} // end of main

} // end of class
