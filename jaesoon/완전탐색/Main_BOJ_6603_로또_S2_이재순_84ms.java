import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_6603_로또_S2_이재순_84ms {
	static int[] arr;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int k;
		while ((k = Integer.parseInt(st.nextToken())) != 0 ) {
			arr = new int[k];
			for (int i = 0; i < k; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			combination(0, 6, 0);
			
			sb.append("\n");
			st = new StringTokenizer(br.readLine());
		}
		System.out.println(sb);
	}
	
	private static void combination(int start, int r, int flag) {
		if (r==0) {
			for (int i = 0; i < arr.length; i++) {
				if ((flag&1<<i) !=0) {
					sb.append(arr[i]).append(" ");
				}
			}
			sb.setLength(sb.length()-1);
			sb.append("\n");
		}
		
		for (int i = start; i < arr.length; i++) {
			combination(i+1, r-1, flag|1<<i);
		}
	}
}
