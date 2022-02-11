import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution_BOJ_2493_탑_G5_이재순_600ms {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		sb.append(0).append(" ");//첫 타워는 무조건 0
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		Stack<int[]> stack = new Stack<int[]>();
		stack.push(new int[] {1,Integer.parseInt(st.nextToken())});//첫 타워 정보 push
		int temp;//타워의 높이 임시 저장
		/*새로운 타워가 저장된 스택의 타워보다 높다면 저장된 스택을 pop
		    낮다면 저장된 스택의 번호 append 후 push
		   stack이 비어있다면 나온 타워중 가장 높으므로 0 append*/
		for (int i = 2; i <= N; i++) {
			temp =Integer.parseInt(st.nextToken());
			//새로운 타워가 스택에 저장된 타워보다 낮을때까지 pop 
			while (!stack.empty()) {
				if (temp<stack.peek()[1]) {
					sb.append(stack.peek()[0]).append(" ");
					break;
				}
				stack.pop();
			}
			if (stack.empty()) sb.append(0).append(" ");
			stack.push(new int[] {i, temp});
		}
		System.out.print(sb);
	}//end of main
}//end of class