import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_SWEA_5644_무선충전_이재순_180ms {
	static int[][] BCArr;
	static int ans;
	static int A;
	static int[][] person = new int[2][2];
	static int[][] deltas = {{0,-1},{1,0},{0,1},{-1,0}};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int testcase = 0; testcase < T; testcase++) {
			ans = 0;
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken())+1; 
			A = Integer.parseInt(st.nextToken()); 
			int[][] moveArr = new int[2][M];
			for (int i = 0; i < 2; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j < M; j++) {
					moveArr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			BCArr = new int[A][6];//A:BC번호   /  0:x좌표, 1:y좌표, 2:충전거리, 3:충전용량, 4:A와의 거리, 5:B와의거리
			for (int i = 0; i < A; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 4; j++) {
					BCArr[i][j] = Integer.parseInt(st.nextToken());
				}
				BCArr[i][4] = BCArr[i][0]+BCArr[i][1]-2;
				BCArr[i][5] =18 - BCArr[i][4];
			}
			Arrays.sort(BCArr, (a, b) -> b[3] - a[3]);
			person[0] = new int[] {1,1};
			person[1] = new int[] {10,10};
			for (int t = 0,temp; t < M; t++) {
				for (int i = 0; i < 2; i++) {
					if ((temp=moveArr[i][t]) != 0) {
						person[i][0] +=deltas[temp-1][0];
						person[i][1] +=deltas[temp-1][1];
						calDistance(i);
					}
				}
				calCharging();
			}
			sb.append("#").append(testcase+1).append(" ").append(ans).append("\n");
		}
		System.out.print(sb);
	}
	private static void calDistance(int who) {
		for (int i = 0; i < A; i++) {
			BCArr[i][who+4] = Math.abs(BCArr[i][0]-person[who][0])+Math.abs(BCArr[i][1]-person[who][1]);
		}
	}
	private static void calCharging() {
		int cnt=0;
		boolean isAChargable=true, isBChargable=true;
		for (int i = 0; i < A; i++) {
			int a, b;
			if (isAChargable) a = BCArr[i][4]-BCArr[i][2];
			else a = 1;
			if (isBChargable) b = BCArr[i][5]-BCArr[i][2];
			else b = 1;
			if (a<=0||b<=0) {
				ans+=BCArr[i][3];
				if (a>0) {
					isBChargable = false;
				}
				else if (b>0) {
					isAChargable = false;
				}
				if (++cnt == 2) break;
			}
		}
	}
}
