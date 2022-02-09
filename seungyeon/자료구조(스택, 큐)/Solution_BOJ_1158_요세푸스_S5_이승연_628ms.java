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
			for(int i=0; i<K-1; i++) {
				int top = queue.poll();
				queue.offer(top);
			}
			sb.append(queue.poll()).append(", ");
		}
		
		
		sb.setLength(sb.length()-2);
		sb.append(">");
		
		System.out.println(sb.toString());
	}
}
