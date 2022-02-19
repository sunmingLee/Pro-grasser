import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BOJ_1992_쿼드트리_S1_이승연_80ms {
	private static char[][] video;
	private static StringBuilder sb;
	private static int N;

	public static void main(String[] args) throws Exception {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 sb = new StringBuilder();
		 
		 N = Integer.parseInt(br.readLine()); // 영상 크기 (1<=N<=64)
		 
		 video = new char[N][N];
		 
		 for(int i=0; i<N; i++) {
			 video[i] = br.readLine().toCharArray();
		 }
		 
		 compress(0, 0, N);
		 System.out.print(sb.toString());
	}
	
	public static void compress(int r, int c, int size) { // size: 변 길이 
		if(r == N && c == N) return; 
		
		char temp = video[r][c]; 
		boolean allSame = true;
		
		for(int i=0; i<size; i++) {
			for(int j=0; j<size; j++) {
				if(video[r+i][c+j] != temp) { // 하나라도 다른 수가 있으면 압축 X
					allSame = false; 
					break; 
				}
			}
		}
		
		if(allSame) { // 다 같으면 
			sb.append(temp);
			
			return; 
		}
		else { // 하나라도 다르면 
			int size_half = size/2; 

			sb.append("(");
			
			compress(r, c, size_half); // 1사분면 
			compress(r, c+size_half, size_half); // 2사분면 
			compress(r+size_half, c, size_half); // 3사분면 
			compress(r+size_half, c+size_half, size_half); // 4사분면 
			
			sb.append(")");
		}
	}
}
