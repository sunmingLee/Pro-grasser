import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_BOJ_2527_직사각형_S1_이재순_76ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		String line;
		while ((line = br.readLine())!=null) {
			st = new StringTokenizer(line);
			int[] a = new int[4], b = new int[4];
			for (int i = 0; i < 4; i++) {
				a[i] = Integer.parseInt(st.nextToken());
			}
			for (int i = 0; i < 4; i++) {
				b[i] = Integer.parseInt(st.nextToken());
			}
			
			if (a[2]<b[0]||a[3]<b[1]||b[2]<a[0]||b[3]<a[1]) {
				sb.append("d\n");
			}
			else if ((a[0]==b[2]&&a[1]==b[3])||(a[2]==b[0]&&a[1]==b[3])||(a[2]==b[0]&&a[3]==b[1])||(a[0]==b[2]&&a[3]==b[1])) {
				sb.append("c\n");
			}
			else if ((a[0]==b[2]&&((a[1]<=b[1]&&a[3]>b[1])||(a[1]<b[3]&&a[3]>=b[3])||(a[1]>b[1]&&a[3]<b[3])))||
					(a[1]==b[3]&&((a[0]<=b[0]&&a[2]>b[0])||(a[0]<b[2]&&a[2]>=b[2])||(a[0]>b[0]&&a[2]<b[2])))||
					(a[2]==b[0]&&((a[1]<=b[1]&&a[3]>b[1])||(a[1]<b[3]&&a[3]>=b[3])||(a[1]>b[1]&&a[3]<b[3])))||
					(a[3]==b[1]&&((a[0]<=b[0]&&a[2]>b[0])||(a[0]<b[2]&&a[2]>=b[2])||(a[0]>b[0]&&a[2]<b[2])))) {
				sb.append("b\n");
			}
			else {
				sb.append("a\n");
			}
		}
		System.out.println(sb);
	}
}
