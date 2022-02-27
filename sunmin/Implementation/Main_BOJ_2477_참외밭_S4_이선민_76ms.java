package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_2477_참외밭_S4_이선민_76ms {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine()); // 1m^2의 넓이에 자라는 참외의 개수

		int maxGaro = 0; // 가로 최장길이
		int maxSero = 0; // 세로 최장길이

		StringTokenizer st;
		int[][] line = new int[6][2]; // 0열 : 방향, 1열 : 길이
		for (int i = 0; i < 6; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int way = Integer.parseInt(st.nextToken());
			int length = Integer.parseInt(st.nextToken());
			line[i][0] = way;
			line[i][1] = length;

			if ((way == 3 || way == 4) && maxSero < length) {
				maxSero = length;
			} else if ((way == 1 || way == 2) && maxGaro < length) {
				maxGaro = length;
			}
		}

		int emptyGaro = 0, emptySero = 0; // 빼줘야하는 면적의 가로, 세로길이
		for (int i = 0; i < 6; i++) {
			// 세로최장길이 바로 다음으로 가로최장길이가 나온다면 'ㄱ' or 'ㄴ' 모양임
			if ((line[i][0] == 3 || line[i][0] == 4) && line[i][1] == maxSero) {
				if (line[(i + 1) % 6][1] == maxGaro) {
					emptyGaro = line[(i + 3) % 6][1];
					emptySero = line[(i + 4) % 6][1];
					break;
				}
			}

			// 가로최장길이 바로 다음으로 세로최장길이가 나온다면 '┏' or '┛' 모양임
			else if ((line[i][0] == 1 || line[i][0] == 2) && line[i][1] == maxGaro) {
				if (line[(i + 1) % 6][1] == maxSero) {
					emptySero = line[(i + 3) % 6][1];
					emptyGaro = line[(i + 4) % 6][1];
					break;
				}
			}
		}
		System.out.print((maxGaro * maxSero - emptyGaro * emptySero) * K);
	} // end of main
} // end of class
