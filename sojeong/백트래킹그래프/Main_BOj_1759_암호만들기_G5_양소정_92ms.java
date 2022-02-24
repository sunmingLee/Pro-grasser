package 백트래킹그래프;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BOj_1759_암호만들기_G5_양소정_92ms{
	private static int L,C;
	private static char[] arr;
	private static char[] ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new char[C];
		ans = new char[L];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < C; i++) {
			arr[i] = st.nextToken().charAt(0);
			
		}
		
		Arrays.sort(arr);
		com(0,0);
		
	}

	private static void com(int cnt, int start) {
		if(cnt == L) {
			int a = 0 ; //모음 개수
			int b = 0 ; //자음 개수
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < L; i++) {
				sb.append(ans[i]);
				if(ans[i]=='a'||ans[i]=='e'||ans[i]=='i'||ans[i]=='o'|| ans[i]=='u') a++;
				else b++;
				
			}
			
			if(a >= 1 && b >= 2) System.out.println(sb);
			return;
		}
		
		for (int i = start; i < C ; i++) {
			ans[cnt] = arr[i];
			com(cnt+1,i+1);
		}
		
	}

}
