package boj_0322;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_11660_구간합구하기_S1_신민아_764ms {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int size = Integer.parseInt(st.nextToken());
		int operationCount = Integer.parseInt(st.nextToken());
		
		int[][] numbers = new int[size + 1][size + 1];
		int[][] sum = new int[size + 1][size + 1];
		
		for(int i=1;i<numbers.length;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=1;j<numbers.length;j++) {
				numbers[i][j] = Integer.parseInt(st.nextToken());
				sum[i][j] = numbers[i][j];
				
				if(i > 1) // r좌표가 1보다 크면 이전까지의 sum을 더해준다
					sum[i][j] += sum[i-1][j];
				if(j > 1) // c좌표가 1보다 크면 이전까지의 sum을 더해준다
					sum[i][j] += sum[i][j-1];
				if(i > 1 && j > 1) // 둘 다 1보다 클 때 두번 더해지는 영역이 있으므로 그 구간을 빼준다
					sum[i][j] -= sum[i-1][j-1];
			}
		}
		
		StringBuilder sb = new StringBuilder();
		int x1, y1, x2, y2;
		for(int i=0;i<operationCount;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			x1 = Integer.parseInt(st.nextToken()) - 1; // 영역에 포함되지 않은 구간을 빼주기 위해 -1을 미리 함
			y1 = Integer.parseInt(st.nextToken()) - 1;
			
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());
			sb.append(sum[x2][y2] - sum[x1][y2] - sum[x2][y1] + sum[x1][y1]).append("\n");
		}
		
		System.out.print(sb.toString());
		
	}

}
