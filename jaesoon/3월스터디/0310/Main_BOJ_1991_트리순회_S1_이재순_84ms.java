import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BOJ_1991_트리순회_S1_이재순_84ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Node[] nodes = new Node[91];
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			nodes[line.charAt(0)] = new Node();
			char temp;
			if ((temp = line.charAt(2))!='.') nodes[line.charAt(0)].left = temp;
			if ((temp = line.charAt(4))!='.') nodes[line.charAt(0)].right = temp;
		}
		StringBuilder sb = new StringBuilder();
		preorder(nodes, 'A', sb);
		sb.append("\n");
		inorder(nodes, 'A', sb);
		sb.append("\n");
		postorder(nodes, 'A', sb);
		System.out.println(sb);
	}
	private static void preorder(Node[] nodes, char cur, StringBuilder sb) {
		sb.append(cur);
		if (nodes[cur].left!=0) preorder(nodes, nodes[cur].left, sb);
		if (nodes[cur].right!=0) preorder(nodes, nodes[cur].right, sb);
	}
	private static void inorder(Node[] nodes, char cur, StringBuilder sb) {
		if (nodes[cur].left!=0) inorder(nodes, nodes[cur].left, sb);
		sb.append(cur);
		if (nodes[cur].right!=0) inorder(nodes, nodes[cur].right, sb);
	}
	private static void postorder(Node[] nodes, char cur, StringBuilder sb) {
		if (nodes[cur].left!=0) postorder(nodes, nodes[cur].left, sb);
		if (nodes[cur].right!=0) postorder(nodes, nodes[cur].right, sb);
		sb.append(cur);
	}
	static class Node {
		char left, right;
	}
}
