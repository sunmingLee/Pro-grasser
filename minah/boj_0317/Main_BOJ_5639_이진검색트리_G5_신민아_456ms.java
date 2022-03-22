package boj_0317;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 문제의 핵심 내용은 다음 노드가 왼쪽에 붙는지 오른쪽에 붙는지만 알면 됨
public class Main_BOJ_5639_이진검색트리_G5_신민아_456ms {
	static class Node {
		int num;
		Node left, right;
		
		Node(int num) {
			this.num = num;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		Node root = new Node(Integer.parseInt(br.readLine()));
		String line = null;
		while((line = br.readLine()) != null) {
			Node next = new Node(Integer.parseInt(line));
			addNode(root, next);
		}
		
		postOrder(sb, root);
		System.out.print(sb.toString());
		
	}
	
	private static void addNode(Node root, Node next) {
		if(root.num > next.num) { // 다음에 붙어야 할 노드가 루트보다 작으면
			if(root.left != null) {
				addNode(root.left, next); // 왼쪽 노드 중 빈곳을 재귀적으로 찾기 --> preOrder은 깊이 순으로 점점 들어가므로
			} else {
				root.left = next;
			}
		} else { // 크면
			if(root.right != null) {
				addNode(root.right, next);
			} else {
				root.right = next;
			}
		}
	}
	
	private static void postOrder(StringBuilder sb, Node next) {
		if(next == null) return;
		
		postOrder(sb, next.left);
		postOrder(sb, next.right);
		sb.append(next.num).append("\n");
	}

}
