import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_SWEA_1225_암호생성기_D3_신민아_107ms_15나누기전처리버전 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String line = "";
		StringBuilder sb = new StringBuilder();
		// (line = br.readLine())!=null
		// !(line=br.readLine()).isEmpty()
		while((line = br.readLine())!=null) {
			int testCase = Integer.parseInt(line);
			sb.append("#").append(testCase).append(" ");
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			Queue<Integer> numbers = new LinkedList<Integer>();
			int minElement = Integer.MAX_VALUE;
			
			// queue에 입력받은 숫자들 넣기
			for(int i=0;i<8;i++) {
				int element = Integer.parseInt(st.nextToken());
				minElement = Math.min(element, minElement);
				numbers.offer(element);
			}
			
			int dupValue = minElement/15 - 1;
			for(int i=0;i<8;i++) {
				numbers.offer(numbers.poll() - (15 * dupValue));
			}

			int minus = 1;
			while(true) {
				if(numbers.peek() <= minus) {
					numbers.poll();
					numbers.offer(0);
					break;
				}
				
				numbers.offer(numbers.poll() - minus);
				minus++;
				if(minus > 5)
					minus = 1;
			}
			
			for(int i=0;i<8;i++) {
				sb.append(numbers.poll()).append(" ");
			}
			
			sb.append("\n");
		}
		
		System.out.print(sb.toString());
	}

}
