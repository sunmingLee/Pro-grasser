import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main_BOJ_2839_설탕배달_B1_양소정_76ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); //배달해야 될 무게
		int cnt =0 ; //들고가는 봉지 수 
		while(true) {
			if(N%5 ==0) { //5로 나머지 없이 나눠지면 출력
				cnt += N/5;
				System.out.println(cnt);
				break;
			}else{  //안되면 하나씩 빼보기
				N -= 3;
				cnt ++;
			
			}
			if(N<0) { 
				System.out.println("-1");
				break;
			}
		}
		
	}
}
