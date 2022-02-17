import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_6603_로또_S2_이재순_84ms {
	static int[] arr; // 번호를 저장하는 배열
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int k;//번호의 갯수, 6 < k < 13
		while ((k = Integer.parseInt(st.nextToken())) != 0 ) { // 0이 입력될때까지 반복
			arr = new int[k]; // 로또 번호 배열 선언
			for (int i = 0; i < k; i++) { //번호의 갯수만큼 반복
				arr[i] = Integer.parseInt(st.nextToken());// 로또 번호 초기화 1 <= arr[i] <= 49
			}
			
			combination(0, 6, 0);//조합 진행
			
			sb.append("\n");//출력 형식 맞춰주기
			st = new StringTokenizer(br.readLine());//다음줄 확인
		}
		
		System.out.println(sb);//출력
	}
	/**
	 * arr배열에서 start인덱스부터 r개의 원소를 뽑는 조합 메소드
	 * @param start : 시작 인덱스
	 * @param r : 뽑는 원소의 갯수
	 * @param flag : 뽑은 원소를 저장하는 변수
	 */
	private static void combination(int start, int r, int flag) {
		if (r==0) {
			for (int i = 0; i < arr.length; i++) {
				if ((flag&1<<i) !=0) {
					sb.append(arr[i]).append(" ");
				}
			}
			sb.setLength(sb.length()-1);
			sb.append("\n");
		}
		
		for (int i = start; i < arr.length; i++) {
			combination(i+1, r-1, flag|1<<i);
		}
	}
}
