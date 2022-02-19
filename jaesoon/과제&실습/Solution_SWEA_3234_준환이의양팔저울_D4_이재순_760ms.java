import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_3234_준환이의양팔저울_D4_이재순_760ms {
	static int ans;//정답

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int testcase = 0; testcase < T; testcase++) {
			int N = Integer.parseInt(br.readLine());//추의 갯수, 1 ≤ N ≤ 9
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] chu = new int[N];
			int sum = 0;//추의 무게 합을 저장하는 변수
			//배열, sum초기화
			for (int i = 0; i < N; i++) {//추의 갯수만큼 진행
				chu[i] = Integer.parseInt(st.nextToken());//추의 무게, 1 <= chu[i] <= 999
				sum += chu[i];
			}
			
			ans = 0;//정답 초기화
			permutation(0, sum, 0, chu, N);//프로세스 진행
			sb.append("#").append(testcase + 1).append(" ").append(ans).append("\n");//출력형식에 맞춰 추가
		}
		System.out.print(sb);//출력
	}

	private static void permutation(int flag, int totalLeft, int diff, int[] chu, int N) {
		if (totalLeft <= diff) {//남은 추들의 무게 합 보다 (왼쪽저울 무게합-오른쪽저을 무게합)보다 적으면 진행
			int a = 0;//남은 추의 갯수를 저장
			int left = 1;//a!을 저장
			for (int i = 0; i < N; i++) {
				if ((flag & 1 << i) == 0) {//i번째 추를 사용하지 않았다면 진행
					left *= ++a;
				}
			}
			ans += left * (1 << a);
			return;
		}
		for (int i = 0; i < N; i++) {//추의 갯수만큼 반복
			if ((flag & 1 << i) == 0) {//i번째 추를 사용하지 않았다면 진행
				int temp = chu[i];//추의 무게 임시 저장
				permutation(flag | 1 << i, totalLeft - temp, diff + temp, chu, N);//왼쪽 저울에 올려놓기
				if (diff-temp>=0) {//오른쪽 저울에 올려도 왼쪽저울이 오른쪽저울보다 무겁다면 진행
					permutation(flag | 1 << i, totalLeft - temp, diff - temp, chu, N);//오른쪽 저울에 올려놓기
				}
			}
		}
	}
}