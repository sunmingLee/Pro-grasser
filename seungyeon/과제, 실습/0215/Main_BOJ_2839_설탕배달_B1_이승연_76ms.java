import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BOJ_2839_설탕배달_B1_이승연_76ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());

		boolean result = false; // 결과가 나올 수 있는지의 유무 
		
		for(int i=N/5; i>=0; i--) { // i: 5의 개수(최대 개수에서 줄여나감.)
			int left = N - i*5; // 남은 무게  
			
			if(left%3 != 0) continue; // 남은 무게가 3으로 나누어떨어지지 않으면 
			else { // 남은 무게가 3으로 나누어떨어지면 
				System.out.println(i+left/3); // 전체 개수 출력 
				result = true;
				break;
			}
		}
		
		if(!result) System.out.println("-1"); // 결과가 나오지 않을 때 
	}
}
