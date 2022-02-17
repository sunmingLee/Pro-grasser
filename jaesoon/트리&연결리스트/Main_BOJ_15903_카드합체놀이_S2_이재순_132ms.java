import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_BOJ_15903_카드합체놀이_S2_이재순_132ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());//카드의 갯수 입력, 2 ≤ n ≤ 1,000
		int m = Integer.parseInt(st.nextToken());//카드 합체 수 입력, 0 ≤ m ≤ 15×n
		st = new StringTokenizer(br.readLine());
		PriorityQueue<Long> pq = new PriorityQueue<Long>();//카드를 저장할 pq생성
		
		//카드 초기화
		for (int i = 0; i < n; i++) {//카드의 갯수 만큼 반복
			pq.offer(Long.parseLong(st.nextToken()));
		}
		
		//프로세스 진행
		for (int i = 0; i < m; i++) {//카드 합체 수만큼 반복
			Long temp = pq.poll()+pq.poll();//가장 작은 두수를 제거하고 합체
			pq.offer(temp);//합체한 수 추가
			pq.offer(temp);//합체한 수 추가
		}
		
		//출력
		long ans=0;//카드를 누적합을 저장할 변수
		for (Long a : pq) {
			ans+=a;//pq 원소 누적합
		}
		System.out.println(ans);//답 출력
	}//end of main
}//end of class
