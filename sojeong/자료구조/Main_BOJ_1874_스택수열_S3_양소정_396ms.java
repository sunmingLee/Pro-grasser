import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
1부터 n까지의 수를 스택에 넣었다가 뽑아 늘어놓음으로써, 하나의 수열을 만들 수 있다. 
이때, 스택에 push하는 순서는 반드시 오름차순을 지키도록 한다고 하자. 
임의의 수열이 주어졌을 때 스택을 이용해 그 수열을 만들 수 있는지 없는지, 있다면 어떤 순서로 push와 pop 연산을 수행해야 하는지를 알아낼 수 있다. 이를 계산하는 프로그램을 작성하라.*/

public class Main_BOJ_1874_스택수열_S3_양소정_396ms {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();	
		int n = Integer.parseInt(br.readLine());//수열의 크기
		Stack<Integer> stack = new Stack<Integer>();
		int start = 0;
		for(int a = 0; a<n; a++) {
			int var = Integer.parseInt(br.readLine()); //push해야 될 값
			
			if(var > start) { //push 해야될 값보다 작다면 그 이하 값까지 다 push
				for(int i = start + 1; i<= var; i++) {
					stack.push(i);
					sb.append("+").append("\n");
				}
				start = var; //다음 값으로 초기화
			}else if(stack.peek()!=var) {
				System.out.println("NO");
				return;
			}
			stack.pop();
			sb.append("-").append("\n");
		}
		
		System.out.println(sb);
	}
}


