import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_JO_1037_오류교정_이재순_131ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String line;
		int[] row = new int[N], col = new int[N];
		int changeRow = -1, changeCol = -1;
		for (int i = 0; i < N; i++) {
			line = br.readLine();
			for (int j = 0, idx = 0; j < N; j++, idx+=2) {
				if (line.charAt(idx)!='0') {
					row[i]++;
					col[j]++;
				}
			}
			if (row[i]%2!=0) {
				if (changeRow==-1) changeRow = i;
				else {
					System.out.println("Corrupt");
					System.exit(0);
				}
			}
		}
		for (int i = 0; i < N; i++) {
			if (col[i]%2!=0) {
				if (changeCol!=-1||changeRow==-1) {
					System.out.println("Corrupt");
					System.exit(0);
				}
				else changeCol = i;
			}
		}
		if (changeCol!=-1) {
			StringBuilder sb = new StringBuilder();
			System.out.println(sb.append("Change bit (").append(changeRow+1).append(",").append(changeCol+1).append(")"));
		}else if(changeRow!=-1) {
			System.out.println("Corrupt");
		}else System.out.println("OK");
	}
}
