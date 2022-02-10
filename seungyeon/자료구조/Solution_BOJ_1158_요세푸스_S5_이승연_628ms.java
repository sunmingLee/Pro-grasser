import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 요세푸스 문제는 다음과 같다.
 * 
 * 1번부터 N번까지 N명의 사람이 원을 이루면서 앉아있고, 양의 정수 K(≤ N)가 주어진다. 이제 순서대로 K번째 사람을 제거한다. 
 * 한 사람이 제거되면 남은 사람들로 이루어진 원을 따라 이 과정을 계속해 나간다. 이 과정은 N명의 사람이 모두 제거될 때까지 계속된다. 
 * 
 * 원에서 사람들이 제거되는 순서를 (N, K)-요세푸스 순열이라고 한다. 
 * 예를 들어 (7, 3)-요세푸스 순열은 <3, 6, 2, 7, 5, 1, 4>이다.
 * 
 * N과 K가 주어지면 (N, K)-요세푸스 순열을 구하는 프로그램을 작성하시오.
 * 
 * 첫째 줄에 N과 K가 빈 칸을 사이에 두고 순서대로 주어진다. (1 ≤ K ≤ N ≤ 5,000)
 */

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
			for(int i=0; i<K-1; i++) {  // K번째를 찾기 위해서 (K-1)개를 빼고 뒤에 다시 넣어줌. 
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
