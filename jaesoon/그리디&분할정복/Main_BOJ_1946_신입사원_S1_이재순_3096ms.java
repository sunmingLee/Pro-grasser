import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BOJ_1946_신입사원_S1_이재순_3096ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());//테스트 케이스의 갯수, 1 ≤ T ≤ 20
		StringBuilder sb = new StringBuilder();
		for (int testcase = 0; testcase < T; testcase++) {
			int N = Integer.parseInt(br.readLine());//지원자의 수, 1 ≤ N ≤ 100,000
			int[][] applicants = new int[N][2];//지원자 배열 생성, [][0] : 서류 등수, [][1] : 면접 등수
			StringTokenizer st;
			//지원자 배열 초기화
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine()," ");
				applicants[i][0] = Integer.parseInt(st.nextToken());//서류 등수
				applicants[i][1] = Integer.parseInt(st.nextToken());//면접 등수
			}
			//지원재 배열 정렬, 서류 등수 기준으로 오름차순 정렬
			Arrays.sort(applicants, (a,b) -> a[0]-b[0]);
			
			//프로세스 진행, 서류 등수 기준으로 정렬되었으니 서류 등수는 고려 X
			int ans=0;
			int temp=Integer.MAX_VALUE;//현재 확인중인 등수
			for (int i = 0; i < N; i++) {//모든 지원자를 확인
				if (applicants[i][1]<temp) {//현재 확인중인 등수보다 등수가 높으면 진행
					ans++;//채용
					temp = applicants[i][1];//현재 확인중인 등수 갱신
				}
			}
			sb.append(ans).append("\n");
		}
		//출력
		System.out.print(sb);
	}
}
