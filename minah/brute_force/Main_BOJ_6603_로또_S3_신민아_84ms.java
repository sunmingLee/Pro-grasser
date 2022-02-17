package brute_force;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_6603_로또_S3_신민아_84ms {
	static StringBuilder sb; // 출력용 StringBuilder
	static int[] numbers, input; // numbers : 조합을 저장할 배열, input : 조합을 수행할 원소들
	static int count; // 전체 원소의 개수
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		String line = "";
		sb = new StringBuilder();
		while(!(line = br.readLine()).equals("0")) { // 줄을 읽었을 때 0을 마주칠 때까지
			st = new StringTokenizer(line, " "); // 공백으로 나누기
			count = Integer.parseInt(st.nextToken()); // 전체 원소의 개수
			
			input = new int[count]; // 원소 입력용 배열
			numbers = new int[6]; // 원소의 조합용 배열
			
			for(int i=0;i<count;i++) { // 입력으로 주어진 원소 저장
				input[i] = Integer.parseInt(st.nextToken());
			}
			
			getLottoCombination(0, 0); // 0번째 숫자를 numbers의 0번째 인덱스부터 고르기
			
			sb.append("\n"); // 테스트케이스 구분용
		}
		
		System.out.print(sb.toString()); // 출력

	}
	
	private static void getLottoCombination(int cnt, int start) { // 조합 찾는 메소드
		if(cnt == 6) { // 숫자는 6개까지만 뽑으므로
			for(int i=0;i<6;i++) { // 각 조합 내의 원소를 꺼내 출력
				sb.append(numbers[i]).append(" ");
			}
			sb.append("\n"); // 줄바꿈
			return;
		}
		
		for(int i=start;i<count;i++) {	 // start부터 시작하여 count까지 조합의 경우의 수 구하기
			numbers[cnt] = input[i]; // numbers에 선택된 input의 i번째 인덱스 넣기
			getLottoCombination(cnt+1, i+1); // cnt+1번째 원소를 i+1부터 채워넣기
		}
	}
	
	

}

