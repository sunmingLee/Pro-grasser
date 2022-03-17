package boj_0315;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_2263_트리의순회_G2_신민아_1384ms {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int treeCount = Integer.parseInt(br.readLine());
		
		int[] in = new int[treeCount]; // inorder
		int[] post = new int[treeCount]; // postorder
		int[] pre = new int[treeCount]; // answer
		
		StringTokenizer st1 = new StringTokenizer(br.readLine(), " "); // inorder
		StringTokenizer st2 = new StringTokenizer(br.readLine(), " "); // postorder
		
		for(int i=0;i<treeCount;i++) {
			in[i] = Integer.parseInt(st1.nextToken());
			post[i] = Integer.parseInt(st2.nextToken());
		}
		
		getPreOrder(pre, in, post, 0, treeCount-1, 0, treeCount-1, new int[1]); // 분할정복 코드
		
		StringBuilder sb = new StringBuilder(); // 출력용
		
		for(int n : pre) {
			sb.append(n).append(" ");
		}
		
		System.out.print(sb.toString());
	}
	
	// pre, in, post : orders
	// instart, inend : 탐색할 inorder의 시작과 끝 / postStart, postEnd : 탐색할 postorder의 시작과 끝
	// cur : preorder에 몇번째까지 넣었는지 확인
	private static void getPreOrder(int[] pre, int[] in, int[] post, int inStart, int inEnd, int postStart, int postEnd, int[] cur) {
		if(inStart > inEnd || postStart > postEnd)
			return;
		
		pre[cur[0]++] = post[postEnd]; // post의 마지막 원소는 root이므로 pre에 넣어줌
		int index = getIndex(in, post[postEnd], inStart, inEnd); // inorder에서 root의 위치를 찾아줌
		
		// left
		// 좌측 부분 트리이므로 root를 기준으로 inorder에서의 왼쪽 요소를 탐방
		getPreOrder(pre, in, post, inStart, index - 1, postStart, postStart + index - inStart - 1, cur);
		
		// right
		// 우측 부분 트리이므로 root를 기준으로 inorder에서의 오른쪽 요소를 탐방
		getPreOrder(pre, in, post, index + 1, inEnd, postStart + index - inStart, postEnd - 1, cur);
	}
	
	// postorder에서의 원소를 inorder 배열 내의 위치 찾기
	private static int getIndex(int[] in, int element, int start, int end) {
		for(int i=start;i<=end;i++) {
			if(in[i] == element)
				return i;
		}
		return -1;
	}

}
