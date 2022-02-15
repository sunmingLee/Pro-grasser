import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_3499_퍼펙트셔플_D3_이승연_120ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		
		for(int testCase=1; testCase<=TC; testCase++) {
			int card_num = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			String[] card = new String[card_num];
			
			int card_f_num = (card_num+1)/2;
			
			for(int i=0; i<card_f_num; i++) {
				card[2*i] = st.nextToken();
			} 

			for(int i=card_f_num; i<card_num; i++) {
				card[2*(i%card_f_num)+1] = st.nextToken();
			}
			sb.append("#").append(testCase).append(" ");
			
			for(int i=0; i<card_num; i++) {
				sb.append(card[i]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.print(sb.toString());
	}
}
