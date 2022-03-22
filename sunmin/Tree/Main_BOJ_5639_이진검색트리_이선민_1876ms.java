package Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_BOJ_5639_이진검색트리_이선민_1876ms {
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s;
		Stack<Integer> inorder = new Stack<Integer>();
		int index = 0;
		while ((s = br.readLine()) != null && !s.equals("")) {
			inorder.add(Integer.parseInt(s));
		}
		post(inorder, 0, inorder.size() - 1);
		System.out.print(sb.toString());

	} // end of main

	private static void post(Stack<Integer> inorder, int start, int end) {
		if (start > end) {
//			sb.append(inorder.get(start)).append("\n");
			return;
		}
		int root = inorder.get(start);
		int right = start + 1;
		while(right<=end && inorder.get(right)< root) {
			right++;
		}
//		for (int i = start + 1; i <= end; i++) {
//			if (inorder.get(i) > root) {
//				right = i;
//				break;
//			}
//		}

		post(inorder, start + 1, right - 1); // 왼쪽 트리
		post(inorder, right, end); // 오른쪽 트리
		sb.append(root).append("\n");
//		if (right > start + 1 || right == -1) {
//			post(inorder, start + 1, right - 1); // 왼쪽 트리
//		}
//		if (right != -1) {
//			post(inorder, right, end); // 오른쪽 트리
//		}
//		sb.append(root).append("\n");

	} // end of post

} // end of class
