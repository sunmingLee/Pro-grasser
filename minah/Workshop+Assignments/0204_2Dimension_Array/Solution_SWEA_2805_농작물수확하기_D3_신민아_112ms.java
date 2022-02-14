import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_SWEA_2805_농작물수확하기_D3_신민아_112ms {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int TC=0;TC<testCase;TC++) {
			int sum = 0;
			int size = Integer.parseInt(br.readLine());
			
			for(int i=0;i<size;i++) {
				String farmInfo = br.readLine();
				int x = Math.abs(size/2-i);
				if(i<=size/2) {
					for(int j=x;j<=size/2+i;j++)
						sum+= farmInfo.charAt(j) - '0';
				} else {
					for(int j=x;j<=-i+3*(size/2);j++)
						sum+= farmInfo.charAt(j) - '0';
				}
				
			}
			sb.append("#").append(TC+1).append(" ").append(sum).append("\n");
		}
		System.out.print(sb.toString());
	}
}
