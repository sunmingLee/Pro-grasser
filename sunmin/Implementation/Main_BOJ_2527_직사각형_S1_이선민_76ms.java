package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_2527_직사각형_S1_이선민_76ms {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int[] rec1 = new int[4]; // 첫번째 사각형의 x,y,p,q
		int[] rec2 = new int[4]; // 두번째 사각형의 x,y,p,q
		for (int i = 0; i < 4; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 4; j++) {
				rec1[j] = Integer.parseInt(st.nextToken());
			}
			for (int j = 0; j < 4; j++) {
				rec2[j] = Integer.parseInt(st.nextToken());
			}

			// 더 왼쪽에 있는 직사각형이 rec1이 되도록
			if (rec2[0] < rec1[0]) {
				int[] temp = rec1;
				rec1 = rec2;
				rec2 = temp;
			}


			// d인 경우
			if (rec1[2] < rec2[0] || rec1[1] > rec2[3] || rec1[3] < rec2[1]) {
				sb.append("d");
			}
			// c인 경우
			else if ((rec1[1] == rec2[3] || rec1[3] == rec2[1]) && rec1[2] == rec2[0]) {
				sb.append("c");
			}
			// b인 경우
			else if (rec1[1] == rec2[3] || rec1[3] == rec2[1] || rec1[2] == rec2[0]) {
				sb.append("b");
			}
			// a인 경우
			else {
				sb.append("a");
			}
			sb.append("\n");
		} // end of testcase
		System.out.print(sb.toString());
	} // end of main

}
