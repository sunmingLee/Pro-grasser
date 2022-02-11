import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * <pre>
 * N2개의 방이 N×N형태로 늘어서 있다.
 *위에서 i번째 줄의 왼쪽에서 j번째 방에는 1이상 N2 이하의 수 Ai,j가 적혀 있으며, 이 숫자는 모든 방에 대해 서로 다르다.
 *당신이 어떤 방에 있다면, 상하좌우에 있는 다른 방으로 이동할 수 있다.
 *물론 이동하려는 방이 존재해야 하고, 이동하려는 방에 적힌 숫자가 현재 방에 적힌 숫자보다 정확히 1 더 커야 한다.
 *처음 어떤 수가 적힌 방에서 있어야 가장 많은 개수의 방을 이동할 수 있는지 구하는 프로그램을 작성하라.
 *
 *[입력]
 *첫 번째 줄에 테스트 케이스의 수 T가 주어진다.
 *각 테스트 케이스의 첫 번째 줄에는 하나의 정수 N (1 ≤ N ≤ 103)이 주어진다.
 *다음 N개의 줄에는 i번째 줄에는 N개의 정수 Ai, 1, … , Ai, N (1 ≤ Ai, j ≤ N2) 이 공백 하나로 구분되어 주어진다.
 *Ai, j는 모두 서로 다른 수이다.
 *
 *[출력]
 *각 테스트 케이스마다 ‘#x’(x는 테스트케이스 번호를 의미하며 1부터 시작한다)를 출력하고,
 *한 칸을 띄운 후, 처음에 출발해야 하는 방 번호와 최대 몇 개의 방을 이동할 수 있는지를 공백으로 구분하여 출력한다.
 *이동할 수 있는 방의 개수가 최대인 방이 여럿이라면 그 중에서 적힌 수가 가장 작은 것을 출력한다.
 *</pre>
 */
public class Solution_SWEA_1861_정사각형방_D4_이재순_141ms {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N; // 정사각형방의 한변의 길이
		int[] arr; // N*N개 수의 좌표를 담는 배열
		int T = Integer.parseInt(br.readLine()); // 테스트케이스
		for (int testcase = 0; testcase < T; testcase++) {
			N = Integer.parseInt(br.readLine()); // 정사각형방의 한변의 길이 초기화
			arr = new int[N * N + 1]; // N*N개 수를 idx와 일치하게 만들기 위해 N*N+1사용
			arr[0] = 10000000; // 필요없는 배열(나중에 사용하기때문에 필요없는 값 대입)
			StringTokenizer st;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) // arr[숫자] = 숫자의 좌표로 초기화
					arr[Integer.parseInt(st.nextToken())] = 1000 * i + j; // i,j -> 000,000식으로 표현 (N<=1000이므로)
			}
			int idx = 0; // 현재 체크하고 있는 수
			int curlength = 1; // 이동 가능한 방의 길이(자기자신도 이동가능한 것이므로 1로 초기화)
			int maxlength = 0; // 최대로 이동가능한 방의 길이
			int diff;// idx와 idx-1의 좌표차이
			for (int i = N * N; i > 0; i--) {
				diff = arr[i] - arr[i - 1]; // idx와 idx-1의 좌표차이
				if (diff == 1 || diff == 1000 ||diff == -1||diff == -1000)// diff가 +-1,인경우 양옆중 하나, diff가 +-1000인경우 위아래중 하나
					curlength++;
				else {
					if (curlength < maxlength) {
						curlength = 1; // 이동가능한 방의 길이 초기화
						continue;
					}
					maxlength = curlength;
					idx = i;
					if (maxlength > i - 1)
						break; // 최대 이동가능한 길이가 남은 수보다 클경우 남은수 볼 필요 없음
					curlength = 1; // 이동가능한 방의 길이 초기화
				}
			}
			sb.append("#").append(testcase + 1).append(" ").append(idx).append(" ").append(maxlength).append("\n");
		}
		System.out.print(sb);
	}//end of main
}//end of class
