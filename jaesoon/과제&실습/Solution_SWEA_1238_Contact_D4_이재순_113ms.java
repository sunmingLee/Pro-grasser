import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_SWEA_1238_Contact_D4_이재순_113ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int testcase = 0;//테스트케이스
		String line;
		while (!(line = br.readLine()).isEmpty()) {//다음 케이스가 있다면 진행
			st = new StringTokenizer(line);
			testcase++;//테스트케이스 번호 갱신
			int N = Integer.parseInt(st.nextToken())/2;//입력받는 from-to갯수
			int start = Integer.parseInt(st.nextToken());//연락을 시작하는 노드 idx
			Node[] nodes = new Node[101];//최대 100명
			boolean[] visited = new boolean[101];//노드 방문을 체크하는 배열
			st = new StringTokenizer(br.readLine());
			//노드 연결
			for (int i = 0; i < N; i++) {
				int from = Integer.parseInt(st.nextToken());
				nodes[from] = new Node(Integer.parseInt(st.nextToken()), nodes[from]);
			}
		
			Queue<Integer> q = new LinkedList<Integer>();//bfs를 진행하기 위해 탐색해야되는 노드를 저장하는 큐
			q.offer(start);//시작 노드 추가
			visited[start] = true;//시작 노드 방문 체크
			int ans=0;//정답
			//프로세스 진행
			while (!q.isEmpty()) {
				int qSize = q.size();//q사이즈만큼 반복하면 한 depth진행
				int tempans=0;//해당 depth에서의 최대 vertex를 저장
				for (int i = 0; i < qSize; i++) {
					int cur = q.poll();
					for (Node temp = nodes[cur]; temp != null;temp = temp.link) {//해당 노드에 연결된 노드가 있을때까지 진행
						if (!visited[temp.vertex]) {//방문하지 않은 노드라면 진행
							q.offer(temp.vertex);//탐색해야할 노드의 idx로 추가
							visited[temp.vertex] = true;//방문 갱신
							if (tempans<temp.vertex) {
								tempans=temp.vertex;
								ans=temp.vertex;//정답 갱신
							}
						}
					}
				}
				
			}
			sb.append("#").append(testcase).append(" ").append(ans).append("\n");//출력형식에 맞게 append
		}
		System.out.println(sb);//출력
	}

	static class Node {
		int vertex;
		Node link;

		public Node(int vertex, Node link) {
			this.vertex = vertex;
			this.link = link;
		}
	}
}
