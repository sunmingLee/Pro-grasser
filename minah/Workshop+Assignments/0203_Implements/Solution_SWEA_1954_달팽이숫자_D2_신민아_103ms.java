import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_SWEA_1954_달팽이숫자_D2_신민아_103ms {

	public static void main(String[] args) {
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			StringBuilder sb = new StringBuilder();
			int testCount = Integer.parseInt(br.readLine());
			for(int i=0;i<testCount;i++) {
				int size = Integer.parseInt(br.readLine());
				int[][] snail = new int[size][size];
				
				int num = 1;
				int start = 0;
				int r = 0;
				int c = 0;
				
				sb.append("#").append(i+1).append("\n");
				while(start < size / 2) {
					for(;c<size-start-1;c++) {
						snail[r][c] = num++;
					}
					
					for(;r<size-start-1;r++) {
						snail[r][c] = num++;
					}
					
					for(;c>start;c--) {
						snail[r][c] = num++;
					}
					
					for(;r>start;r--) {
						snail[r][c] = num++;
					}
					start++;
					c++;
					r++;
				}
				
				if(size % 2 == 1) { // 음수일 경우도 있으므로 (N % 2 != 0)으로 하기
					snail[size/2][size/2] = num;
				}
				
				for(int[] a : snail) {
					for(int b : a) {
						sb.append(b).append(" ");
					}
					sb.append("\n");
				}
				
			}
			System.out.print(sb.toString()); // ln붙이면 call stack 적립 : 필요한 경우에만 println 하도록
		} catch(Exception e) {
			e.printStackTrace();
		}

	}

}
