import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_SWEA_5644_무선충전_이선민_123ms {
	static int answer;
	static int[][] userLocation, BC;
	static ArrayList[] chargeable;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수

		int[][] user;
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken()); // 사용자의 이동 시간(20 ≤ M ≤ 100)
			int A = Integer.parseInt(st.nextToken()); // BC의 개수(1 ≤ A ≤ 8)

			user = new int[M + 1][2]; // 사용자들의 이동 정보(0열은 A, 1열은 B)
			for (int i = 0; i < 2; i++) {
				user[0][i] = 0; // 0초부터 시작하므로 맨처음 0을 넣어준다
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j < M + 1; j++) {
					user[j][i] = Integer.parseInt(st.nextToken());
				}
			}

			BC = new int[A][4]; // 배터리 정보 저장(0열부터 배터리의 x좌표, y좌표, 충전범위, 성능)
			for (int i = 0; i < A; i++) {
				st = new StringTokenizer(br.readLine());
				BC[i][0] = Integer.parseInt(st.nextToken());
				BC[i][1] = Integer.parseInt(st.nextToken());
				BC[i][2] = Integer.parseInt(st.nextToken());
				BC[i][3] = Integer.parseInt(st.nextToken());
			}

			userLocation = new int[2][2]; // 사용자들의 현재 위치좌표(0행은 A, 1행은 B / 열이 x,y)
			// 사용자A는 (1,1)에서, 사용자B는 (10,10)에서 출발
			userLocation[0][0] = 1;
			userLocation[0][1] = 1;
			userLocation[1][0] = 10;
			userLocation[1][1] = 10;

			// 인덱스0: 사용자A가 사용가능한 BC의 리스트 / 인덱스1: 사용자B가 사용가능한 BC의 리스트
			chargeable = new ArrayList[2];
			for (int i = 0; i < 2; i++) {
				chargeable[i] = new ArrayList<Integer>();
			}

			answer = 0; // 모든 사용자가 충전한 양의 합의 최댓값

			for (int i = 0; i < M + 1; i++) {
				move(user[i][0], 0); // A 이동
				move(user[i][1], 1); // B 이동

				for (int j = 0; j < A; j++) {
					for (int k = 0; k < 2; k++) {
						int distance = Math.abs(userLocation[k][0] - BC[j][0])
								+ Math.abs(userLocation[k][1] - BC[j][1]); // BC와 사용자간의 거리

						if (distance <= BC[j][2]) { // 거리가 충전범위 내라면 리스트에 삽입
							chargeable[k].add(j);
						}
					}
				} // 사용자가 이용가능한 모든 BC 체크 완료

				charge();
			} // M번 이동 완료

			sb.append("#").append(test_case).append(" ").append(answer).append("\n");
		} // end of testcase
		System.out.print(sb);
	} // end of main

	private static void charge() {
		ArrayList<Integer> userA = chargeable[0]; // A가 사용가능한 BC
		ArrayList<Integer> userB = chargeable[1]; // B가 사용가능한 BC
		int max, tempA, tempB, temp;

		// 두 사용자 모두 사용가능한 BC가 없다면
		if (userA.size() == 0 && userB.size() == 0) {
			return;
		}

		// A만 사용가능한 BC가 있다면
		else if (userA.size() > 0 && userB.size() == 0) {
			// A가 사용가능한 BC가 1개뿐
			if (userA.size() == 1) {
				answer += BC[userA.get(0)][3]; // 해당 배터리의 충전 양만큼 더해줌
			} else { // A가 사용가능한 BC가 여러개라면 그 중 가장 충전률이 높은 BC 선택
				max = BC[userA.get(0)][3];
				for (int i = 1; i < userA.size(); i++) {
					max = BC[userA.get(i)][3] > max ? BC[userA.get(i)][3] : max;
				}

				answer += max;
			}
		}

		// B만 사용가능한 BC가 있다면
		else if (userA.size() == 0 && userB.size() > 0) {
			// B가 사용가능한 BC가 1개뿐
			if (userB.size() == 1) {
				answer += BC[userB.get(0)][3]; // 해당 배터리의 충전 양만큼 더해줌
			} else { // B가 사용가능한 BC가 여러개라면 그 중 가장 충전률이 높은 BC 선택
				max = BC[userB.get(0)][3];
				for (int i = 1; i < userB.size(); i++) {
					max = BC[userB.get(i)][3] > max ? BC[userB.get(i)][3] : max;
				}

				answer += max;
			}
		}

		// A와 B 모두 사용가능한 BC가 있다면
		else {
			max = 0;
			for (int i = 0; i < userA.size(); i++) {
				tempA = BC[userA.get(i)][3];
				for (int j = 0; j < userB.size(); j++) {
					tempB = BC[userB.get(j)][3];

					if (userA.get(i) == userB.get(j)) { // 같은 BC를 선택했다면(BC의 번호가 같다면)
						temp = (tempA + tempB) / 2;
					} else {
						temp = tempA + tempB;
					}

					max = temp > max ? temp : max; // 결과값 중 더 큰값 저장
				}
			}

			answer += max;
		}

		// 충전 완료 후에는 리스트를 비워줌
		chargeable[0].clear();
		chargeable[1].clear();
	} // end of charge

	private static void move(int way, int user) { // 움직일 방향과 움직일 사용자(좌표 주의!!!!)
		switch (way) {
		case 1: // 위로 이동
			userLocation[user][1] -= 1;
			break;
		case 2: // 오른쪽으로 이동
			userLocation[user][0] += 1;
			break;
		case 3: // 아래로 이동
			userLocation[user][1] += 1;
			break;
		case 4: // 왼쪽으로 이동
			userLocation[user][0] -= 1;
			break;
		default: // 0이면 이동하지 않음
			break;
		}
	} // end of move

} // end of class
