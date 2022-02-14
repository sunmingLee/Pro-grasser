package tree;

import java.util.LinkedList;
import java.util.Queue;

public class CompleteBinaryTree {
	
	private char[] nodes;
	private final int SIZE;
	private int lastIndex;
	
	public CompleteBinaryTree(int size) {
		nodes = new char[size+1];
		SIZE = size;
	}
	
	public boolean isEmpty() {
		return lastIndex==0;
	}
	
	public boolean isFull() {
		return lastIndex == SIZE;
	}
	
	public void add(char e) {
		if(isFull()) {
			return;
		}
		nodes[++lastIndex] = e;
	}
	
	public void bfs() {
		
		if(isEmpty()) return;
		
		// 이진트리의 탐색 순서 관리
		Queue<Integer> queue = new LinkedList<Integer>();
		
		// 루트가 가장 먼저 탐색되도록 queue에 넣기
		queue.offer(1);
		while(!queue.isEmpty()) {
			int current = queue.poll(); // 탐색 순서에 맞는 인덱스
			
			System.out.println(nodes[current]);
			
			// 현재 노드의 자식 노드들의 인덱스를 다음에 순서가 되었을 때 탐색되도록 큐에 넣어준다
			// 왼쪽 자식 노드
			if(current*2<=lastIndex) queue.offer(current*2);
			
			// 오른쪽 자식 노드
			if(current*2+1<=lastIndex) queue.offer(current*2+1);
		}
	}
	
public void bfs2() {
		
		if(isEmpty()) return;
		
		// 이진트리의 탐색 순서 관리
		Queue<Integer> queue = new LinkedList<Integer>();
		
		// 루트가 가장 먼저 탐색되도록 queue에 넣기
		queue.offer(1);
		int level = 0;
		while(!queue.isEmpty()) {
			
			System.out.print("level " + level + " : ");
			
			// 같은 너비의 노드들 모두 탐색, 같은 행에 출력
			int size = queue.size();
			while(--size >= 0) {
				int current = queue.poll(); // 탐색 순서에 맞는 인덱스
				
				System.out.print(nodes[current] + " ");
				
				// 현재 노드의 자식 노드들의 인덱스를 다음에 순서가 되었을 때 탐색되도록 큐에 넣어준다
				// 왼쪽 자식 노드
				if(current*2<=lastIndex) queue.offer(current*2);
				
				// 오른쪽 자식 노드
				if(current*2+1<=lastIndex) queue.offer(current*2+1);
			}
			System.out.println();
			level++;
		}
	}

	public void dfsByPreorder() {
		System.out.println("DFS By PreOrder");
		dfsByPreOrder(1); // 완전탐색을 위한 캡슐화
		System.out.println();
	}
	
	public void dfsByInorder() {
		System.out.println("DFS By InOrder");
		dfsByInOrder(1); // 완전탐색을 위한 캡슐화
		System.out.println();
	}
	
	public void dfsByPostorder() {
		System.out.println("DFS By PostOrder");
		dfsByPostOrder(1); // 완전탐색을 위한 캡슐화
		System.out.println();
	}

	private void dfsByPreOrder(int current) {
//		if(current > lastIndex) return; --> 이거를 기저조건으로 두고 밑에 if문을 빼도 결과는 똑같
		
		// 현재 노드 방문
		System.out.print(nodes[current] + "\t");
		
		// 현재 노드의 자식 노드들 방문
		if(current*2<=lastIndex) dfsByPreOrder(current*2); //-> 기저 조건이 포함됨
		if(current*2+1<=lastIndex) dfsByPreOrder(current*2+1);
	}
	
	private void dfsByInOrder(int current) {
		// 현재 노드의 자식 노드들 방문
		if(current*2<=lastIndex) dfsByPreOrder(current*2); //-> 기저 조건이 포함됨
		
		System.out.print(nodes[current] + "\t"); // 현재 노드 방문
		
		if(current*2+1<=lastIndex) dfsByPreOrder(current*2+1);
	}
	
	private void dfsByPostOrder(int current) {
		// 현재 노드의 자식 노드들 방문
		if(current*2<=lastIndex) dfsByPreOrder(current*2); //-> 기저 조건이 포함됨
		if(current*2+1<=lastIndex) dfsByPreOrder(current*2+1);
		
		// 현재 노드 방문
		System.out.print(nodes[current] + "\t");
	}
}
