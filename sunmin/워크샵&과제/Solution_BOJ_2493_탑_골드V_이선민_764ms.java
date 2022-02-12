import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution_BOJ_2493_탑_골드V_이선민_764ms {
	public static void main(String[] args) throws NumberFormatException, IOException {
		long beforeTime = System.currentTimeMillis();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine()); // 탑의 수(1 <= N <= 500,000)
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		Stack<Integer> stack = new Stack<Integer>();
		Stack<Integer> index = new Stack<Integer>();
		stack.push(Integer.parseInt(st.nextToken()));
		index.push(1);
		// 맨 왼쪽 빌딩은 무조건 수신할 탑이 없음
		sb.append(0).append(" ");
		
		for (int i = 2; i <= N; i++) {
			int now = Integer.parseInt(st.nextToken()); // 현재 탑의 높이
			while (!stack.isEmpty()) {

				// 왼쪽에 현재보다 더 높은 탑이 있다면 해당 탑의 위치 append
				if (stack.peek() > now) {
					sb.append(index.peek()).append(" ");
					stack.push(now);
					index.push(i);
					break;
				} else { // 오른쪽 탑이 더 높다면 왼쪽의 탑은 더이상 비교할 필요 x -> pop
					stack.pop();
					index.pop();
				}
			} // end of while

			if (stack.empty()) {
				sb.append(0).append(" ");
				stack.push(now);
				index.push(i);
			}
		} // end of for
		
		
		System.out.println(sb);

		// 아래 코드는 타임아웃됨
		// 맨 오른쪽 탑부터 확인
		/*
		 * for (int i = N - 1; i > 0; i--) { // 자신의 한칸 왼쪽 탑부터 자신보다 높은 탑이 있다면 해당 탑의 번호를
		 * append for (int j = i - 1; j >= 0; j--) { if (Integer.parseInt(s[j]) >
		 * Integer.parseInt(s[i])) { sb.append(j + 1).append(" "); break; }
		 * 
		 * if (j == 0) { sb.append(0).append(" "); } } }
		 * 
		 * // 오른쪽 탑부터 탐색했으므로 거꾸로(맨 왼쪽부터)출력 System.out.println(sb.reverse());
		 */
	} // end of main
} // end of class
