import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BOJ_1992_쿼드트리_S1_신민아_84ms {
	static StringBuilder sb;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int size = Integer.parseInt(br.readLine());
		int[][] area = new int[size][size];
		
		sb = new StringBuilder();
		for(int i=0;i<size;i++) {
			String line = br.readLine();
			for(int j=0;j<size;j++) {
				area[i][j] = line.charAt(j) - '0';
			}
		}
		
		getResult(area, size, 0, 0);
		
		System.out.print(sb.toString());
	}
	
	private static void getResult(int[][] area, int size, int startR, int startC) {
		if(size == 1 || isAllSpaceSame(area, size, startR, startC)) {
			sb.append(area[startR][startC]);
			return;
		}
		
		sb.append("(");
		getResult(area, size/2, startR, startC);
		getResult(area, size/2, startR, startC + size/2);
		getResult(area, size/2, startR + size/2, startC);
		getResult(area, size/2, startR + size/2, startC + size/2);
		sb.append(")");
	}
	
	private static boolean isAllSpaceSame(int[][] area, int size, int startR, int startC) {
		
		int firstValue = area[startR][startC];
		
		for(int i=startR;i<startR+size;i++) {
			for(int j=startC;j<startC+size;j++) {
				if(firstValue != area[i][j]) {
					return false;
				}
			}
		}
		
		return true;
	}

}
