import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BOJ_2437_저울_G3_이재순_84ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] chu = new int[N];// 추의 무게를 담는 배열
		for (int i = 0; i < N; i++) {
			chu[i] = Integer.parseInt(st.nextToken());//추의 무게 입력
		}
		Arrays.sort(chu);//무게 순으로 오름차순 정렬
		int sum = 0;//추 무게의 누적합
		for (int i = 0; i < N; i++) {
			if (chu[i]>sum+1) break;//추 무게의 누적합 + 1 보다 다음추의 무게가 더 크다면 break
			sum+=chu[i];//추 무게 누적
		}
		System.out.println(sum+1);//정답 출력
	}
}
