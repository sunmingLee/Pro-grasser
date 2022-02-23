import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_18352_특정거리의도시찾기_S2_이재순_640ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());//2 ≤ N ≤ 300,000
		int M = Integer.parseInt(st.nextToken());//1 ≤ M ≤ 1,000,000
		int K = Integer.parseInt(st.nextToken());//1 ≤ K ≤ 300,000
		int X = Integer.parseInt(st.nextToken());//1 ≤ X ≤ N
		Node[] nodes = new Node[N+1];//단방향 도로 정보가 담긴 나라의 배열
		//배열 초기화
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int temp = Integer.parseInt(st.nextToken());
			nodes[temp] = new Node(Integer.parseInt(st.nextToken()), nodes[temp]);
		}
		boolean[] visited = new boolean[N+1];//방문체크 배열
		Queue<Integer> q = new ArrayDeque<Integer>();
		q.add(X);//시작지점 추가
		visited[X]=true;//시작지점 방문체크
		int depth = 0;
		PriorityQueue<Integer> ans = new PriorityQueue<Integer>();//정답을 정렬하기위한 우선순위큐
		while (!q.isEmpty()) {//큐가 빌때까지 진행
			depth++;
			int qSize = q.size();
			if (depth == K) {//거리가 K가 될때 진행
				for (int j = 0; j < qSize; j++) {//depth거리를 다 탐색할때까지 진행
					int cur = q.poll();//현재 나라의 idx
					for (Node curNode = nodes[cur] ; curNode != null; curNode = curNode.next) {//더이상 연결된 곳이 없을때까지 진행
						if (!visited[curNode.idx]) {//방문한 적이 없는 나라라면 진행
							visited[curNode.idx]=true;//방문체크
							ans.offer(curNode.idx);//정답에 추가
						}
					}
				}
				break;
			}
			//거리가 K보다 작을 때 진행 구조는 위와 같음 큐가 출력을 위한 우선순위 큐인지 일반 큐인지만 다름
			for (int j = 0; j < qSize; j++) {
				int cur = q.poll();
				for (Node curNode = nodes[cur] ; curNode != null; curNode = curNode.next) {
					if (!visited[curNode.idx]) {
						visited[curNode.idx]=true;
						q.offer(curNode.idx);//이부분이 다름, 다음 탐색할 나라로 추가
					}
				}
				
			}
		}
		if (ans.isEmpty()) {//정답 큐가 비었다면 진행
			System.out.println(-1);
		}else {
			//출력
			StringBuilder sb = new StringBuilder();
			int size = ans.size();
			for (int i = 0; i < size; i++) {
				sb.append(ans.poll()).append("\n");
			}
			System.out.println(sb);
		}
	}
	static class Node {
		int idx;
		Node next;
		public Node(int idx, Node next) {
			this.idx = idx;
			this.next = next;
		}
	}
}
