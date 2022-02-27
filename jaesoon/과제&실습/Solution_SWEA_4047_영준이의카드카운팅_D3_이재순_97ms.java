import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_SWEA_4047_영준이의카드카운팅_D3_이재순_97ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
loop:	for (int tc = 1; tc <= T; tc++) {
			String line = br.readLine();
			int size = line.length();
			boolean[] s = new boolean[14], d = new boolean[14], h = new boolean[14], c = new boolean[14];
			int ss = 13, dd = 13, hh = 13, cc = 13;
			for (int i = 0, temp; i < size;) {
				switch (line.charAt(i)) {
				case 'S':
					temp = Integer.parseInt(line.substring(++i, (i+=2)));
					if (s[temp]) {
						sb.append("#").append(tc).append(" ERROR\n");
						continue loop;
					}
					s[temp] = true;
					ss--;
					break;
				case 'D':
					temp = Integer.parseInt(line.substring(++i, (i+=2)));
					if (d[temp]) {
						sb.append("#").append(tc).append(" ERROR\n");
						continue loop;
					}
					d[temp] = true;
					dd--;
					break;
				case 'H':
					temp = Integer.parseInt(line.substring(++i, (i+=2)));
					if (h[temp]) {
						sb.append("#").append(tc).append(" ERROR\n");
						continue loop;
					}
					h[temp] = true;
					hh--;
					break;
				case 'C':
					temp = Integer.parseInt(line.substring(++i, (i+=2)));
					if (c[temp]) {
						sb.append("#").append(tc).append(" ERROR\n");
						continue loop;
					}
					c[temp] = true;
					cc--;
					break;
				}
			}
			sb.append("#").append(tc).append(" ").append(ss).append(" ").append(dd).append(" ").append(hh).append(" ").append(cc).append("\n");
		}
		System.out.println(sb);
	}
}
