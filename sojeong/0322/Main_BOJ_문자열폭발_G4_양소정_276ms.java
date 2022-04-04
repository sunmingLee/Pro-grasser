
import java.io.BufferedReader;
import java.io.InputStreamReader;


//문자열을 폭파, 즉 삭제할 때 String의 replace나 Stringbuilder의 delete 등의 내장 함수를 사용하면 기본적으로 문자열 처음부터 탐색을 다시 시작하기 때문에 O(N^2)의 시간 복잡도로 늘어나버린다.

public class Main_BOJ_문자열폭발_G4_양소정_276ms{
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str = br.readLine();
		String bomb = br.readLine();
		
		char[] ans = new char[1000000];
		int idx=0;
		char ch;
		
		boolean flag=false;

		for (int i = 0; i < str.length(); i++) {
			ch = str.charAt(i);
			idx++;
			flag = false;
			if(idx>=bomb.length()) {
				
				if(ch ==bomb.charAt(bomb.length()-1)){
					flag = true; //bomb이 한글자 일때  아래 for문을 돌지 않으니까 여기서도 flag처리
					for (int j = 1; j <bomb.length(); j++) {
						if(ans[idx-j] ==bomb.charAt(bomb.length()-1-j)) {
							flag= true;
							
						}else {
							flag = false;
							break;
						}
					}
				}
				if(flag) {
					idx -= bomb.length();
				}else {				
					ans[idx] =str.charAt(i);
				}
				
			}else {
				ans[idx] =str.charAt(i);
			}
		}

		if(idx==0) System.out.println("FRULA");
		
		for (int i = 1; i <= idx; i++) {
			sb.append(ans[i]);
		}
		System.out.println(sb);
		
	}
}
