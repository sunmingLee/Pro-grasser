package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 1부터 n까지의 수를 스택에 넣었다가 뽑아 늘어놓음으로써, 하나의 수열을 만들 수 있다. 이때, 스택에 push하는 순서는 반드시
 * 오름차순을 지키도록 한다고 하자. 임의의 수열이 주어졌을 때 스택을 이용해 그 수열을 만들 수 있는지 없는지, 있다면 어떤 순서로
 * push와 pop 연산을 수행해야 하는지를 알아낼 수 있다. 이를 계산하는 프로그램을 작성하라.
 *
 */
public class Main_BOJ_1874_스택수열_S3_이선민_376ms {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine()); // (1 ≤ n ≤ 100,000)

		Stack<Integer> stack = new Stack<Integer>();
		int input = Integer.parseInt(br.readLine()); // 현재 pop해야 하는 숫자
		int cnt = 0; // stack에서 꺼낸 숫자의 개수
		for (int i = 1; i <= n; i++) {
			stack.push(i);
			sb.append("+\n");

			while (!stack.empty() && input == stack.peek()) {
				sb.append("-\n");
				stack.pop();
				cnt++;

				if (cnt >= n) {
					break;
				}

				input = Integer.parseInt(br.readLine());
			}

		}

		if (stack.empty()) {
			System.out.print(sb);
		} else {
			System.out.println("NO");
		}

	} // end of main

} // end of class
