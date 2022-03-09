package Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BOJ_1991_트리순회_S1_이선민_80ms {
	static class Node {
		char left; // 왼쪽자식
		char right; // 오른쪽자식

		public Node(char left, char right) {
			super();
			this.left = left;
			this.right = right;
		}
	} // end of Node class


	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 노드의 개수(1 ≤ N ≤ 26)
		Node[] tree = new Node[N + 'A']; // 이진트리
		for (int i = 0; i < N; i++) {
			String temp = br.readLine().replace(" ", "");
			char parent = temp.charAt(0); // 부모노드
			char left = temp.charAt(1); // 왼쪽자식노드
			char right = temp.charAt(2); // 오른쪽자식노드
			tree[parent] = new Node(left, right);
		}


		StringBuilder sb = new StringBuilder();
		preorder(tree, 'A', sb); // 전위순회
		sb.append("\n");

		inorder(tree, 'A', sb); // 중위순회
		sb.append("\n");

		postorder(tree, 'A', sb); // 후위순회
		sb.append("\n");

		System.out.print(sb.toString());

	} // end of main

	/**
	 * 후위 순회 : (왼쪽 자식) (오른쪽 자식) (루트)
	 */
	private static void postorder(Node[] tree, char root, StringBuilder sb) {
		if (tree[root].left != '.') { // 왼쪽 자식이 있는 경우
			postorder(tree, tree[root].left, sb);
		}

		if (tree[root].right != '.') { // 오른쪽 자식이 있는 경우
			postorder(tree, tree[root].right, sb);
		}

		// 더이상 자식이 없으면
		sb.append(root);
	} // end of postorder

	/**
	 * 중위 순회 : (왼쪽 자식) (루트) (오른쪽 자식)
	 */
	private static void inorder(Node[] tree, char root, StringBuilder sb) {
		if (tree[root].left != '.') { // 왼쪽 자식이 있는 경우
			inorder(tree, tree[root].left, sb);
		}
		// 더이상 왼쪽 자식이 없으면
		sb.append(root);

		if (tree[root].right != '.') { // 오른쪽 자식이 있는 경우
			inorder(tree, tree[root].right, sb);
		}
	} // end of inorder

	/**
	 * 전위 순회 : (루트) (왼쪽 자식) (오른쪽 자식)
	 */
	private static void preorder(Node[] tree, char root, StringBuilder sb) {
		sb.append(root);

		if (tree[root].left != '.') { // 왼쪽 자식이 있는 경우
			preorder(tree, tree[root].left, sb);
		}

		if (tree[root].right != '.') { // 오른쪽 자식이 있는 경우
			preorder(tree, tree[root].right, sb);
		}

	} // end of preorder
} // end of class
