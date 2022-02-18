import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_JO_1828_냉장고_이재순_95ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[1]<o2[1]) {
					return -1;
				}else if (o1[1]>o2[1]) {
					return 1;
				}
				else return 0;
			}
		});
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			pq.offer(new int[] {Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()) });
		}
		int ans=0;
		while (!pq.isEmpty()) {
			int a = pq.poll()[1];
			while(!pq.isEmpty()&&pq.peek()[0]<=a) {
				pq.poll();
			}
			ans++;
		}
		System.out.println(ans);
	}
}
