import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_BOJ_11725_트리의부모찾기_S2_이승연_596ms {
	private static ArrayList<Integer>[] list;
	private static int N;
	private static int[] parents;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		
		list = new ArrayList[N+1]; // 인접리스트 
		
		for(int i=0; i<=N; i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		StringTokenizer st;
		
		for(int i=0; i<N-1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			
			list[n1].add(n2); // 양방향(누가 부모고, 누가 자식인지 아직 모름)
			list[n2].add(n1); // 양방향(누가 부모고, 누가 자식인지 아직 모름) 
		}
		
		parents = new int[N+1]; // index 번호: 자식노드번호, 해당 자리에 그 자식의 부모노드번호 저장 
		
		findParents(1, 0); // dfs 
		
		for(int i=2; i<parents.length; i++) { // 2번 노드부터 순서대로 출력 
			sb.append(parents[i]).append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	private static void findParents(int current, int parent) { // dfs로 부모 찾기 
		if(current > N) return; 
		
		parents[current] = parent;
		
		for(int i=0; i<list[current].size(); i++) {	
			if(list[current].get(i) != parent) { // 주의: 자식으로만 가야함. 저장 시에는 누가 부모인지, 자식인지 모르므로 다 저장했기 때문에 여기서 고려해야함.
				findParents(list[current].get(i), current);
			}
		}
	}
}
