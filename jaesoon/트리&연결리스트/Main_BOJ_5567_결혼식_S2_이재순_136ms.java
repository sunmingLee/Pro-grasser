import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_BOJ_5567_결혼식_S2_이재순_136ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());//동기의 수 입력, 2 ≤ n ≤ 500
		int m = Integer.parseInt(br.readLine());//리스트의 길이 입력, 1 ≤ m ≤ 10000
		LinkedList<Integer>[] list = new LinkedList[n+1];//친구관계 연결리스트
		HashSet<Integer> set = new HashSet<Integer>();//초대하는 동기 셋
		
		for (int i = 1; i <=n; i++) {//동기의 수만큼 연결리스트 생성 (동기 학번 = 각 배열의 idx)
			list[i] = new LinkedList<Integer>();
		}
		
		//값 초기화
		for (int i = 0; i < m; i++) {//리스트의 길이만큼 반복
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());//a학번
			int b = Integer.parseInt(st.nextToken());//b학번
			list[a].add(b);//a친구 리스트에 b추가
			list[b].add(a);//b친구 리스트에 a추가
		}//end of for m
		
		//프로세스 진행
		while (!list[1].isEmpty()) {//상근이의 친구가 없어질때까지 ㅠㅠ
			int temp = list[1].peek();//상근이의 최근 친구 학번 temp저장
			set.add(temp);//상근이의 친구 초대리스트에 추가
			while (!list[temp].isEmpty()) {//temp의 친구가 없어질때까지 반복
				set.add(list[temp].poll());//친구의 친구 초대리스트에 추가
			}
			list[1].poll();//친구의 친구 모두 초대했으니 친구 삭제 ㅠㅠ
		}
		
		//출력
		set.remove(1);//자기자신 제거
		System.out.println(set.size());//정답 출력
	}//end of main
}//end of class
