import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_BOJ_5639_이진검색트리_G5_이승연_236ms {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] pre = new int[10000];
		
		int n = 0;
		String str = null;
		
//		while(!(str = br.readLine()).isEmpty()) {
		while((str = br.readLine()) != null) {
			pre[n++] = Integer.parseInt(str); 
		}
		
		int[] post = new int[n];
		pre = Arrays.copyOfRange(pre, 0, n);
				
		calc(0, n-1, 0, n-1, pre, post, n);
		
		StringBuilder sb = new StringBuilder();
		
		for(int i : post) {
			sb.append(i).append("\n");
		}
		
		System.out.print(sb.toString());
	}
	
	public static void calc(int pre_sp, int pre_fp, int post_sp, int post_fp, int[] pre, int[] post, int n) {
		if(pre_sp > pre_fp || post_sp > post_fp) return; 		

		post[post_fp] = pre[pre_sp];
		
		int idx = pre_sp+1;
		int sm_n = 0;

		while(idx <= pre_fp && pre[idx] < pre[pre_sp]) {
			idx++;
			sm_n++;
		}

		pre_sp++; 
		calc(pre_sp, pre_sp+sm_n-1, post_sp, post_sp+sm_n-1, pre, post, n);
		calc(pre_sp+sm_n, pre_fp, post_sp+sm_n, post_fp-1, pre, post, n);
	}
}
