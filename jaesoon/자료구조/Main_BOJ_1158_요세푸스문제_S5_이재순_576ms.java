import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_1158_요세푸스문제_S5_이재순_576ms {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken())-1; //K-1번 Out/In 후에 K번째 Out
		Queue<Integer> q = new LinkedList<Integer>();
		for (int i = 1; i < N+1; i++) {
			q.offer(i);
		}
		sb.append("<");
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < K; j++) {
				q.offer(q.poll());
			}
			sb.append(q.poll()).append(", ");
		}
		sb.setLength(sb.length()-2);
		System.out.println(sb.append(">"));
	}
}
