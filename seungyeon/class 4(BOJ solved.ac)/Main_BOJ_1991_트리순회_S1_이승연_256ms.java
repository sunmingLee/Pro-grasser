import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BOJ_1991_트리순회_S1_이승연_256ms {
	private static StringBuilder sb;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 노드의 개수 (1<=N<=26)
		char[] tree = new char[(int) Math.pow(2, N+1)];
		Arrays.fill(tree, '.');
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		tree[1] = st.nextToken().charAt(0);
		tree[2] = st.nextToken().charAt(0);
		tree[3] = st.nextToken().charAt(0);
		
		for(int i=2; i<=N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int idx = 0;
			char c = st.nextToken().charAt(0);
			
			for(int j=1; j<(int) Math.pow(2, N+1); j++) {
				if(tree[j] == c) {
					idx = j;
					break; 
				}
			}
			
			tree[2*idx] = st.nextToken().charAt(0);
			tree[2*idx+1] = st.nextToken().charAt(0);
		}
		
		sb = new StringBuilder();
		
		prefix(1, tree);
		sb.append("\n");
		
		infix(1, tree);
		sb.append("\n");
		
		postfix(1, tree);
		sb.append("\n");
		
		System.out.print(sb.toString());
	}	
	
	public static void prefix(int s_idx, char[] tree) { // 전위 
		sb.append(tree[s_idx]);
		
		if(tree[2*s_idx] != '.') prefix(2*s_idx, tree);
		if(tree[2*s_idx+1] != '.') prefix(2*s_idx+1, tree);
	}
	
	public static void infix(int s_idx, char[] tree) { // 중위 
		if(tree[2*s_idx] != '.') infix(2*s_idx, tree);
		sb.append(tree[s_idx]);
		if(tree[2*s_idx+1] != '.') infix(2*s_idx+1, tree);
	}
	
	public static void postfix(int s_idx, char[] tree) { // 후위
		if(tree[2*s_idx] != '.') postfix(2*s_idx, tree);
		if(tree[2*s_idx+1] != '.') postfix(2*s_idx+1, tree);
		sb.append(tree[s_idx]);
	}
	
}
