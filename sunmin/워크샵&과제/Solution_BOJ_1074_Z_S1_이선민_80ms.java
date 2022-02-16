import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_BOJ_1074_Z_S1_이선민_80ms {

	static int r, c, cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 배열의 크기 : 2^N * 2^N
		r = Integer.parseInt(st.nextToken()); // 방문 순서를 찾아야 할 행
		c = Integer.parseInt(st.nextToken()); // 방문 순서를 찾아야 할 열
		cnt = 0; // 방문한 횟수

		recursion(N);
		System.out.println(cnt);
	} // end of main

	private static void recursion(int N) {
		if (N == 0) {
			return;
		}

		// 구역에 따라 행과 열을 바꿔줘야 다음 재귀를 돌릴때도 동일한 동작을 함
		int location; // 4구역 중 찾으려는 칸이 위치하는 구역 (왼쪽위부터 z모양 순서대로)
		int half = (int) Math.pow(2, N - 1);
		if (r < half) {
			if (c < half) {
				location = 1;
			} else {
				location = 2;
				c -= half;
			}
		} else {
			if (c < half) {
				location = 3;
			} else {
				location = 4;
				c -= half;
			}
			r -= half;
		}

		switch (location) {
		case 1:
			break;
		case 2:
			cnt += (int) Math.pow(half, 2);
			break;
		case 3:
			cnt += (int) Math.pow(half, 2) * 2;
			break;
		case 4:
			cnt += (int) Math.pow(half, 2) * 3;
			break;
		default:
			break;
		}

		recursion(N - 1);
	} // end of recursion

} // end of class
