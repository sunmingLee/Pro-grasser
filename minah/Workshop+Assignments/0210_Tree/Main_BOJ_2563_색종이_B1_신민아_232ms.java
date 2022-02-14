import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BOJ_2563_색종이_B1_신민아_232ms {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int paperCount = Integer.parseInt(br.readLine());
		
		int[] paperX = new int[paperCount]; // 종이의 시작점의 x좌표
		int[] paperY = new int[paperCount]; // 종이의 시작점의 y좌표
		
		StringTokenizer st;
		for(int i=0;i<paperCount;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			paperX[i] = Integer.parseInt(st.nextToken())-1;
			paperY[i] = Integer.parseInt(st.nextToken())-1;
		}
		
		int minX = Arrays.stream(paperX).min().getAsInt();
		int minY = Arrays.stream(paperY).min().getAsInt();
		
		int maxX = Arrays.stream(paperX).max().getAsInt();
		int maxY = Arrays.stream(paperY).max().getAsInt();
		
		boolean[][] area = new boolean[100][100];
		for(int delta=0;delta<paperCount;delta++) {
			
			for(int deltaX=paperX[delta];deltaX<paperX[delta]+10;deltaX++) {
				
				for(int deltaY=paperY[delta];deltaY<paperY[delta]+10;deltaY++) {
					
					area[deltaX][deltaY] = true;
				}
			}
		}
		
		int count = 0;
		for(int curX=minX;curX<=maxX+10;curX++) {
			for(int curY=minY;curY<=maxY+10;curY++) {
				if(area[curX][curY]) {
					count++;
				}
			}
		}
		
		System.out.print(count);
		
	}

}
