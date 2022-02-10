package implement;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_18111_마인크래프트_S2_신민아_612ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int x = Integer.parseInt(st.nextToken()); // 땅의 가로
		int y = Integer.parseInt(st.nextToken()); // 땅의 세로
		int inventory = Integer.parseInt(st.nextToken()); // 인벤토리에서 갖고있는 블록의 개수
		int minTime = Integer.MAX_VALUE; // 가장 적게걸리는 시간
		int maxHeight = 0; // 작업 후 땅의 높이
		
		// 땅의 정보, 땅의 높이 중 최소,최대 높이
		int[][] area = new int[x][y];
		int minAreaHeight = Integer.MAX_VALUE;
		int maxAreaHeight = 0;
		
		// 땅의 높이에 대한 데이터를 2차원 배열에 넣어주기
		for(int i=0;i<x;i++) {
			String heights = br.readLine();
			st = new StringTokenizer(heights);
			for(int j=0;j<y;j++) {
				area[i][j] = Integer.parseInt(st.nextToken());
				if(minAreaHeight > area[i][j]) {
					minAreaHeight = area[i][j];
				}
				
				if(maxAreaHeight < area[i][j]) {
					maxAreaHeight = area[i][j];
				}
			}
		}
		
		for(int height = minAreaHeight;height<=maxAreaHeight;height++) {
			int time = calcWorkTime(height, inventory, area);
			if(minTime > time) {
				minTime = time;
				maxHeight = height;
			} else if(minTime == time) {
				if(maxHeight < height)
					maxHeight = height;
			}
		}
		
		System.out.print(minTime + " " + maxHeight);
	}
	
	// 모든 height에 따라 걸리는 시간을 계산하는 함수
	private static int calcWorkTime(int height, int inventory, int[][] area) {
		int time = 0;
		
		for(int i=0;i<area.length;i++) {
			for(int j=0;j<area[0].length;j++) {
				int diff = Math.abs(height - area[i][j]);
				if(height > area[i][j]) {
					time += diff;
					inventory -= diff;
				} else if(height < area[i][j]) {
					time += 2*diff;
					inventory += diff;
				}
			}
		}
		
		if(inventory < 0)
			return Integer.MAX_VALUE;
		
		return time;
	}
}
