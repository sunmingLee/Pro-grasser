package boj_0315;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// idea : 최대값을 들고다니는 dp 배열은 마지막 줄에서 나타날 수 있는 최대/최소값(시작점 아님)
// 각 위치에 따라 0, 1번과 0, 1, 2번 / 1, 2번 자리 비교
public class Main_BOJ_2096_내려가기_G4_신민아_644ms {
	static class Pair {
		int min;
		int max;
		
		public Pair(int min, int max) {
			this.min = min;
			this.max = max;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count = Integer.parseInt(br.readLine());
		
		int[] max = new int[3]; // 각 칸 별 최대값
		int[] min = new int[3]; // 각 칸 별 최솟값
		int[] cur = new int[3]; // 현재 라인의 3개의 숫자
		
		// 맨 첫번째 라인 초기화
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=0;i<3;i++) {
			int num = Integer.parseInt(st.nextToken());
			max[i] = num;
			min[i] = num;
		}
		
		int[][] offset = {{0, 1}, {0, 2}, {1, 2}};
		int[] tempMax = new int[3];
		int[] tempMin = new int[3];
		
		// 둘째 줄부터 최대,최소값 찾기
		for(int i=1;i<count;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int c=0;c<3;c++) {
				cur[c] = Integer.parseInt(st.nextToken());
			}
			
			for(int c=0;c<3;c++) {
				Pair pair = getMaxMin(max, min, offset[c]);
				tempMax[c] = pair.max + cur[c];
				tempMin[c] = pair.min + cur[c];
			}
			
			for(int c=0;c<3;c++) {
				max[c] = tempMax[c];
				min[c] = tempMin[c];
			}
		}
		
		System.out.print(Arrays.stream(max).max().getAsInt() + " " + Arrays.stream(min).min().getAsInt());
	}
	
	private static Pair getMaxMin(int[] max, int[] min, int[] offset) {
		int diff = offset[1] - offset[0];
		
		if(diff == 1)
			return new Pair(Math.min(min[offset[0]], min[offset[1]]), Math.max(max[offset[0]], max[offset[1]]));
		
		return new Pair(Arrays.stream(min).min().getAsInt(), Arrays.stream(max).max().getAsInt());
	}
}
