import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_7465_창용마을무리의개수_D4_신민아_126ms {
	static int answer;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for(int testCase=0;testCase<TC;testCase++) { 
			st = new StringTokenizer(br.readLine(), " ");
			
			int villagers = Integer.parseInt(st.nextToken());
			answer = villagers;
			int[] parents = new int[villagers + 1];
			
			for(int i=1;i<parents.length;i++) {
				parents[i] = i;
			}
			
			int opCount = Integer.parseInt(st.nextToken());
			for(int i=0;i<opCount;i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int villager1 = Integer.parseInt(st.nextToken());
				int villager2 = Integer.parseInt(st.nextToken());
				
				setUnion(parents, villager1, villager2);
			}
			
			sb.append("#").append(testCase+1).append(" ").append(answer).append("\n");
		}
		
		System.out.print(sb.toString());
	}
	
	private static void setUnion(int[] parents, int a, int b) {
		int aRepresent = findCrowd(parents, a);
		int bRepresent = findCrowd(parents, b);
		
		if(aRepresent == bRepresent) {
			return;
		}
		
		parents[bRepresent] = aRepresent;
		answer--;
	}
	
	private static int findCrowd(int[] parents, int a) {
		if(a == parents[a]) return a;
		
		return parents[a] = findCrowd(parents, parents[a]);
	}

}
