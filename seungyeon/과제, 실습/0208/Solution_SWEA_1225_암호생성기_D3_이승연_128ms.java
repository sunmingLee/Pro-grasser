import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_SWEA_1225_암호생성기_D3_이승연_128ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String input; 
		
		Queue<Integer> queue = new LinkedList<Integer>(); // 선입선출이므로 Queue 사용
		
		while((input = br.readLine()) != null) {
			int decrease = 1; // 감소되는 수 
			
			int testCase = Integer.parseInt(input);
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			for(int i=0; i<8; i++) {
				queue.offer(Integer.parseInt(st.nextToken())); // 큐에 8개의 숫자 저장 
			}
			
			while(true) {
				int top_int = queue.poll() - decrease; // 첫번째 숫자를 감소시킴. 
				if(top_int <= 0) { // 숫자가 감소할 때 0보다 작아지는 경우(원래 <여야 될 것 같은데,,,,)
					queue.offer(0); // 0으로 유지
					break; // 프로그램 종료 
				}
				queue.offer(top_int); // 감소시킨 숫자를 맨 뒤로 보냄 
				
				if(decrease == 5) { // 사이클 1~5 -> 5가 되면 다음은 1로
					decrease = 1;
				} else {
					decrease++;
				}
			}
					
			sb.append("#").append(testCase).append(" ");

			for(int i=0; i<8; i++) {
				sb.append(queue.poll()).append(" ");
			}
			
			sb.append("\n");
		}
		System.out.print(sb.toString());
		
	}
}
