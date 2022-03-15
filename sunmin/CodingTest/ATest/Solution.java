import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Solution {
	static boolean side;
	static int pos1, pos2;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());

		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int[][] permu = { { 0, 1, 2 }, { 0, 2, 1 }, { 1, 0, 2 }, { 1, 2, 0 }, { 2, 0, 1 }, { 2, 1, 0 } };
		for (int test_case = 1; test_case <= TC; test_case++) {
			int N = Integer.parseInt(br.readLine()); // 낚시터의 개수

			int[] gate = new int[3]; // 출입구의 위치
			int[] person = new int[3]; // 출입구 당 낚시꾼의 수
			for (int i = 0; i < 3; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				gate[i] = Integer.parseInt(st.nextToken());
				person[i] = Integer.parseInt(st.nextToken());
			}

			int min = Integer.MAX_VALUE;
			for (int i = 0; i < 6; i++) {
				int ans = 0;
				boolean[] seat = new boolean[N + 1]; // 자리에 누가 앉아있으면 true
				side = false;
				int gate1 = findSeat(N, gate, person, permu[i][0], seat);
				ans += gate1;
				if (ans > min) {
					continue;
				}
				if (side) { // 첫번째 출입구의 마지막 사람의 양쪽이 모두 빈 경우
					// 첫번째 출입구의 왼쪽 자리에 앉을 경우
					int left1 = pos1;
					int right1 = pos2;
					boolean[] temp1 = Arrays.copyOf(seat, N+1);
					seat[left1] = true;
					side = false;
					int gate2 = findSeat(N, gate, person, permu[i][1], seat);
					ans = gate1+gate2;

					if (ans > min) {
						continue;
					}

					if (side) { // 두번째 출입구의 마지막 사람의 양쪽이 모두 빈 경우
						int left2 = pos1;
						int right2 = pos2;
						boolean[] temp2 = Arrays.copyOf(seat, N+1);
						seat[left2] = true;
						side = false;
						int gate3 =findSeat(N, gate, person, permu[i][2], seat); 
						ans = gate1+gate2+gate3;

						if (min > ans) {
							min = ans;
						}

						ans = gate1+gate2;
						// 오른쪽
						seat = temp2;
						seat[right2] = true;
						side = false;
						ans += findSeat(N, gate, person, permu[i][2], seat);
						if (min > ans) {
							min = ans;
						}
					} else {
						ans += findSeat(N, gate, person, permu[i][2], seat);
						if (min > ans) {
							min = ans;
						}
					}

					ans = gate1;
					// 첫번째 출입구의 오른쪽자리에 앉을 경우
					seat = temp1;
					seat[right1] = true;
					side = false;
					ans += findSeat(N, gate, person, permu[i][1], seat);

					if (ans > min) {
						continue;
					}
					if (side) { // 두번째 출입구의 마지막 사람의 양쪽이 모두 빈 경우
						int left2 = pos1;
						int right2 = pos2;
						boolean[] temp2 = Arrays.copyOf(seat, N+1);
						seat[left2] = true;
						side = false;
						int gate3=findSeat(N, gate, person, permu[i][2], seat); 
						ans += gate3;

						if (min > ans) {
							min = ans;
						}

						ans = gate1+gate2;
						// 오른쪽
						seat = temp2;
						seat[right2] = true;
						side = false;
						ans += findSeat(N, gate, person, permu[i][2], seat);
						if (min > ans) {
							min = ans;
						}
					} else {
						ans += findSeat(N, gate, person, permu[i][2], seat);
					}

				} else {
					ans += findSeat(N, gate, person, permu[i][1], seat);
					if (ans > min) {
						continue;
					}
					if (side) { // 두번째 출입구의 마지막 사람의 양쪽이 모두 빈 경우
						int left2 = pos1;
						int right2 = pos2;
						boolean[] temp = Arrays.copyOf(seat, N+1);
						seat[left2] = true;
						side = false;
						int gate3=findSeat(N, gate, person, permu[i][2], seat); 
						ans += gate3;

						if (min > ans) {
							min = ans;
						}

						// 오른쪽
						ans -= gate3;
						seat = temp;
						seat[right2] = true;
						side = false;
						ans += findSeat(N, gate, person, permu[i][2], seat);
						if (min > ans) {
							min = ans;
						}
					} else {
						ans += findSeat(N, gate, person, permu[i][2], seat);
					}

				}

				if (min > ans) {
					min = ans;
				}

			} // end of for loop

			sb.append("#").append(test_case).append(" ").append(min).append("\n");
		} // end of test_case
		System.out.print(sb.toString());
	} // end of main

	private static int findSeat(int N, int[] gate, int[] person, int gateNum, boolean[] seat) {
		int res = 0;
		int minus = 0;
		int pos = gate[gateNum];
		for (int i = 0; i < person[gateNum]; i++) {
			while (true) { // 자리를 찾을때까지 반복
				if (minus > 0) {
					pos1 = pos - minus; // 왼쪽자리
					pos2 = pos + minus; // 오른쪽자리

					if (i == person[gateNum] - 1) { // 마지막 사람
						if (pos1 > 0 && !seat[pos1] && pos2 <= N && !seat[pos2]) { // 양쪽 모두 비었을 경우
							side = true;
							break;
						}
					}

					if (pos1 > 0 && !seat[pos1]) {
						seat[pos1] = true;
						break;
					} else if (pos2 <= N && !seat[pos2]) {
						seat[pos2] = true;
						break;
					} else {
						minus++;
						continue;
					}
				}

				if (seat[pos]) {
					minus++;
					continue;
				}
				seat[pos] = true;
				break;
			} // end of while

			res += minus + 1;
		}
		return res;
	} // end of findSeat

} // end of class
