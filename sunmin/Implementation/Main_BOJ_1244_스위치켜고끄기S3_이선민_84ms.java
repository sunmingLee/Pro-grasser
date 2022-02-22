package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_1244_스위치켜고끄기S3_이선민_84ms {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int switchNum = Integer.parseInt(br.readLine()); // 스위치의 개수
		int[] state = new int[switchNum + 1]; // 스위치의 상태
		state[0] = -1; // 스위치0번은 없음

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i < state.length; i++) {
			state[i] = Integer.parseInt(st.nextToken());
		}

		int student = Integer.parseInt(br.readLine()); // 학생 수
		for (int i = 0; i < student; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int gender = Integer.parseInt(st.nextToken()); // 성별
			int num = Integer.parseInt(st.nextToken()); // 학생이 받은 수
			switch (gender) {
			case 1: // 남자
				boy(num, state);
				break;
			case 2: // 여자
				girl(num, state);
				break;
			default:
				break;
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < state.length; i++) {
			sb.append(state[i]).append(" ");
			if (i % 20 == 0) {
				sb.append("\n");
			}
		}
		System.out.print(sb);
	} // end of main

	private static void girl(int num, int[] state) {
		state[num] = state[num] == 0 ? 1 : 0;

		int i = 1;
		while (num - i > 0 && num + i < state.length && state[num - i] == state[num + i]) {
			state[num - i] = state[num + i] = state[num - i] == 0 ? 1 : 0;
			i++;
		}
	} // end of girl

	private static void boy(int num, int[] state) {
//		if (num == 1) { // 받은 수가 1일경우 모든 스위치의 상태를 바꿈
//			for (int j = 1; j < state.length; j++) {
//				state[j] = (state[j] == 0) ? 1 : 0;
//			}
//			return;
//		}

		for (int i = 1; num * i < state.length; i++) {
			state[num * i] = (state[num * i] == 0) ? 1 : 0;
		}
//		int i = 0;
//		while (i < state.length) {
//			state[num] = (state[num] == 0) ? 1 : 0;
//			i += num;
//		}
	} // end of boy

} // end of class
