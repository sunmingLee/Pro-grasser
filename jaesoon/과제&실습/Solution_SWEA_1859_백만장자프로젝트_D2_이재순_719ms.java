import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution_SWEA_1859_백만장자프로젝트_D2_이재순_719ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			Stack<Integer> stack = new Stack<Integer>();
			for (int i = 0; i < N; i++) stack.add(Integer.parseInt(st.nextToken()));
			long ans = 0;
			int max = 0;
			for (int i = 0, temp; i < N; i++) {
				temp = stack.pop();
				if (temp>max) max = temp;
				else ans += max-temp;
			}
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.print(sb);
	}
}
