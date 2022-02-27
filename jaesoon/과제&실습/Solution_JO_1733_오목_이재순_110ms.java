import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_JO_1733_오목_이재순_110ms {
	static int count;
	static int[][] deltas = {{0,1},{1,-1},{1,0},{1,1}};
	static int[][] deltas2 = {{0,-1},{-1,1},{-1,0},{-1,-1}};
	public static void main(String[] args) throws Exception {
		int winner=0;
		int idxX=0;
		int idxY=0;
		int[][] pan = new int[21][21];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int i = 1; i < 20; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < 20; j++) {
				pan[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		loop:
			for (int i = 1; i < 20; i++) {
				for (int j = 1; j < 20; j++) {
					for (int k = 0; k < 4; k++) {
						if (pan[i][j]!=0) {
							int result = check(pan,i,j,k);
							if (result == 4&&pan[i+deltas2[k][0]][j+deltas2[k][1]]!=pan[i][j]) {
								winner = pan[i][j];
								if (k==1) {
									idxX=i+4;
									idxY=j-4;
								}
								else {
									idxX=i;
									idxY=j;								
								}
								break loop;
							}
						}
					}
				}
			}
		StringBuilder sb = new StringBuilder();
		switch (winner) {
		case 2:
		case 1:
			sb.append(winner).append("\n").append(idxX).append(" ").append(idxY);
			System.out.println(sb);
			break;

		default:
			System.out.println("0");
			break;
		}
		
		
	}// end of main

	
	public static int check(int[][] pan, int i, int j, int k) {
		if (pan[i][j]==pan[i+deltas[k][0]][j+deltas[k][1]]) {
			return 1+ check(pan, i+deltas[k][0], j+deltas[k][1], k);
		}
		return 0;
	}
}// end of class
