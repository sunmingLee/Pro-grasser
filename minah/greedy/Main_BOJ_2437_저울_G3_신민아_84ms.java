package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 무게를 더할 때 작은 수부터 차례로 더하면 그 범위까지는 자연스레 만들 수 있다는 것 생각!
 * 그리디는 뭐다? 감이다
 */
public class Main_BOJ_2437_저울_G3_신민아_84ms {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count = Integer.parseInt(br.readLine());
		int[] weights = new int[count];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=0;i<count;i++) {
			weights[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(weights);

		System.out.println(getAnswer(weights));
	}
	
	private static int getAnswer(int[] weights) {
		if(weights[0] > 1) {
			return 1;
		}
		
		int sum = 1; // 이미 최소 무게가 1이 아닌 경우를 걸렀고, 전체 무게의 합에서 1을 더해야 하므로 미리 1을 더한 상태에서 시작
		
		for(int i=0;i<weights.length;i++) {
			if(sum < weights[i]) break;
			sum += weights[i];
		}
		return sum;
	}

}
