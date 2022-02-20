import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BOJ_2839_설탕배달_B1_신민아_76ms {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int sugarAmount = Integer.parseInt(br.readLine());
		
		int answer = -1;
		if(sugarAmount % 5 == 0 ) {
			answer = sugarAmount / 5;
		} 
		else {
			boolean isDivisableBy3 = false;
			int count5kg = 0;
			
			// 반대로 3kg 봉지를 0부터 하나씩 빼서 % 5가 == 0일때 빠져 나가도 좋음
			for(int i=sugarAmount/5;i>=0;i--) {
				if((sugarAmount - 5*i) % 3 == 0) {
					isDivisableBy3 = true;
					count5kg = i;
					break;
				}
			}
			
			if(isDivisableBy3)
				answer = count5kg + (sugarAmount - 5 * count5kg)/3;
		}
		
		System.out.println(answer);
	}

}
