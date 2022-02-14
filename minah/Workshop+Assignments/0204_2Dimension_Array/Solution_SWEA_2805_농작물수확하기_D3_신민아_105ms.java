import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_SWEA_2805_농작물수확하기_D3_신민아_105ms {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int TC=0;TC<testCase;TC++) {
			int sum = 0;
			int size = Integer.parseInt(br.readLine());
			int[][] farm = new int[size][size];
			
			for(int i=0;i<size;i++) {
				String farmInfo = br.readLine();
				for(int j=0;j<size;j++) {
					farm[i][j] = farmInfo.charAt(j) - '0';
				}
			}
			
			int row = 0;
			for(int col=size/2-row;(col<=size/2+row) && (row<=size/2);col++) {
				sum += farm[row][col];
				
				if(row<size/2) {
					sum += farm[size-row-1][col];
				}
				
				if(col == size/2+row) {
					row++;
					col = size/2 - row - 1;
				}
			}
			sb.append("#").append(TC+1).append(" ").append(sum).append("\n");
		}
		System.out.print(sb.toString());
	}

}
