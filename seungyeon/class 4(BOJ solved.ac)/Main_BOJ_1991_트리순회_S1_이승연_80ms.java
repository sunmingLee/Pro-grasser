import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BOJ_1991_트리순회_S1_이승연_80ms {
	private static StringBuilder sb;

	static class Node {
		char value; 
		Node left; 
		Node right;
		
		public Node(char value) {
			super();
			this.value = value;
		}
	}
	
	public static void putNode(Node root, char data, char leftData, char rightData) {
		if(root == null) {
			return;
		} else if(root.value == data) {
			if(leftData != '.') root.left = new Node(leftData);
			if(rightData != '.') root.right = new Node(rightData);
		} else {
			putNode(root.left, data, leftData, rightData);
			putNode(root.right, data, leftData, rightData);
		}
	}
		
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 노드의 개수 (1<=N<=26)
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		Node root = new Node(st.nextToken().charAt(0)); 
		char root_left = st.nextToken().charAt(0); 
		char root_right = st.nextToken().charAt(0); 
		
		if(root_left != '.') {
			root.left = new Node(root_left);
		}
		if(root_right != '.') {
			root.right = new Node(root_right);
		}
		
		for(int i=1; i<N; i++){
			st = new StringTokenizer(br.readLine(), " ");
			putNode(root, st.nextToken().charAt(0), st.nextToken().charAt(0), st.nextToken().charAt(0));
		}
		
		sb = new StringBuilder();
		
		prefix(root);
		sb.append("\n");
		infix(root);
		sb.append("\n");
		postfix(root);
		
		System.out.print(sb.toString());
	}	
	
	public static void prefix(Node root) { // 전위 
		sb.append(root.value);
		
		if(root.left != null) prefix(root.left);
		if(root.right != null) prefix(root.right);
	}
	
	public static void infix(Node root) { // 중위 
		if(root.left != null) infix(root.left);
		sb.append(root.value);
		if(root.right != null) infix(root.right);
	}
	
	public static void postfix(Node root) { // 후위
		if(root.left != null) postfix(root.left);
		if(root.right != null) postfix(root.right);
		sb.append(root.value);
	}
	
}
