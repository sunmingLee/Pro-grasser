package Programmers;

import java.util.*;

class Solution_신고결과받기 {
	public int[] solution(String[] id_list, String[] report, int k) {
		int[] answer = new int[id_list.length];
		int[][] reportCnt = new int[id_list.length][id_list.length];

		StringTokenizer st;
		for (int i = 0; i < report.length; i++) {
			st = new StringTokenizer(report[i], " ");
			int from = matchId(id_list, st.nextToken());
			int to = matchId(id_list, st.nextToken());

			if (reportCnt[from][to] == 0) {
				reportCnt[from][to]++;
			}
		}

		Queue<Integer> out = new ArrayDeque<>(); // 정지 당한 유저 목록
		for (int i = 0; i < id_list.length; i++) {
			int cnt = 0;
			for (int j = 0; j < id_list.length; j++) {
				cnt += reportCnt[j][i];
			}

			if (cnt >= k) {
				out.add(i);
			}
		}

		while (!out.isEmpty()) {
			int userIndex = out.poll();
			for (int i = 0; i < id_list.length; i++) {
				if (reportCnt[i][userIndex] != 0) {
					answer[i]++;
				}
			}
		}

		return answer;
	}

	/**
	 * name과 일치하는 id_list의 인덱스 반환
	 */
	public int matchId(String[] id_list, String name) {
		for (int i = 0; i < id_list.length; i++) {
			if (id_list[i].equals(name)) {
				return i;
			}
		}

		return -1;
	}
}