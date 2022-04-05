package DivideAndConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_2263_트리의순회_G2_이선민_1900ms {

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); // 노드의 개수(1 ≤ n ≤ 100,000)
		if(n==1) {
			System.out.print(1);
			return;
		}
		int[] inorder = new int[n + 1]; // 인오더
		int[] postorder = new int[n + 1]; // 포스트오더
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= n; i++) {
			inorder[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= n; i++) {
			postorder[i] = Integer.parseInt(st.nextToken());
		}

		post(n, inorder, postorder, 1, n, 1, n);

		System.out.print(sb.toString());
	} // end of main

	private static void post(int n, int[] inorder, int[] postorder, int inStart, int inEnd, int postStart,
			int postEnd) {
		if (postStart == postEnd) {
			sb.append(postorder[postStart]).append(" ");
			return;
		}

		int root = postorder[postEnd];
		sb.append(root).append(" ");

		int leftCnt = 0;
		int right = -1;
		for (int i = inStart; i <= inEnd; i++) {
			if (inorder[i] == root) {
				right = i + 1;
				break;
			}
			leftCnt++;
		}

		if (leftCnt > 0) {
			post(n, inorder, postorder, inStart, inStart + leftCnt - 1, postStart, postStart + leftCnt - 1); // 왼쪽 분할정복
		}
		if(right<=inEnd) {
			post(n, inorder, postorder, right, inEnd, postStart + leftCnt, postEnd - 1); // 오른쪽 분할정복
		}

	} // end of post

} // end of class
