import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/**1번부터 N번까지 N명의 사람이 원을 이루면서 앉아있고, 양의 정수 K(≤ N)가 주어진다.
 이제 순서대로 K번째 사람을 제거한다.
  한 사람이 제거되면 남은 사람들로 이루어진 원을 따라 이 과정을 계속해 나간다. 
  이 과정은 N명의 사람이 모두 제거될 때까지 계속된다. 
  원에서 사람들이 제거되는 순서를 (N, K)-요세푸스 순열이라고 한다. 
  예를 들어 (7, 3)-요세푸스 순열은 <3, 6, 2, 7, 5, 1, 4>이다.*/

public class Main{
	public static void main(String[] args) throws Exception {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Queue<Integer> queue = new LinkedList<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());  //처음 사람 수
		int M = Integer.parseInt(st.nextToken());  //제거되는 번째
		int cnt=1;
		for (int i = 1; i <= N; i++) {
			queue.offer(i);	
		}
		sb.append('<');
		
		while(queue.size()>1) {
            
			for(int i = 1; i <M; i++) { //M번째 전까지 계속 돌기
				queue.offer(queue.poll());
			}
			
			sb.append(queue.poll()).append(", ");
		}
		
		sb.append(queue.poll()).append('>'); 
		System.out.println(sb);
		
		
	}//end of main

}

/** 다른 풀이 while 문 이하 시간초과 문제 else if 로 묶어서 해결  
	while(queue.size()>1) {
			if(cnt==M) {
				sb.append(queue.poll()).append(", ");
				cnt=1;
			}else if(queue.offer(queue.poll())) {
				cnt++;
			}

		}
		
		sb.append(queue.poll()).append('>');
		System.out.println(sb);
		
		
	}//end of main

}


*/

