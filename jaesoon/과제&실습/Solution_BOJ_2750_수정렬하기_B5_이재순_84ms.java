import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_BOJ_2750_수정렬하기_B5_이재순_84ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(br.readLine());
		Arrays.sort(arr);
		StringBuilder sb = new StringBuilder();
		for (int i : arr) sb.append(i).append("\n");
		System.out.print(sb);
	}
}
