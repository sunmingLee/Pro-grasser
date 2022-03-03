import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_SWEA_5432_쇠막대기자르기_D4_이재순_143ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= T; tc++) {
			String line = br.readLine();
			int size = line.length();
			int ans = 0, pipe = 0, curPipe = 0;
			for (int i = 0; i < size; i++) {
				switch (line.charAt(i)) {
				case '(':
					if (line.charAt(i+1)==')') {
						ans+=curPipe;
						i++;
					}else {
						pipe++;
						curPipe++;
					}
					break;
				case ')':
					curPipe--;
					break;
				}
			}
			sb.append("#").append(tc).append(" ").append(ans+pipe).append("\n");
		}
		System.out.print(sb);
	}
}
