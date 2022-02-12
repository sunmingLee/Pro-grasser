import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_SWEA_1225_암호생성기_D3_이선민_128ms {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str;
		StringTokenizer st;
		Queue<Integer> q = new LinkedList<Integer>();
		int T = 0;

		while ((str = br.readLine()) != null && !str.isEmpty()) {
			st = new StringTokenizer(str, " ");
			if (st.countTokens() == 1) {
				T = Integer.parseInt(st.nextToken()); // 테스트케이스 번호
				sb.append("#").append(T).append(" ");
				continue;
			}

			while (st.hasMoreTokens()) {
				q.add(Integer.parseInt(st.nextToken()));
			}

			// 개선방안 1.
			// 주어지는 각 수는 integer 범위를 넘지 않는다.
			// 8 cycle을 돌면 모든 숫자가 15씩 감소됨.
			// 15*n 만큼 미리 빼두고 시작하면 연산 횟수를 줄일 수 있음.
			
			// 개선방안 2.
			// 큐가 아닌 배열을 이용하여 계산한 숫자를 뒤로 보내는 대신, 마지막 숫자를 가리키는 인덱스를 저장해서 queue를 사용할때의 메모리 낭비를 줄일 수 있다.
			
			int min = q.peek();
			for (Integer integer : q) {
				min = integer < min ? integer : min;
			}

			outer: while (true) {
				// cycle
				for (int i = 1; i <= 5; i++) {
					// 숫자를 감소시킬 때 0 이하일 경우
					if (q.peek() - i <= 0) {
						q.poll();
						q.add(0);
						break outer;
					}

					q.add(q.poll() - i);
				}
			}

			for (Integer integer : q) {
				sb.append(integer).append(" ");
			}
			sb.append("\n");

			q.clear();
		} // end of while

		System.out.print(sb);
	} // end of main

} // end of class
