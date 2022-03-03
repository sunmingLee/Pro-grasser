import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_SWEA_1974_스도쿠검증_D2_이재순_110ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		boolean[][] col, square = new boolean[3][10];
		boolean[] row;;
loop:	for (int tc = 1; tc <= T; tc++) {
			col = new boolean[9][10];
			for (int i = 0; i < 9; i++) {
				if (i%3==0) square = new boolean[3][10];
				row = new boolean[10];
				String line = br.readLine();
				for (int j = 0, idx = 0; j < 9; j++, idx += 2) {
					int temp = line.charAt(idx)-'0';
					if (!row[temp]&&!square[j/3][temp]&&!col[j][temp]) {
						square[j/3][temp] = true;
						row[temp] = true;
						col[j][temp] = true;
					}else {
						sb.append("#").append(tc).append(" ").append(0).append("\n");
						for (int k = i+1; k < 9; k++) br.readLine();
						continue loop;
					}
				}
			}
			sb.append("#").append(tc).append(" ").append(1).append("\n");
		}
		System.out.print(sb);
	}
}
