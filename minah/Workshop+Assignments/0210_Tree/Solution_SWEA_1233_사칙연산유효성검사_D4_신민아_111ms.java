import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_1233_사칙연산유효성검사_D4_신민아_111ms {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st;
		for(int testCase=0;testCase<10;testCase++) {
			int nodeCount = Integer.parseInt(br.readLine());
			int isCalculatable = 1;
			
			int lastCount = 1;
			for(int i=1;i<nodeCount+1;i++) {
				st = new StringTokenizer(br.readLine(), " ");
				st.nextToken();
				
				String secondElement = st.nextToken();
				boolean isOperator = false;
				
				if(secondElement.equals("+") || secondElement.equals("-") || secondElement.equals("*") || secondElement.equals("/")) {
					isOperator = true;
				}
				
				if(i <= nodeCount/2) {
					if(!isOperator) {
						isCalculatable = 0;
						lastCount = i + 1;
						break;
					}
				} else {
					if(isOperator) {
						isCalculatable = 0;
						lastCount = i + 1;
						break;
					}
				}
			}
			
			if(isCalculatable == 0) {
				for(int i=lastCount;i<nodeCount+1;i++) {
					br.readLine();
				}
			}
			
			
			sb.append("#").append(testCase+1).append(" ").append(isCalculatable).append("\n");
		}
		
		System.out.print(sb.toString());

	}
	
//	private static 

}
