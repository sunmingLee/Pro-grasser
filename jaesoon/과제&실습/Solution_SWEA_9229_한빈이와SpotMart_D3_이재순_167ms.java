import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_9229_한빈이와SpotMart_D3_이재순_167ms { 
	public static void main(String[] args) throws IOException {
		int N, M, max;
		int[] arr;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		int temp, cnt;
		for (int i = 0; i < T; i++) {
			sb.append("#").append(i + 1).append(" ");
			cnt = 0;
			max = -1;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			arr = new int[N];
			//N개의 과자중 무게 제한M보다 가벼온 과자 cnt개만 배열에 저장
			for (int j = 0; j < N; j++) {
				if ((temp = Integer.parseInt(st.nextToken())) < M) arr[cnt++] = temp;
			}
			//cnt개의 과자 중 2개를 뽑는 조합을 만들며 무게 확인
			loop: 
			for (int j = 0; j < cnt; j++) {
				for (int k = j + 1; k < cnt; k++) {
					if ((temp = arr[j] + arr[k]) == M) {
						max = M; // max가 무게제한과 일치하면 바로 break
						break loop;
					}
					if (temp < M) max = Integer.max(temp, max);
				}
			}
			sb.append(max).append("\n");
		}
		System.out.print(sb);
	}// end of main
}// end of class