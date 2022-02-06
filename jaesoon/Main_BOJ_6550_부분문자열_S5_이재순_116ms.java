import java.io.BufferedReader;
//import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BOJ_6550_부분문자열_S5_이재순_116ms {
	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("input.txt")); //예제 input.txt로 만들어서 eclipse에서 실행
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = br.readLine()) != null) {
			String[]  str = line.split(" ");
			int i = str[0].length();
			int j = str[1].length();
			boolean notFound;
			int idx=0;
			for (int n = 0; n < i; n++) {
				notFound = true;
				char a = str[0].charAt(n);
				for (int k = idx; k < j; k++) {
					if (a == str[1].charAt(k)) {
						notFound = false;
						idx = k+1;
						break;
					}
				}
				if (notFound) {
					sb.append("No\n");
					break;
				} else if(n==i-1){
					sb.append("Yes\n");
				}
			}
		}
		System.out.print(sb);
	}//end of main
}//end of class
