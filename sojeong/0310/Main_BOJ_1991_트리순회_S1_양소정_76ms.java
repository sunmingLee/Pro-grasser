
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main_BOJ_1991_트리순회_S1_양소정_76ms {
	
	private static int[][] Node;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		Node = new int[27][2]; //알파벳 26개, 1부터 저장 26+1
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			int root = str.charAt(0)-'@';//부모 알파벳 idx값
			char left = str.charAt(2);
			char right = str.charAt(4);
			if (left == '.') { //왼쪽 자식 노드 값 a[root][0]
                Node[root][0] = -1;
            } else {
                Node[root][0] = left-'@';
            }
            if (right == '.') {// 오른쪽 자식 노드 값a[root][1]
                Node[root][1] = -1;
            } else {
                Node[root][1] = right-'@';
            }
		}
	
	    dfsByPreOrder(1);
		System.out.println();
		dfsByInOrder(1);
		System.out.println();
		dfsByPostOrder(1);
		
	}
	
	
	private static void dfsByPreOrder(int current) {  
		if(current == -1) return;
		
		System.out.print((char)(current+'@'));		
		dfsByPreOrder(Node[current][0]); //left
		dfsByPreOrder(Node[current][1]); //right
	
	}
		
	private static void dfsByInOrder(int current) { 
		if(current == -1) return;
		
		dfsByInOrder(Node[current][0]); //left
		System.out.print((char)(current+'@'));
		dfsByInOrder(Node[current][1]); //right
	}
	
	private static void dfsByPostOrder(int current) {  
		if(current == -1) return;
		
		dfsByPostOrder(Node[current][0]); //left
		dfsByPostOrder(Node[current][1]); //right	
		System.out.print((char)(current+'@'));
		
	}
	
}
