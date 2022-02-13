
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
	1. x번 카드와 y번 카드를 골라 그 두 장에 쓰여진 수를 더한 값을 계산한다. (x ≠ y)
	2. 계산한 값을 x번 카드와 y번 카드 두 장 모두에 덮어 쓴다.
	
	이 카드 합체를 총 m번 하면 놀이가 끝난다.
	m번의 합체를 모두 끝낸 뒤, n장의 카드에 쓰여있는 수를 모두 더한 값이 이 놀이의 점수가 된다.
	이 점수를 가장 작게 만드는 것이 놀이의 목표이다.
*/
public class Main_BOJ_15903_카드합체놀이_S2_양소정_136ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st ;
		st= new StringTokenizer(br.readLine());
		long ans =0; //최소값
		long N = Integer.parseInt(st.nextToken()); //카드의 개수 (2 ≤ n ≤ 1,000)
		long M = Integer.parseInt(st.nextToken()); //카드 합체 횟수  (0 ≤ m ≤ 15×n)
		PriorityQueue<Long> pq = new PriorityQueue<Long>();
		
		//카드 삽입
		st = new StringTokenizer(br.readLine()," ");
		for (int i = 0; i < N; i++) {
			pq.add(Long.parseLong(st.nextToken()));
		}
		
		for (int i = 0; i < M; i++) {
			long sum = pq.poll();  
			sum += pq.poll();
			pq.add(sum);
			pq.add(sum);
		}
		while(!pq.isEmpty()) {
			ans += pq.poll();
		}
		System.out.println(ans);
	}
}
