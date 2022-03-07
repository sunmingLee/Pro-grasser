import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_JO_1681_해밀턴순환회로_신민아_119ms {
	static int minDistance = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count = Integer.parseInt(br.readLine().replace(" ", ""));
		
		StringTokenizer st;
		int[][] distances = new int[count][count];
		for (int i = 0; i < count; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < count; j++) {
				distances[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		getRouteExpense(distances, new boolean[count], 0, 0, 0);
		System.out.print(minDistance);
	}
	
	private static void getRouteExpense(int[][] distances, boolean[] visited, int curExpense, int curCount, int curLocation) {
		if(curExpense > minDistance) {
			return;
		}
		
		if(curCount == distances.length - 1) {
			if(distances[curLocation][0] != 0) {
				minDistance = Math.min(minDistance, curExpense + distances[curLocation][0]);
			}
			return;
		}
		
		for(int i=1;i<distances.length;i++) {
			if(visited[i] || distances[curLocation][i] == 0) {
				continue;
			}
			
			visited[i] = true;
			getRouteExpense(distances, visited, curExpense + distances[curLocation][i], curCount + 1, i);
			visited[i] = false;
			
		}
		
	}
	
}
