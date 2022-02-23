import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_3289_서로소집합_D4_양소정_684ms {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T =Integer.parseInt(br.readLine()); 
		StringBuilder sb = new StringBuilder();
		for (int tc = 0; tc < T; tc++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N =Integer.parseInt(st.nextToken()); //N개집합
			int M =Integer.parseInt(st.nextToken()); //연산의 개수
			int[] arr = new int[N+1]; 
			for (int i = 1; i <= N; i++) {
				arr[i] =i;
			}
			sb.append("#").append(tc+1).append(" ");
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int kind =  Integer.parseInt(st.nextToken()); //연산종류
				int a =  Integer.parseInt(st.nextToken()); 
				int b =  Integer.parseInt(st.nextToken()); 
				
				if(kind == 1) { // 두 원소가 같은 집합 포함 확인
					if(find(arr, a,b)) sb.append("1"); //같은 집합
					else sb.append("0"); //다른 집합

				}else {  //합집합
					union(arr,a,b);
				}
				
			}
			sb.append("\n");
		}
		System.out.println(sb);
		
	}
	//a의 집합 찾기 :a의 대표자 찾기
	public static int findSet(int []parents,int a) {
		if(a==parents[a]) return a;
		return parents[a] = findSet(parents, parents[a]); 
	}
	
	//서로 같은 집합인지 확인
	public static boolean find(int[]parents ,int a, int b) {
		return (findSet(parents,a) == findSet(parents,b));
	}


	//a, b 두 집합 합치기
	public static void union(int[] parents,int a, int b) {
		a = findSet(parents,a);
		b = findSet(parents,b);
		
		if(a != b) parents[b] = a; // a가 더 크면 a의 부모는 b
		      // b가 더 크면 b의 부모는 a
	
	}

}
