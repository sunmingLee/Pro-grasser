package boj_0310;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BOJ_1991_트리순회_S1_신민아_80ms {
	static StringBuilder sb = new StringBuilder();

	// 이진트리이므로 left, right 설정
	static class Node {
		char name;
		Node left, right;

		public Node(char name) {
			this.name = name;
		}

		public String toString() {
			return name + " ";
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int edges = Integer.parseInt(br.readLine());
		Node[] nodes = new Node[edges]; // 알파벳이 순서대로 나온다는 보장o
		
		// 정점의 개수만큼 반복
		for (int i = 0; i < edges; i++) {
			char[] children = br.readLine().replace(" ", "").toCharArray(); // 공백 제거 후 char 배열
			
			int root = children[0] - 'A'; // 가장 처음 원소가 root

			if (nodes[root] == null) { // 루트 원소가 생성되지 않았을 경우
				nodes[root] = new Node(children[0]); // 객체 생성
			}

			if (children[1] != '.') { // 왼쪽 자식이 있다면
				nodes[root].left = new Node(children[1]); // 왼쪽 자식 객체 생성
				nodes[children[1] - 'A'] = nodes[root].left; // 왼쪽 자식 index에 이미 만들어진 왼쪽 자식 객체 할당 
			}

			if (children[2] != '.') { // 오른쪽 자식이 있다면
				nodes[root].right = new Node(children[2]); // 오른쪽 자식 객체 생성
				nodes[children[2] - 'A'] = nodes[root].right; // 오른쪽 자식 index에 이미 만들어진 오른쪽 자식 객체 할당
			}
		}

		preOrder(nodes[0]); // 전위 순회
		sb.append("\n");

		inOrder(nodes[0]); // 중위 순회
		sb.append("\n");

		postOrder(nodes[0]); // 후위 순회

		System.out.print(sb.toString());
	}

	static private void preOrder(Node node) {
		sb.append(node.name); // 루트 출력
		if (node.left != null)
			preOrder(node.left);
		if (node.right != null)
			preOrder(node.right);
	}

	static private void inOrder(Node node) {
		if (node.left != null)
			inOrder(node.left);
		sb.append(node.name); // 루트 출력
		if (node.right != null)
			inOrder(node.right);

	}

	static private void postOrder(Node node) {
		if (node.left != null)
			postOrder(node.left);
		if (node.right != null)
			postOrder(node.right);
		sb.append(node.name); // 루트 출력

	}

}
