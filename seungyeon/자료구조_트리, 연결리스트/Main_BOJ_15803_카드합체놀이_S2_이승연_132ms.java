import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_BOJ_15803_카드합체놀이_S2_이승연_132ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken()); // 카드의 개수 (2<=N<=1000)
		int M = Integer.parseInt(st.nextToken()); // 카드 합체 횟수 (0<=M<=15*N)
		
		PriorityQueue<Long> pQueue = new PriorityQueue<Long>();
		st = new StringTokenizer(br.readLine(), " ");
		
		for(int i=0; i<N; i++) { // 카드 우선순위 큐에 넣음 
			pQueue.offer(Long.parseLong(st.nextToken()));
		}

		for(int i=0; i<M; i++) { // 카드 합체 횟수만큼 앞에서부터 작은 수 두 개 뺴서 더하고 더한 수 두 번 넣는 작업 
			long temp = pQueue.poll()+pQueue.poll();
			
			pQueue.offer(temp);
			pQueue.offer(temp);
		}
		
		long card_sum = 0;
		
		for(long l: pQueue) { // 큐에 들어있는 모든 수 더해서 
			card_sum += l; 
		}
		
		System.out.println(card_sum); // 출력 
	}
}
