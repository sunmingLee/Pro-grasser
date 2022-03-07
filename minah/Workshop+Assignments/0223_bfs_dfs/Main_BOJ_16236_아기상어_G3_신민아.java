import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_16236_아기상어_G3_신민아 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int size = Integer.parseInt(br.readLine());
		int[][] map = new int[size][size];
		
		int curR = 0;
		int curC = 0;
		int fishes = 0;
		StringTokenizer st;
		
		for(int i=0;i<size;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0;j<size;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] > 0) {
					if(map[i][j] == 9) {
						curR = i;
						curC = j;
					} else {
						fishes++;
					}
				}
			}
		}
		
		
		
	}

}
