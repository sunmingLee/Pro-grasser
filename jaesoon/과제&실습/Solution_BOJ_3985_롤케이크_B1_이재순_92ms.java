import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_BOJ_3985_롤케이크_B1_이재순_92ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int L = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine())+1;
		StringTokenizer st;
		int[] cake = new int[L+1], getCake = new int[N];
		int maxGreed = -1, maxGet = 0, greedyPerson = 0, luckyPerson = 0;
		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			if (end-start>maxGreed) {
				maxGreed = end-start;
				greedyPerson = i;
			}
			for (int j = start; j <= end; j++) {
				if (cake[j]==0) {
					cake[j] = i;
					getCake[i]++;
				}
			}
			if (getCake[i]>maxGet) {
				maxGet = getCake[i];
				luckyPerson = i;
			}
		}
		StringBuilder sb = new StringBuilder();
		System.out.println(sb.append(greedyPerson).append("\n").append(luckyPerson));
		
	}
}
