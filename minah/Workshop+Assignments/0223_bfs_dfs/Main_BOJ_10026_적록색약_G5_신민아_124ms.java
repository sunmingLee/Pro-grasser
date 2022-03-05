import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BOJ_10026_적록색약_G5_신민아_124ms {
	// map이 클수록 bfs가 더 빠름!
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int size = Integer.parseInt(br.readLine());
		
		char[][] originalMap = new char[size][size]; // 일반인용 배열
		char[][] nonGreenMap = new char[size][size]; // 적록색약용 배열
		
		for(int i=0;i<size;i++) {
			String line = br.readLine();
			originalMap[i] = line.toCharArray();
			nonGreenMap[i] = line.replaceAll("G", "R").toCharArray(); // 적록색약은 G가 필요 없으므로 R로 바꾸기
		}
		
		int originalAnswer = 0; // 일반인의 구역 개수
		int nonGreenAnswer = 0; // 적록색약의 구역 개수
		
		boolean[][] originalVisited = new boolean[size][size]; // 일반인 방문체크
		boolean[][] nonGreenVisited = new boolean[size][size]; // 적록색약 방문체크
		
		// 고민 : 적록색약의 경우도 한번에 체크할 수 있을지
		for(int i=0;i<size;i++) { // 칸바이 칸으로 검색
			for(int j=0;j<size;j++) {
				
				if(!originalVisited[i][j]) { // 일반인 전용 맵에 방문이 안 되었을 시
					getAreaByDFS(originalMap, originalVisited, i, j, originalMap[i][j]); // dfs돌고 다 빠져나오면 구역 ++
					originalAnswer++;
				}
				
				if(!nonGreenVisited[i][j]) { // 적록색약 전용 맵에 방문이 안 되었을 시
					getAreaByDFS(nonGreenMap, nonGreenVisited, i, j, nonGreenMap[i][j]);
					nonGreenAnswer++;
				}
			}
		}
		
		System.out.print(originalAnswer + " " + nonGreenAnswer);
		
	}
	
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, -1, 0, 1};
	
	// idea : boolean 배열을 아끼는 방법 -> ^= true
	private static void getAreaByDFS(char[][] map, boolean[][] visited, int r, int c, char repChar) {
		try {
			if(visited[r][c] || repChar != map[r][c]) { // 이미 방문했거나 같은 문자가 아니면 끝냄
				return;
			}
			
			visited[r][c] = true; // 방문 체크
			
			for(int i=0;i<4;i++) { // 델타값으로 4방 탐색
				getAreaByDFS(map, visited, r + dr[i], c + dc[i], repChar);
			}
			
		} catch(Exception e) {	} // 배열 밖으로 벗어나면 검사할 필요 x
	}
}
