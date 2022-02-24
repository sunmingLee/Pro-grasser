import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_5014_스타트링크_G5_이승연 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int F = Integer.parseInt(st.nextToken()); // 1<=S,G<=F<=1000000
		int S = Integer.parseInt(st.nextToken());
		int G = Integer.parseInt(st.nextToken());
		int U = Integer.parseInt(st.nextToken()); // 0<=U,D<=1000000
		int D = Integer.parseInt(st.nextToken());
	
		boolean[] visited = new boolean[F+1]; // 무한 루프 방지
		
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(S);
		visited[S] = true;
		int cnt = 0;
		boolean flag = false; 
		
		if((S < G && U == 0) || (S > G && D == 0)) {
			System.out.println("use the stairs");
		} else {
			while(!queue.isEmpty()) {
				int current = queue.poll();
				
				if(current == G) {
					flag = true;
					break; 
				}
				else if(current+U <= F && !visited[current+U]) {
					queue.add(current+U);
					visited[current+U] = true;
					cnt++;
				} 
				else if(current-D > 0 && !visited[current-D]) {
					queue.add(current-D);
					visited[current-D] = true;
					cnt++;
				}
			}

			if(!flag) {
				System.out.println("use the stairs");
			} else {
				System.out.println(cnt);
			}
		}
	}
}
