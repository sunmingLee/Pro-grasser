import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_SWEA_1225_암호생성기_D3_이재순_103ms {
	public static void main(String[] args) throws IOException {
		long startTime = System.currentTimeMillis();
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader	br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		Queue<Integer> q = new ArrayDeque<>();
		int temp;
		int min;
		for (int i = 0; i < 10; i++) {
			min = Integer.MAX_VALUE;
			sb.append("#").append(br.readLine().trim()).append(" ");
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 8; j++) {
				temp = Integer.parseInt(st.nextToken());
				min = Integer.min(min, temp/15);
				q.offer(temp);
			}
			min = min*15-15;
			for (int j = 0; j < 8; j++) {
				q.offer(q.poll()-min);
			}
			loop:
			while (true) {
				for (int j = 1; j < 6; j++) {
					temp = q.poll()-j;
					if (temp>0) {
						q.offer(temp);
					}
					else {
						q.offer(0);
						break loop;
					}
				}
			}
			for (Integer integer : q) {
				sb.append(integer).append(" ");
			}
			q.clear();
			sb.append("\n");
		}
		System.out.println(sb);
		System.out.println((System.currentTimeMillis()-startTime)/1000.0);
	}
}
