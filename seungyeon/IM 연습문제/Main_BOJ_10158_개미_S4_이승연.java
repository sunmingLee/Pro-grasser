import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_10158_개미_S4_이승연 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine(), " ");
		int p = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		
		int t = Integer.parseInt(br.readLine());
		
		int dir_w = 1;
		int dir_h = 1; 
	
		for(int i=0; i<t; i++) {
			p += dir_w;
			q += dir_h;
			
			if(p == 0 || p == w) {
				if(q == 0 || q == h) {
					dir_w *= -1;
					dir_h *= -1;					
				} else {
					dir_w *= -1;
				}
			} 
			else if(q == 0 || q == h) {
				dir_h *= -1;
			}
		}
		
		System.out.println(p+" "+q);
	}
}
