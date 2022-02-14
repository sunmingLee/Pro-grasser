import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BOJ_3040_백설공주와일곱난쟁이_B2_신민아_80ms {
	static boolean isSearched = false;
	static int diff = -100;
	static int[] shorts, notShort;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		shorts = new int[9];
		notShort = new int[2];
		
		for(int i=0;i<9;i++) {
			int num = Integer.parseInt(br.readLine());
			shorts[i] = num;
			diff += num;
		}
		
		getIncorrectShortsByCombination(0, 0);
		
		StringBuilder sb = new StringBuilder();
		for(int oneShort : shorts) {
			if(oneShort == -1) continue;
			sb.append(oneShort).append("\n");
		}
		
		System.out.print(sb.toString());

	}
	
	static void getIncorrectShortsByCombination(int cnt, int start) {
		if(cnt == 2 || isSearched) {
			if(notShort[0] + notShort[1] == diff) {
				isSearched = true;
				for(int i=0;i<9;i++) {
					if((shorts[i] == notShort[0]) || (shorts[i] == notShort[1])) {
						shorts[i] = -1;
					}
				}
			}
			return;
		}
		
		for(int i=start;i<shorts.length;i++) {
			notShort[cnt] = shorts[i];
			getIncorrectShortsByCombination(cnt+1, start+1);
		}
	}

}
