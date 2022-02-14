import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_SWEA_1289_원재의메모리복구_D3_신민아_100ms {
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		try(BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))) {
			int testCount = Integer.parseInt(bf.readLine());
			for(int i=0;i<testCount;i++) {
				String example = bf.readLine();
				sb.append("#").append(i+1).append(" ").append(getConvertCount(example)).append("\n");
			}
			
			// 마지막 개행문자 제거
			sb.setLength(sb.length() - 1);
		} catch(Exception e) {
			e.printStackTrace();
		}
		System.out.print(sb.toString());
	}
	
	// 각 자릿수마다 숫자가 바뀌는 부분을 찾는 함수
	private static int getConvertCount(String example) {
		int count = 0;
		for(int i=0;i<example.length()-1;i++) {
			if(example.charAt(i) != example.charAt(i+1)) {
				count++;
			}
		}
		// 맨 앞자리가 1일 경우는 무조건 한번은 뒤집어 주어야 하므로 카운트
		if(example.charAt(0) == '1') count++;
		return count;
	}
}

