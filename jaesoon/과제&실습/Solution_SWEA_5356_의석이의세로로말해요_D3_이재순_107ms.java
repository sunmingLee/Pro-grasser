import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_SWEA_5356_의석이의세로로말해요_D3_이재순_107ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			char[][] arr = new char[5][];
			int maxSize = 0;
			for (int i = 0; i < 5; i++) {
				arr[i] = br.readLine().toCharArray();
				if (maxSize<arr[i].length) maxSize = arr[i].length;
			}
			for (int i = 0; i < maxSize; i++) {
				if (i<arr[0].length) sb.append(arr[0][i]);
				if (i<arr[1].length) sb.append(arr[1][i]);
				if (i<arr[2].length) sb.append(arr[2][i]);
				if (i<arr[3].length) sb.append(arr[3][i]);
				if (i<arr[4].length) sb.append(arr[4][i]);
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
}
