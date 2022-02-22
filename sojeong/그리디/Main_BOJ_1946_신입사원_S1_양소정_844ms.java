package 그리디;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_1946_신입사원_S1_양소정_844ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 0; tc < T; tc++) {
			int N = Integer.parseInt(br.readLine()); // 지원자 수
			int []arr = new int [N+1];
			int cnt = 1; // 채용된 사람 수 . 정렬 후 첫째는 무조건 채용
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int rank = Integer.parseInt(st.nextToken());
				arr[rank] = Integer.parseInt(st.nextToken()); //서류순으로 면접 성적 입력됨
			}
			
			int pivot = arr[1];	// 첫 번째 지원자의 면접 성적이 기준
			for(int i=1; i<=N; i++) {
				if(arr[i] < pivot) {	// 기준보다 성적 더 높으면
					pivot = arr[i];	// 비교 성적 갱신
					cnt ++; //선발
				}
			}
			sb.append(cnt).append("\n");
		}
		System.out.println(sb);
		
	}

}
