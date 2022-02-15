import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_SWEA_2001_파리퇴치_D2_신민아_114ms {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int testCase = Integer.parseInt(br.readLine());
		
		for(int TC=0;TC<testCase;TC++) {
			String[] sizes = br.readLine().split(" ");
			int areaSize = Integer.parseInt(sizes[0]);
			int smasherSize = Integer.parseInt(sizes[1]);
			
			int[][] area = new int[areaSize][areaSize];
			for(int i=0;i<areaSize;i++) {
				String[] flies = br.readLine().split(" ");
				for(int j=0;j<areaSize;j++) {
					area[i][j] = Integer.parseInt(flies[j]);
				}
			}
			
			int max = 0;
			
			// 4중 for문보다 좋은것이 진짜 없을까
			for(int i=0;i<areaSize-smasherSize+1;i++) {
				for(int j=0;j<areaSize-smasherSize+1;j++) {
					int sum = 0;
					for(int x=0;x<smasherSize;x++) {
						for(int y=0;y<smasherSize;y++) {
							sum += area[i+x][j+y];
						}
					}
					if(sum > max) max = sum;
				}
			}
			sb.append("#").append(TC+1).append(" ").append(max).append("\n");
		}
		System.out.print(sb.toString());
	}

}
