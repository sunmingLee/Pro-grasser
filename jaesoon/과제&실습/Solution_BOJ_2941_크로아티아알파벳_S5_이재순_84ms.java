import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_BOJ_2941_크로아티아알파벳_S5_이재순_84ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		int size = line.length();
		int ans = size;
		for (int i = 0; i < size; i++) {
			switch (line.charAt(i)) {
			case '=':
				if (i>1&&line.charAt(i-2)=='d'&&line.charAt(i-1)=='z') {
					ans--;
				}
			case '-':
				ans--;
				break;
			case 'j':
				if (i>0&&(line.charAt(i-1)=='l'||line.charAt(i-1)=='n')) ans--;
				break;
			}
		}
		System.out.println(ans);
	}
}
