
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_SWEA_1289_원재의메모리복구하기_D3_양소정_100ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= T; tc++) {
			int cnt =0;
			int flag =0;
			String str =br.readLine();
			for (int i = 0; i < str.length(); i++) {
				if(flag!=str.charAt(i)-'0') {  //char int 형 주의
					cnt++;
					flag=str.charAt(i)-'0';
				}
				
			}
			sb.append("#").append(tc).append(" ").append(cnt).append("\n");
		}
		System.out.println(sb);
	}

}
