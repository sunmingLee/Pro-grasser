import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_SWEA_1961_숫자배열회전_D2_이재순_108ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			char[][] arr90 = new char[N][N];
			char[][] arr180 = new char[N][N];
			char[][] arr270 = new char[N][N];
			for (int i = 0; i < N; i++) {
				String line = br.readLine();
				for (int j = 0, idx = 0; j < N; j++, idx +=2) {
					arr90[i][j]	= line.charAt(idx);
					arr180[i][j]	= line.charAt(idx);
					arr270[i][j]	= line.charAt(idx);
				}
			}
			rotate90(arr90,N);
			rotate180(arr180,N);
			rotate270(arr270,N);
			sb.append("#").append(tc).append("\n");
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					sb.append(arr90[i][j]);
				}
				sb.append(" ");
				for (int j = 0; j < N; j++) {
					sb.append(arr180[i][j]);
				}
				sb.append(" ");
				for (int j = 0; j < N; j++) {
					sb.append(arr270[i][j]);
				}
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}
	private static void rotate90(char[][] arr, int N) { 
		int r = N--/2;
		int start = 0;
		for (int k = 0; k < r; k++) {
			for (int j = 0; j < N; j++) {
				char temp = arr[start][start + j];
				arr[start][start + j] = arr[start+N - j][start];
				arr[start+N - j][start] = arr[start+N][start+N - j];
				arr[start+N][start+N-j] = arr[start + j][start+N];
				arr[start + j][start+N] = temp;
			}
			N-=2;
			start++;
		}
	}
	private static void rotate180(char[][] arr, int N) { 
		int r = N--/2;
		int start = 0;
		for (int k = 0; k < r; k++) {
			for (int j = 0; j < N; j++) {
				char temp = arr[start][start + j];
				arr[start][start + j] = arr[start+N][start+N - j];
				arr[start+N][start+N - j] = temp;
				temp = arr[start+N - j][start];
				arr[start+N - j][start] = arr[start + j][start+N];
				arr[start + j][start+N] = temp;
			}
			N-=2;
			start++;
		}
	}
	private static void rotate270(char[][] arr, int N) { 
		int r = N--/2;
		int start = 0;
		for (int k = 0; k < r; k++) {
			for (int j = 0; j < N; j++) {
				char temp = arr[start][start + j];
				arr[start][start + j] = arr[start + j][start+N];
				arr[start + j][start+N] = arr[start+N][start+N-j];
				arr[start+N][start+N-j] = arr[start+N - j][start];
				arr[start+N - j][start] = temp;
			}
			N-=2;
			start++;
		}
	}
}
