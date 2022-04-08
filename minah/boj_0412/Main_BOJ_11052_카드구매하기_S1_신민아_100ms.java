package boj_0412;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_11052_카드구매하기_S1_신민아_100ms {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cardPackCount = Integer.parseInt(br.readLine());
		int[] maxCardPay = new int[cardPackCount+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=1;i<maxCardPay.length;i++) {
			maxCardPay[i] = Math.max(getMaxFromPrevious(maxCardPay, i), Integer.parseInt(st.nextToken()));
		}
		
		System.out.print(maxCardPay[cardPackCount]);
	}
	
	private static int getMaxFromPrevious(int[] card, int index) {
		int lastIndex = index / 2 + 1;
		int max = 0;
		
		for(int i=0;i<lastIndex;i++) {
			max = Math.max(max, card[i] + card[index-i]);
		}
		
		return max;
	}

}
