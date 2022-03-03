import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_7272_안경이없어_D3_이재순_137ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
loop:	for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			String a = st.nextToken(), b = st.nextToken();
			int size = a.length();
			if (b.length()!=size) {
				sb.append("#").append(tc).append(" DIFF\n");
				continue;
			}
			for (int i = 0; i < size; i++) {
				switch (a.charAt(i)) {
				case 'A':case 'D':case 'O':case 'P':case 'Q':case 'R':
					switch (b.charAt(i)) {
					case 'A':case 'D':case 'O':case 'P':case 'Q':case 'R':
						break;
					default:
						sb.append("#").append(tc).append(" DIFF\n");
						continue loop;
					}
					break;
				case 'B':
					switch (b.charAt(i)) {
					case 'B':
						break;
					default:
						sb.append("#").append(tc).append(" DIFF\n");
						continue loop;
					}
					break;
				default:
					switch (b.charAt(i)) {
					case 'A':case 'D':case 'O':case 'P':case 'Q':case 'R':case 'B':
						sb.append("#").append(tc).append(" DIFF\n");
						continue loop;
					default:
						break;
					}
					break;
				}
			}
			sb.append("#").append(tc).append(" SAME\n");
		}
		System.out.print(sb);
	}
}
