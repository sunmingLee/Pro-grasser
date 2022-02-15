import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_BOJ_11725_트리의부모찾기_S2_이재순_524ms {
	static int[] ans;//각 인덱스의 부모인덱스를 저장하는 배열
	static LinkedList<Integer>[] lists;//각 인덱스의 간선을 저장하는 연결리스트 배열
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());//노드의 개수 입력, 2 ≤ N ≤ 100,000
		lists =  new LinkedList[N+1];//각 인덱스를 번호로 설정하기위해 N+1개의 배열 설정
		for (int i = 1; i <=N; i++) {//노드 생성
			lists[i] = new LinkedList<Integer>();
		}
		
		//값 초기화
		StringTokenizer st;
		for (int i = 1; i < N; i++) {//간선의 수만큼 반복 (N-1)
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());//a노드
			int b = Integer.parseInt(st.nextToken());//b노드
			lists[a].add(b);//a노드에 b노드 추가
			lists[b].add(a);//b노드에 a노드 추가,양방향 간선 연결
		}
		
		//프로세스 진행
		ans = new int[N+1];
		findparent(lists[1], 1);
		
		//출력
		StringBuilder sb = new StringBuilder();
		for (int i = 2; i <= N; i++) {
			sb.append(ans[i]).append("\n");
		}
		System.out.print(sb);
	}
	/**
	 * 리스트를 입력받아 자식노드의 부모를 자기자신의 인덱스로 저장하는 메소드 
	 */
	private static void findparent(LinkedList<Integer> list, int curIdx) {
		while (!list.isEmpty()) {//간선이 없어질때까지 반복
			int temp = list.peek();//자식노드 인덱스 임시저장
			if (ans[temp]==0) {//부모가 없다면 진행 
				ans[temp] = curIdx;//ans배열에 자신의 인덱스 저장
				findparent(lists[temp], list.poll());//dfs
			}else list.poll();//부모방향으로 거슬러 오르는거 차단
		}
	}
}
