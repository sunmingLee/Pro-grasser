import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_SWEA_1220_Magnetic_D3_이재순_120ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String n;
		int tc = 1;
		StringBuilder sb = new StringBuilder();
		while ((n=br.readLine())!=null) {
			int N = Integer.parseInt(n);
			int[] col = new int[N]; 
			Arrays.fill(col, '2');
			int ans=0;
			for (int i = 0; i < N; i++) {
				String line = br.readLine();
				for (int j = 0, idx = 0, temp ; j < N; j++, idx+=2) {
					if ((temp = line.charAt(idx))!='0') {
						if (col[j]!=temp) {
							ans++;
							col[j] = temp;
						}
					}
				}
			}
			for (int i = 0; i < N; i++) {
				if (col[i]=='1') {
					ans--;
				}
			}
		sb.append("#").append(tc++).append(" ").append(ans/2).append("\n");
		}
		System.out.print(sb);
	}
}
