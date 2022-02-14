package tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_BOJ_15903_카드합체놀이_S2_신민아_124ms {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int cardCount = Integer.parseInt(st.nextToken());
		int reverseCount = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine(), " ");
		PriorityQueue<Long> cards = new PriorityQueue<Long>();
		
		for(int i=0;i<cardCount;i++) {
			cards.offer(Long.parseLong(st.nextToken()));
		}
		
		for(int i=0;i<reverseCount;i++) {
			long reverseResult = cards.poll() + cards.poll();
			
			cards.offer(reverseResult);
			cards.offer(reverseResult);
		}
		
		long sum = 0;
		while(!cards.isEmpty()) {
			sum += cards.poll();
		}
		
		System.out.print(sum);

	}

}
