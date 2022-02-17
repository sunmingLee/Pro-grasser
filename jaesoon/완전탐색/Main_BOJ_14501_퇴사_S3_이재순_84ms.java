import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_14501_퇴사_S3_이재순_84ms {
	private static int N, ans;//N : 남은 일수, 1 ≤ N ≤ 15 / ans : 정답
	private static int[][] arr;//상담기간과 이익을 저장하는 배열

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());//남은 일수, 1 ≤ N ≤ 15
		arr = new int[N][2];//상담기간과 이익을 저장하는 배열
		StringTokenizer st;
		for (int i = 0; i < N; i++) {//남은 일수만큼 반복
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());//상담기간 초기화
			arr[i][1] = Integer.parseInt(st.nextToken());//이익 초기화
		}
		ans = Integer.MIN_VALUE;//ans초기화
		combination(0, 0);//프로세스 진행
		System.out.println(ans);//출력
	}

	private static void combination(int start, int flag) {
		if (start == N) {//퇴사일까지 진행했다면 진행
			int sum = 0;//누적 이익을 저장하는 변수
			for (int i = 0; i < N; i++) {
				if ((flag & 1 << i) != 0) {
					sum += arr[i][1];//이익 누적
				}
				if (sum > ans) {//최대이익 저장
					ans = sum;
				}
			}
			return;
		} // 기저조건
		
		for (int i = start; i < N; i++) {
			if (i+arr[i][0]<=N) {//i번째 상담이 퇴사전에 가능하다면 진행
				combination(i + arr[i][0], flag | 1 << i);//해당 상담을 진행하고  상담이 끝나는 날부터 재귀
			}
		}
		combination(N,flag);//남은 상담중 가능한 상담이 없을경우를 대비해 강제로 퇴사일로 텔레포트
	}
}
