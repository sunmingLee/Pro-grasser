import java.io.BufferedReader;
//import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main_BOJ_5639_이진검색트리_G5_이재순_140ms {
	static BufferedReader br;
	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("input.txt"));
		br = new BufferedReader(new InputStreamReader(System.in));
		Node node = new Node(Integer.parseInt(br.readLine()));
		makeTree(node, 1000000, 1000000);
		StringBuilder sb = new StringBuilder();
		postorder(node, sb);
		System.out.print(sb);
	}
	private static void postorder(Node node, StringBuilder sb) {
		if (node.left!=null) postorder(node.left, sb);
		if (node.right!=null) postorder(node.right, sb);
		sb.append(node.weight).append("\n");
	}
	
	private static int makeTree(Node node, int parent, int root) throws Exception {
		String line = br.readLine();
		if (line == null) {
			return -1;
		}
		int temp = Integer.parseInt(line);
		int flag;
		for (int i = 0; i < 2; i++) {
			if (temp < node.weight) {
				node.left = new Node(temp);
				flag = makeTree(node.left, node.weight, node.weight);
				if (flag != -1) {
					temp = flag;
					continue;
				}
				return -1;
			}
			else if (temp<parent||(temp>parent&&temp<root)) {
				node.right = new Node(temp);
				return makeTree(node.right,node.weight, root);
			}
			else {
				return temp;
			}
		}
		return -1;
	}
	
	
	static class Node {
		int weight;
		Node left, right;
		public Node(int weight) {
			this.weight = weight;
		}
	}
}
