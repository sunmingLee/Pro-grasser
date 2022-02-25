import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_5014_스타트링크_G5_이재순_180ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int F = Integer.parseInt(st.nextToken())+1;// 1 ≤ S, G ≤ F ≤ 1000000
		int S = Integer.parseInt(st.nextToken());// 1 ≤ S ≤ F ≤ 1000000
		int G = Integer.parseInt(st.nextToken());// 1 ≤ G ≤ F ≤ 1000000
		int U = Integer.parseInt(st.nextToken());// 0 ≤ D ≤ 1000000
		int D = Integer.parseInt(st.nextToken());// 0 ≤ U ≤ 1000000
		int[] cnt = new int[F];//해당층에 도착하기 위한 최소 이동 횟수+1을 저장하는 배열 
		Queue<Integer> q = new LinkedList<Integer>();//탐색할 층들을 저장하는 큐(BFS)
		q.add(S);//시작점 추가
		cnt[S] = 1;//시작층 이동횟수 초기화 (0으로 하고 시작하면 방문하지 않은 층과 똑같아서 문제 생김)
		if (S == G) {//시작층과 목표층이 같을경우 체크
			System.out.println(0);
			return;
		}
		//bfs진행
		while (!q.isEmpty()) {//큐가 비는 상황 -> 더이상 새로운층이 존재하지 않음
			int cur = q.poll();//현재 층 
			int up = cur + U;//위로 이동했을때의 층
			int down = cur - D;//아래로 이동했을때의 층 
			if (up == G || down == G) {//목표층으로 이동할수 있으면 진행
				System.out.println(cnt[cur]);//출력후 종료
				return;
			}
			if (up < F&&cnt[up]==0) {//존재하는 층이고 새로운 층이라면 진행
				cnt[up] = cnt[cur]+1;//최소 이동 횟수+1 저장
				q.offer(up);
			}
			if (down > 0&&cnt[down]==0) {//존재하는 층이고 새로운 층이라면 진행
				cnt[down] = cnt[cur]+1;//최소 이동 횟수+1 저장
				q.offer(down);
			}
		}
		System.out.println("use the stairs");//while문에서 목표층에 도달하지 못하였으므로 불가능
	}
}
