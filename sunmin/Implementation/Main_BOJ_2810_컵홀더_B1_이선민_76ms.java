package Implementation;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BOJ_2810_컵홀더_B1_이선민_76ms {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 좌석의 수
		String s = br.readLine(); // 좌석정보

		// *S, *LL 로 생각해서 컵홀더의 개수를 센 뒤 사람수와 비교해서 답 출력
		int cnt = 1; // 맨 끝자리 오른쪽에 컵홀더가 있으므로
		for (int i = 0; i < N; i++) {
			if (s.charAt(i) == 'S') {
				cnt++;
			} else if (s.charAt(i) == 'L') {
				cnt++;
				i++;
			}
		}

		if (cnt > N) {
			System.out.print(N);
		} else {
			System.out.print(cnt);
		}

	} // end of main

}
