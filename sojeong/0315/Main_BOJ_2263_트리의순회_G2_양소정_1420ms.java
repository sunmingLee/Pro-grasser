package march0315;

import java.io.BufferedReader;

import java.io.InputStreamReader;
import java.util.StringTokenizer;
//함수 인덱스값 주의
public class Main_BOJ_2263_트리의순회_G2_양소정_1420ms {

	private static int N;
	private static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] in = new int[N];
        int[] post = new int[N];
        for (int i = 0; i < N; i++) {
        	in[i] = Integer.parseInt(st.nextToken());	
		}
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
        	post[i] = Integer.parseInt(st.nextToken());		
		}
        pre(in,post,0,N-1,0,N-1);
        sb.setLength(sb.length()-1);
        System.out.println(sb);
      
    }

	public static void pre(int[] in , int[] post, int is, int ie, int ps,int pe) {
		
		if (is <= ie && ps <= pe) {

			sb.append(post[pe]).append(" ");//post 마지막이 루트
			int pos= is; //전역으로 선언하면 안됨
			for (int i = is; i <= ie; i++) { 
				if (in[i] == post[pe]) {
					pos = i;
					break;
				}
			}
		
		
		pre(in,post,is,pos-1,ps, ps + pos - is - 1); //왼쪽
		
		pre(in,post,pos+1,ie, ps + pos - is, pe - 1); //오른쪽
		}
		
	}
      
}
