import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_BOJ_17406_배열돌리기4_G4_이재순_312ms {
	static String[][] arr;
	static int min=5001;
	static int K;
	static int[][] cmd;
	static boolean[] isused;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());//배열의 row수, 2 ≤ N ≤ 300
		int M = Integer.parseInt(st.nextToken());//배열의 col수, 2 ≤ M ≤ 300
		K = Integer.parseInt(st.nextToken());//명령 수 1 ≤ K ≤ 6
		arr = new String[N][M]; // 입력된 배열 생성
		for (int i = 0; i < N; i++) {
			arr[i] = br.readLine().split(" ");
		}
		isused = new boolean[K];
		cmd = new int[K][3];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			cmd[i][0] = Integer.parseInt(st.nextToken())-1;
			cmd[i][1] = Integer.parseInt(st.nextToken())-1;
			cmd[i][2] = Integer.parseInt(st.nextToken());
		}
		permutation(0, arr);
		
		System.out.println(min);
	}
	private static void min(String[][] arr) {
		for (String[] strings : arr) {
			int sum=0;
			for (String string : strings) {
				sum += Integer.parseInt(string);
			}
			if (min>sum) {
				min = sum;
			}
		}
	}
	private static String[][] rotate(int r, int c, int s, String[][] arr) {
		String[][] str2 = new String[arr.length][arr[0].length];
		for (int i = 0; i < str2.length; i++) {
			System.arraycopy(arr[i], 0, str2[i], 0, str2[0].length);
		}
		r = r-s;
		c = c-s;
		for (int i = 0; i < s; i++) {//레이어의 수만큼 반복
			String temp = str2[r][c];
			for (int j = 0; j < (s - i) * 2; j++) { // 하로이동
				str2[r][c] = str2[++r][c];
			}
			for (int j = 0; j < (s - i) * 2; j++) { // 우로이동
				str2[r][c] = str2[r][++c];
			}
			for (int j = 0; j < (s - i) * 2; j++) { // 상으로이동
				str2[r][c] = str2[--r][c];
			}
			for (int j = 0; j < (s - i) * 2; j++) { // 좌로이동
				str2[r][c] = str2[r][--c];
			}
			str2[r++][++c] = temp; // r,c에있던 원소를 마지막 자리에 넣어주며 시작지점 r,c에 +1해주어 다음 반복 준비
		}
		return str2;
	}
	
	private static void permutation(int cnt, String[][] str) {
		if(cnt == K) {
			min(str);
			return;
		}
		for (int i = 0; i < K; i++) {
			if (!isused[i]) {
				isused[i]=true;
				permutation(cnt+1, rotate(cmd[i][0], cmd[i][1], cmd[i][2], str));
				isused[i]=false;
			}
		}
		
	}
}
