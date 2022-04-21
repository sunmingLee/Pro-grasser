package boj_0329;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

// 배열로 바꾸고 index를 관리했더니 180ms 감량..!(>> 지독하다 <<)
public class Main_BOJ_14502_연구소_G5_신민아_288ms_arrayVer {
	static class Node {
		int r, c;

		public Node(int r, int c) {
			this.r = r;
			this.c = c;
		}		
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String line = br.readLine();
		int rSize = line.charAt(0) - '0';
		int cSize = line.charAt(2) - '0';
		
		char[][] map = new char[rSize][cSize];
		
		Node[] safePoints = new Node[rSize*cSize]; // // 안전한 구역 배열 : 벽을 세우기 위해 사용(조합에 사용)
		int safeCount = 0; // 안전한 구역의 개수
		
		Node[] viruses = new Node[10]; // 바이러스가 위치하는 곳의 배열(진원지) : 추후에 BFS를 통해 바이러스 확산(4방으로 확산)
		int virusCount = 0; // 바이러스 진원지의 개수
		
		for(int i=0;i<rSize;i++) {
			line = br.readLine();
			for(int j=0,index=0;j<cSize;j++,index+=2) {
				map[i][j] = line.charAt(index); // map에 입력 값 받기
				
				if(map[i][j] == '0') {
					safePoints[safeCount++] = new Node(i, j); // 0인 곳의 좌표를 list에 저장 + 안전한 곳이므로 안전한 구역 개수 카운팅
				}
				else if(map[i][j] == '2') {
					viruses[virusCount++] = new Node(i, j); // 2인 곳(바이러스)의 좌표를 list에 저장 + 바이러스 진원지이므로 카운팅
				}
				
			}
		}
		
		int maxSafeArea = 0;
		maxSafeArea = Math.max(maxSafeArea, selectWallLocation(0, 0, new int[3], new int[1], map, 
																	safePoints, safeCount, viruses, virusCount));
		
		System.out.print(maxSafeArea);
	}
	
	// parameter : 현재까지 조합을 만든 개수, 조합 배열에 넣을 숫자, 조합 결과물, 현재까지의 안전한 방의 개수의 최댓값
	//					연구실, 안전 구역 정보, 안전 구역 개수(일반 배열이므로 인덱스 관리 필요), 바이러스 진원지 정보, 바이러스 진원지 개수
	private static int selectWallLocation(int count, int start, int[] index, int[] curMax,
											char[][] map, Node[] safePoints, int safePointsCount, Node[] viruses, int virusCount) {
		if(count == 3) {
			curMax[0] = Math.max(curMax[0], getSafeCounts(curMax[0], index, map, safePoints, safePointsCount, viruses, virusCount));
			return curMax[0];
		}
		
		for(int i=start;i<safePointsCount;i++) {
			index[count] = i;
			selectWallLocation(count+1, i+1, index, curMax, map, safePoints, safePointsCount, viruses, virusCount);
		}
		
		return curMax[0];
	}
	
	// parameter : 이전까지의 안전구역 최대값, 조합 결과물, 연구실, 안전구역 정보, 안전구역 개수, 바이러스 진원지 정보, 바이러스 진원지 개수
	private static int getSafeCounts(int beforeMax, int[] index, char[][] map, Node[] safePoints, int safeCount, 
																				Node[] viruses, int virusCount) {
		int curSafeCount = safeCount - 3; // 벽을 3개 세울 예정이므로 미리 3개 빼줌
		char[][] newMap = copyMap(map); // 기존에 있는 맵을 바꾸면 곤란하므로 copy
		
		for(int i=0;i<index.length;i++) { // 실제로 벽을 세워주기
			Node w = safePoints[index[i]];
			newMap[w.r][w.c] = '1';
		}
				
		// BFS로 바이러스가 확산 되는 것을 구현하기 위해 진원지를 먼저 offer하기
		Queue<Node> virusPath = new ArrayDeque<Node>();
		for(int i=0;i<virusCount;i++) {
			virusPath.offer(viruses[i]);
		}
		
		// 4방 탐색하면서 BFS로 확산
		int[] dr = {-1, 1, 0, 0};
		int[] dc = {0, 0, -1, 1};
		
		// 중간에 curSafeCount가 beforeMax보다 작아진다면 while문 종료
		while(virusPath.size() > 0) {
			if(curSafeCount < beforeMax) 
				break;
			
			Node curVirus = virusPath.poll();
			
			for(int d=0;d<4;d++) {
				int nr = curVirus.r + dr[d];
				int nc = curVirus.c + dc[d];
				
				if(isNotAvailable(nr, nc, newMap)) continue; // 배열 밖으로 나가면 다음으로
				if(newMap[nr][nc] == '0') { // 배열 안쪽이며 안전 구역일 경우만
					virusPath.offer(new Node(nr, nc)); // 바이러스가 확산 될 수 있으므로 queue에 offer
					newMap[nr][nc] = '2'; // 바이러스 확산 체크 == visit check
					curSafeCount--; // 확산 되었으므로 방을 줄임
				}
				
			}
		}
				
		return curSafeCount;
	}
	
	// 기존의 연구실에서 복사하여 벽 세우고 바이러스 확산을 시뮬레이션하기 위한 메소드
	private static char[][] copyMap(char[][] map) {
		char[][] newMap = new char[map.length][map[0].length];
		
		for(int i=0;i<map.length;i++) {
			for(int j=0;j<map[i].length;j++) {
				newMap[i][j] = map[i][j];
			}
		}
		
		return newMap;
	}
	
	// 배열 범위를 나갔는지 확인
	private static boolean isNotAvailable(int nr, int nc, char[][] map) {
		return((nr < 0) || (nr >= map.length) || (nc < 0) || (nc >= map[0].length));
	}
	
}
