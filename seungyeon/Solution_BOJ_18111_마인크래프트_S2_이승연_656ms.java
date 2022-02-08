package algo_study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_BOJ_18111_마인크래프트_S2_이승연_656ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int r_num = Integer.parseInt(st.nextToken()); // N
		int c_num = Integer.parseInt(st.nextToken()); // M
		int inventory = Integer.parseInt(st.nextToken()); // B
		
		int[][] ground = new int[r_num][c_num]; // 땅 높이
		
		int height_min = Integer.MAX_VALUE; // 해당 땅에서 가장 낮은 높이 
		int height_max = Integer.MIN_VALUE; // 해당 땅에서 가장 높은 높이
		int result = Integer.MAX_VALUE; // 땅을 고르는데 걸리는 최소 시간 
		int result_height = 0; // 그때의 땅 높이 
		
		// 땅 높이, 가능한 땅 높이 초기화 
		for(int i=0; i<r_num; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			for(int j=0; j<c_num; j++) {
				int height_temp = Integer.parseInt(st.nextToken());
				ground[i][j] = height_temp;
				if(height_temp > height_max) {
					height_max = height_temp;
				} else if(height_temp < height_min){
					height_min = height_temp;
				}
			}
		}
		
		// 가능한 땅 높이에 대해서 경우의 수 따지기 
		for(int h=height_min; h<=height_max; h++) {
			int plus = 0;
			int minus = 0;
			
			for(int r=0; r<r_num; r++) {
				for(int c=0; c<c_num; c++) {
					int diff = ground[r][c] - h; // 지금 따지는 경우에의 높이와의 차이 
					if(diff < 0) { // 더 적으면 -> 블록을 놔줘야함 
						minus += -diff;
					} else { // 더 많으면  -> 블록을 빼야함 
						plus += diff;
					}
				}
			}
			
			
			// 놓을 수 있는 블록 수 = 뺀 블록 수 + 인벤토리에 있던 블록 
			if(minus <= inventory+plus) {
				int result_temp = minus + 2*plus; // 블록 놓기: 1초, 블록 제거: 2초  
				
				if(result > result_temp) { // 최소 시간, 최소라면 그때의 높이 저장  
					result = result_temp;
					result_height = h;
				} else if(result == result_temp){ // 같으면, 높이가 더 높은 것으로 
					if(result_height < h) {
						result_height = h;
					}
				}
			}
		}
		
		System.out.print(result+" "+result_height);
	}
}
