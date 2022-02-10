import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 스택 (stack)은 기본적인 자료구조 중 하나로, 컴퓨터 프로그램을 작성할 때 자주 이용되는 개념이다. 
 * 스택은 자료를 넣는 (push) 입구와 자료를 뽑는 (pop) 입구가 같아 제일 나중에 들어간 자료가 제일 먼저 나오는 (LIFO, Last in First out) 특성을 가지고 있다.
 * 1부터 n까지의 수를 스택에 넣었다가 뽑아 늘어놓음으로써, 하나의 수열을 만들 수 있다. 
 * 이때, 스택에 push하는 순서는 반드시 오름차순을 지키도록 한다고 하자. 
 * 임의의 수열이 주어졌을 때 스택을 이용해 그 수열을 만들 수 있는지 없는지, 있다면 어떤 순서로 push와 pop 연산을 수행해야 하는지를 알아낼 수 있다. 
 * 이를 계산하는 프로그램을 작성하라.
 */

public class Solution_BOJ_1874_스택수열_S3_이승연_336ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<Integer>();
		
		int N = Integer.parseInt(br.readLine());
		
		int cur_n = 0;
		for(int i=0; i<N; i++) {
			int input_n = Integer.parseInt(br.readLine());
			// 스택이 비었거나 스택 top의 숫자가 input으로 들어온 숫자보다 작을 때 -> 전에 넣었던 숫자(cur_n)+1에서 input_n까지를 넣고 input_n(스택 top)을 뺌. 
			if(stack.isEmpty() || stack.peek()<input_n) { 
				while(cur_n != input_n) {
					stack.push(++cur_n);
					sb.append("+").append("\n");
				}
				stack.pop();
				sb.append("-").append("\n");
				
			} else if(stack.peek()==input_n){ // 스택 top과 input_n이 같을 때 -> input_n(스택 top) 뺌. 
				stack.pop();
				sb.append("-").append("\n");
			} else { // 위의 두 경우가 아니면 오류 -> 지금까지 들어온 얘들 다 빼고 "NO" 출력 
				sb.setLength(0);
				sb.append("NO");
				break;
			}
		}
		
		System.out.println(sb.toString());
	}
}
