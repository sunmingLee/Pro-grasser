import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args) throws Exception {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Queue<Integer> queue = new LinkedList<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int cnt=1;
		for (int i = 1; i <= N; i++) {
			queue.offer(i);	
		}
		sb.append('<');
		
		while(queue.size()>1) {
            
			for(int i = 1; i <M; i++) {
				queue.offer(queue.poll());
			}
			
			sb.append(queue.poll()).append(", ");
		}
		
		sb.append(queue.poll()).append('>');
		System.out.println(sb);
		
		
	}//end of main

}


/** 위 코드에 while 문 하위를 이렇게 작성하면 시간초과 뜨는데 이유를 모르겠네요..이유가 멀까요?
   
 		while(queue.size()>1) {
			if(cnt==M) {
				sb.append(queue.poll()).append(", ");
				cnt=1;
			}
			queue.offer(queue.poll());
			cnt++;

		}
		
		sb.append(queue.poll()).append('>');
		System.out.println(sb);
		
		
	}//end of main

}
*/
