package boj_0317;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// idea : 슬라이딩 윈도우를 사용해보면 어떨까..? --> 그렇게 되면 배열 내의 값을 swap 해줘야하므로 테스트 필요
// idea2 : 정보를 받아서 처리할 필요 없이 즉각즉각 받아서도 처리가 가능할듯
public class Main_BOJ_9465_스티커_S1_신민아_880ms {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		
		StringTokenizer st1; // 첫 라인용 stringtokenizer
		StringTokenizer st2; // 두번째 라인용
		int[][] stickers; // 스티커 정보 저장
		int[][] max; // 최대값 저장
		for(int t=1;t<=TC;t++) { // 테케만큼 수행
			int count = Integer.parseInt(br.readLine()); // 스티커의 길이
			
			stickers = new int[count][2]; // 스티커의 길이만큼 스티커 정보 저장
			max = new int[count][2]; // max값 저장용 dp
			
			st1 = new StringTokenizer(br.readLine(), " ");
			st2 = new StringTokenizer(br.readLine(), " ");
			for(int i=0;i<count;i++) { // 스티커 정보 저장
				stickers[i][0] = Integer.parseInt(st1.nextToken());
				stickers[i][1] = Integer.parseInt(st2.nextToken());
			}
			
			max[0][0] = stickers[0][0]; // 맨 처음 있는 스티커 저장
			max[0][1] = stickers[0][1];
			
			if(count > 1) { // 스티커가 두 줄 이상 있으면 2번째 줄도 max값 저장
				max[1][0] = max[0][1] + stickers[1][0];
				max[1][1] = max[0][0] + stickers[1][1];
			}
			
			for(int i=2;i<count;i++) { // 스티커 위치 별로 뜯었을 때 가장 최댓값 계산
				max[i][0] = Math.max(max[i-1][1], max[i-2][1]) + stickers[i][0];
				max[i][1] = Math.max(max[i-1][0], max[i-2][0]) + stickers[i][1];
			}
			
			sb.append(Math.max(max[count-1][0], max[count-1][1])).append("\n");
		}
		
		System.out.print(sb.toString());
	}

}
