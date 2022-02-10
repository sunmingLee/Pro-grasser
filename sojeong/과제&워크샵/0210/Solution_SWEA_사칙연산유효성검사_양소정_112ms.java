import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_사칙연산유효성검사_양소정_112ms {
	public static void main(String[] args) throws Exception{
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 StringBuilder sb = new StringBuilder();
		 
		 for(int testCase = 1 ; testCase <= 10 ; testCase++) {
			 int N = Integer.parseInt(br.readLine()); //노드 수
			 
			 int answer =1 ;
			 
			 for (int i = 1; i <= N; i++) { //노드 수 만큼 반복 검사
				StringTokenizer st =new StringTokenizer(br.readLine());
				st.nextToken(); //번호 날리기
				char node = st.nextToken().charAt(0); //char로 변환되는 건가?
				
				if(st.hasMoreElements()) {// hasMoreElements() : 읽어올 요소가 남아있는지 확인. 있으면 true, 없으면 false. Iterator의 hasNext()와 같음						
					if(node >= '0' && node <='9') { //남은 숫자가 있으면 연산자야 하므로 숫자라면 0
						answer = 0;
						
					}
					
				}else { //단말노드일때는 node가 숫자여야함
					if(node < '0' || node >'9') { // 아니라면 0
						answer =0;
					}
					
				}
			}
			 
			 sb.append("#"+testCase+" "+answer+"\n");
			 
		 }
		 System.out.println(sb.toString());
	}

}
