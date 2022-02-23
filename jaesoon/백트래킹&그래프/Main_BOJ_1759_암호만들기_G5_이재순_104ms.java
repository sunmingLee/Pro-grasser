import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BOJ_1759_암호만들기_G5_이재순_104ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int L = Integer.parseInt(st.nextToken());//3 ≤ L ≤ C ≤ 15
		int C = Integer.parseInt(st.nextToken());//3 ≤ L ≤ C ≤ 15
		st = new StringTokenizer(br.readLine());
		//배열 초기화
		char[] arr = new char[C];
		for (int i = 0; i < C; i++) {
			arr[i] = st.nextToken().charAt(0);
		}
		//정렬
		Arrays.sort(arr);
		//프로세스 진행 및 정답 출력
		char[] ans = new char[L];
		System.out.print(combination(0, 0, C, ans, arr, L, 0, 0));
	}
	
	private static String combination(int cnt, int start, int end, char[] ans, char[] arr, int L, int consonant, int vowel) {
		StringBuilder sb = new StringBuilder();
		if (cnt == L) {//L개를 뽑았을 경우 진행
			if (vowel<1||consonant<2) {//자음이 최소 두개, 모음이 최소 한개인지 확인
				return "";
			}
			sb.append(ans);//출력 형식에 맞게 배열을 append
			sb.append("\n");
			return sb.toString();
		}
		for (int i = start; i < end; i++) {
			ans[cnt]=arr[i];
			switch (arr[i]) {
			case 'a':
			case 'e':
			case 'i':
			case 'o':
			case 'u':
				sb.append(combination(cnt+1, i+1, end, ans, arr, L, consonant, vowel+1));//모음일경우의 재귀
				break;
			default:
				sb.append(combination(cnt+1, i+1, end, ans, arr, L, consonant+1, vowel));//자음일경우의 재귀
				break;
			}
		}
		return sb.toString();
	}
}
