import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_6550_부분문자열_S5_신민아_124ms {

	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String testCase;
		
		// eclipse에서 테스트 시 while문 안의 조건문을 (!(testCase=bf.readLine()).isEmpty())로 변경해야 NoSuchElementException이 안뜸
		// BOJ에서는 제출 시 while문 내 조건문을 ((testCase = bf.readLine()) != null)로 해야 NPE가 안뜸
		while((testCase = bf.readLine()) != null) {
			int offset = 0;
			
			// 배열도 사용해봤으나 spilt외의 StringTokenizer이라는 객체도 있어 한번 사용해봄 -> 실행 시간이나 메모리 측면에서는 큰 차이없음
			StringTokenizer st = new StringTokenizer(testCase);
			String sub = st.nextToken();
			String word = st.nextToken();
			
			for(int i=0;i<word.length();i++) {
				if(word.charAt(i) == sub.charAt(offset)) {
					offset++;
				}
				if(offset == sub.length()) {
					sb.append("Yes\n");
					break;
				}
			}
			
			if(offset < sub.length()) {
				sb.append("No\n");
			}
		}
		System.out.print(sb.toString());
	}
}
