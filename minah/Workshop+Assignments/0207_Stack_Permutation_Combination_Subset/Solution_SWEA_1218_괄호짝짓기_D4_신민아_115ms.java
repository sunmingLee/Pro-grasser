import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution_SWEA_1218_괄호짝짓기_D4_신민아_115ms {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		Stack<String> brackets = new Stack<String>();
		
		String[] bracketList;
		String lines="";
		int count = 0;
		while(!(lines=br.readLine()).isEmpty()) { // (lines = br.readLine())!=null // !(lines=br.readLine()).isEmpty()
			sb.append("#").append(++count).append(" ");
			int bracketCount = Integer.parseInt(lines);
			bracketList = br.readLine().split("");
			int isRemovable = 1;
			
			for(int i=0;i<bracketCount;i++) {
				String bracket = bracketList[i];
				switch(bracket) {
					case "(":
					case "[":
					case "<":
					case "{":
						brackets.push(bracket);
						break;
					default :
						if((!brackets.isEmpty()) && isBracketPair(bracket).equals(brackets.peek()))
							brackets.pop();
						else
							isRemovable = 0;
				}
				if(isRemovable == 0) break;
			} // end of for
			
			sb.append(isRemovable).append("\n");
		} // end of while
		
		System.out.print(sb.toString());
	} // end of main
	
	private static String isBracketPair(String bracket) {
		String pair = "";
		switch(bracket) {
			case ")": pair = "("; break;
			case "]": pair = "["; break;
			case ">": pair = "<"; break;
			case "}": pair = "{"; break;
		}
		
		return pair;
	}

}
