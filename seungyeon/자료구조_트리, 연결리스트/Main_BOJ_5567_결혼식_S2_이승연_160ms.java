import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_5567_결혼식_S2_이승연_140ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 상근이의 동기의 수 
		int M = Integer.parseInt(br.readLine()); // 리스트의 길이 
		
		ArrayList<Integer>[] list = new ArrayList[N+1]; // 인접 리스트 
		
		StringTokenizer st;
				
		for(int i=0; i<=N; i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a1 = Integer.parseInt(st.nextToken());
			int b1 = Integer.parseInt(st.nextToken());
			list[a1].add(b1); // 양방향 (a1의 친구 b1)
			list[b1].add(a1); // 양방향 (b1의 친구 a1)
		}

		boolean[] invite = new boolean[N+1]; // 초대할 친구 리스트 -> 인덱스가 학번 
		
		Queue<Integer> queue = new LinkedList<Integer>(); // bfs
		
		queue.offer(1);
		
		for(int i=0; i<2; i++) { // depth 2번까지 
			int size = queue.size(); // 해당 depth에 있는 노드 수 
			
			for(int j=0; j<size; j++) {
				int e = queue.poll(); // 하나씩 빼서 
				
				for(int k=0; k<list[e].size(); k++) { // 자기 자식의 노드들을 넣어줌 
					queue.offer(list[e].get(k));
					invite[list[e].get(k)] = true; // 초대할 친구 체크 
				}
			}
		}
		
		int result = 0;
		
		for(int i=2; i<invite.length; i++) { // 주의: 2부터 시작해야 됨. 1은 자기 자신 
			if(invite[i]) {
				result++;
			}
		}
		
		System.out.println(result);
	}
}
