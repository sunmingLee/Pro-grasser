package Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 아기 석환이는 자연수가 쓰여진 카드를 n장 갖고 있다. 처음에 i번 카드엔 ai가 쓰여있다. 카드 합체 놀이는 이 카드들을 합체하며 노는
 * 놀이이다. 카드 합체는 다음과 같은 과정으로 이루어진다.
 * 
 * x번 카드와 y번 카드를 골라 그 두 장에 쓰여진 수를 더한 값을 계산한다. (x ≠ y) 계산한 값을 x번 카드와 y번 카드 두 장
 * 모두에 덮어 쓴다. 이 카드 합체를 총 m번 하면 놀이가 끝난다. m번의 합체를 모두 끝낸 뒤, n장의 카드에 쓰여있는 수를 모두 더한
 * 값이 이 놀이의 점수가 된다.
 * 
 * 이 점수를 가장 작게 만드는 것이 놀이의 목표이다.
 */
public class Main_BOJ_15903_카드합체놀이_S2_이선민_476ms {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); // 카드의 개수(2 ≤ n ≤ 1,000)
		int m = Integer.parseInt(st.nextToken()); // 카드 합체 횟수(0 ≤ m ≤ 15×n)

		// 카드 상태를 담을 배열
//		최악의 경우 카드 1000장이 모두 카드의 최댓값인 1,000,000을 가지고 있다면
//		m이 15000이 되기 때문에 합이 15000*1,000,000 = 150억 이 될수 있다.
//		이는 int 범위를 넘기 때문에 long으로 정해줌
		long[] cards = new long[n]; 
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			cards[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < m; i++) {
			Arrays.sort(cards); // 오름차순 정렬
			// 가장 작은 두 수 더해서 덮어쓰기
			cards[0] = cards[0] + cards[1];
			cards[1] = cards[0];
		}

		long sum = 0;
		for (long l : cards) {
			sum += l;
		}

		System.out.println(sum);
	}

}
