import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**가로, 세로의 크기가 각각 100인 정사각형 모양의 흰색 도화지가 있다.
 *  이 도화지 위에 가로, 세로의 크기가 각각 10인 정사각형 모양의 검은색 색종이를 색종이의 변과 도화지의 변이 평행하도록 붙인다.
 *   이러한 방식으로 색종이를 한 장 또는 여러 장 붙인 후 색종이가 붙은 검은 영역의 넓이를 구하는 프로그램을 작성하시오.*/


public class Main_BOJ_2563_색종이_B1_양소정_124ms{
	public static void main(String[] args) throws Exception {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int [][] map =new int [100][100]; //가로 세로가 100인 도화지
		int N = Integer.parseInt(br.readLine()); //붙일 색종이 갯수
		int ans=0;
		
		for (int i = 0; i < N; i++) { 
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int x =Integer.parseInt(st.nextToken());
			int y =Integer.parseInt(st.nextToken());
			
			for (int j = 0; j <10; j++) {
				for (int k = 0; k <10; k++) {
					if(map[x+j][y+k]==0) {
						map[x+j][y+k] = 1;
						ans++;
					}
				}
				
			}
	
			
		}
		System.out.println(ans);
	}

}
