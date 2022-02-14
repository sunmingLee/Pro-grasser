import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_SWEA_1954_달팽이숫자_D2_이재순_107ms {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(); 
		int T = Integer.parseInt(br.readLine());
		//테스트 케이스 반복 
		for (int k = 0; k < T; k++) {
			sb.append("#"+(k+1)+"\n");
			int num = 1;
			int size = Integer.parseInt(br.readLine());
			//배열 생성
			int[][] arr = new int[size][size];
			for (int n = 0; n < (size/2)+1; n++) {
				for (int i = n; i < size-n; i++) { // 우
					arr[n][i] = num++;
				}
				for (int i = n+1; i < size-n; i++) {// 하
					arr[i][size-n-1] = num++;
				}
				for (int i = size-n-2; i >= n ; i--) {// 좌
					arr[size-n-1][i] = num++;
				}
				for (int i = size-n-2; i > n; i--) {// 상
					arr[i][n] = num++;
				}
			}
			//배열 출력
			for (int[] is : arr) {
				for (int is2 : is) {
					sb.append(is2+" ");
				}
				sb.setLength(sb.length()-1);
				sb.append("\n");
			}
		}
		System.out.print(sb);
	}//end of main
}//end of class