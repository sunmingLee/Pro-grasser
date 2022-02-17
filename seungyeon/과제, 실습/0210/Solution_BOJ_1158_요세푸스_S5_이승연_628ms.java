import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Solution_BOJ_1158_요세푸스_S5_이승연_628ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		Queue<Integer> queue = new LinkedList<Integer>();
		sb.append("<");

		for(int n=1; n<=N; n++) {
			queue.offer(n);
		}
		
		while(!queue.isEmpty()) {
			for(int i=1; i<K; i++) {  // K번째를 찾기 위해서 (K-1)개를 빼고 뒤에 다시 넣어줌. 
				int top = queue.poll();
				queue.offer(top);
			}
			sb.append(queue.poll()).append(", "); // K번째건 빼서 출력. 
		}
		
		
		sb.setLength(sb.length()-2); // 마지막에 들어간 ", "를 빼줌. 
		sb.append(">");
		
		System.out.println(sb.toString());
	}
}
