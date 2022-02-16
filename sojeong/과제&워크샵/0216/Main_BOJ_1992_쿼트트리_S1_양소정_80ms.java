import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_1992_쿼트트리_S1_양소정_80ms{
	
	private static int[][] map;
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j <N; j++) {
				map[i][j] = str.charAt(j)-'0';
			
			}
		}
		
		QuadTree(0,0,N);
		System.out.println(sb);
		
	}

	private static void QuadTree(int x, int y,int size) {
		
		if(check(x,y,size)) {
			sb.append(map[x][y]);  // 0인지 1인지 모르느까 map[x][y]로 
			return;
		}
		int nsize = size/2;
		sb.append("(");
		
		QuadTree(x,y,nsize);    //1사분면
		QuadTree(x,y+nsize,nsize);  //2사분면
		QuadTree(x+nsize,y,nsize);	//3사분면
		QuadTree(x+nsize,y+nsize,nsize);	//4사분면
	
		sb.append(")");

	}

	private static boolean check(int x, int y, int size) {
		int a = map[x][y]; //다른지 비교 위해
		
		for (int i = x; i < x+size; i++) {
			for (int j = y; j < y+size; j++) {
				if(a != map[i][j]) {
					return false;
				}
			}
			
		}
		return true; //모든 값이 같다면
	}//end of main

}
