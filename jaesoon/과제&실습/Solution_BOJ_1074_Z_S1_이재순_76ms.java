import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_BOJ_1074_Z_S1_이재순_76ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());//1 <= N <= 15
		int r = Integer.parseInt(st.nextToken());//타겟의 row 좌표, 0 <= r <= 2^N
		int c = Integer.parseInt(st.nextToken());//타겟의 col 좌표, 0 <= c <= 2^N
		int n = 1<<N;//배열의 크기
		int ans = 0;//답
		for (int i = 0; i < N; i++) {//N만큼 반복 (n이 1이 될때까지 반복)
			n /= 2;//4등분한 배열의 크기
			int a = 0;//
			if (r>=n) {//타겟이 상하 절반 아래에 있다면 진행
				a+=2;//4등분한 배열중 2개 누적
				r-=n;//4등분한 새로운 배열에서의 새로운 타겟 row좌표
			}
			if (c>=n) {//타겟이 좌우 절반 오른쪽에 있다면 진행
				a+=1;//4등분한 배열중 1개 누적
				c-=n;//4등분한 새로운 배열에서의 새로운 타겟 col좌표
			}
			ans+=n*n*a;//누적한 4등분 배열 갯수 기준으로 칸 누적
		}
		System.out.print(ans);//정답 출력
	}
}