package boj_0322;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_11660_구간합구하기_S1_신민아_1244ms {

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
				if(i > 1) // r이 1 이상이면 이전 row의 값을 더해줌
					sum[i][j] += sum[i-1][j];
				for(int temp=1;temp<=j;temp++) // 현재 행까지의 값을 더해줌
					sum[i][j] += numbers[i][temp];
			}
		}
		
		StringBuilder sb = new StringBuilder();
		int x1, y1, x2, y2;
		for(int i=0;i<operationCount;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			x1 = Integer.parseInt(st.nextToken()) - 1; // x1, y1의 좌표는 값을 빼기위해 필요하므로 포함되지 않은 영역을 빼기 위해 -1씩 빼준다
			y1 = Integer.parseInt(st.nextToken()) - 1;
			
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());
			sb.append(sum[x2][y2] - sum[x1][y2] - sum[x2][y1] + sum[x1][y1]).append("\n");
		}
		
		System.out.print(sb.toString());
		
	}

}
