import java.util.Arrays;

public class DisjointSetTest {
	static int N;
	static int[] parents;
	
	// 단위 집합 생성
	private static void makeSet() {
		parents = new int[N];
		// 자신의 부모 노드를 자신의 값으로 세팅
		for(int i=0;i<N;i++) {
			parents[i] = i;
		}
	}
	
	// a의 대표자 찾기
	private static int findSet(int a) {
		if(a == parents[a]) {
			return a;
		}
		return parents[a] = findSet(parents[a]);
	}
	
	// a, b 두 집합 합치기 : 합쳤으면 true, 합치지 못했으면 false
	private static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if(aRoot == bRoot) return false;
		
		parents[bRoot] = aRoot;
		return true;
	}
	
	public static void main(String[] args) {
		N = 5;
		makeSet();
		
		System.out.println(Arrays.toString(parents));
		System.out.println(union(0, 1));
		System.out.println(Arrays.toString(parents));
		System.out.println(union(2, 1));
		System.out.println(Arrays.toString(parents));
		System.out.println(union(3, 2));
		System.out.println(Arrays.toString(parents));
		System.out.println(union(4, 3));
		System.out.println(Arrays.toString(parents));
		
		System.out.println("====find====");
		System.out.println(findSet(4));
		System.out.println(Arrays.toString(parents));
		System.out.println(findSet(3));
		System.out.println(Arrays.toString(parents));
		System.out.println(findSet(2));
		System.out.println(Arrays.toString(parents));
		System.out.println(findSet(0));
		System.out.println(Arrays.toString(parents));
		System.out.println(findSet(1));
		System.out.println(Arrays.toString(parents));
	}

}
