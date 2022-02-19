import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_6603_로또_S2_이승연_80ms {	
	private static int K;
	private static StringBuilder sb;
	private static int[] result;
	private static int[] S;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		StringTokenizer st;
		String str = br.readLine(); 

		while(!str.equals("0")) {
			st = new StringTokenizer(str, " ");

			K = Integer.parseInt(st.nextToken());
			S = new int[K];
			result = new int[6];
			
			for(int i=0; i<K; i++) {
				S[i] = Integer.parseInt(st.nextToken());
			}
			
			combination(0, 0);
			sb.append("\n");
			
			str = br.readLine();
		}
		
		System.out.print(sb.toString());
	}
	
	public static void combination(int cnt, int start) {
		if(cnt == 6) {
			for(int i=0; i<6; i++) {
				sb.append(result[i]).append(" ");
			}
			sb.append("\n");
			
			return; 
		}
		
		for(int i=start; i<K; i++) {
			result[cnt] = S[i];
			combination(cnt+1, i+1);
		}
	}
}
