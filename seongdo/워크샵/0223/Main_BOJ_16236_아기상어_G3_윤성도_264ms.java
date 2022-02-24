package com.ssafy.BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

public class Main_BOJ_16236_아기상어_G3_윤성도_264ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N, map[][], i, j, r = 0, c = 0, time = 0, size = 2, eat = 0, chk[] = new int[7], dis = 1;
		int dr[] = { 0, -1, 0, 1 }, dc[] = { -1, 0, 1, 0 };
		String input;
		Queue<Integer[]> q = new ArrayDeque<Integer[]>();
		ArrayList<Integer[]> fish = new ArrayList<>();
		boolean[][] visit;

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (i = 0; i < N; i++) {
			input = br.readLine();
			for (j = 0; j < N; j++) {
				map[i][j] = input.charAt(j << 1) - '0';
				if (map[i][j] == 9) {
					r = i;
					c = j;
					map[i][j] = 0;
				}
				chk[map[i][j]]++;
			}
		}

		q.offer(new Integer[] { r, c });
		visit = new boolean[N][N];
		visit[r][c] = true;
		if (chk[1] == 0) {
			System.out.print(0);
			return;
		}
		while (!q.isEmpty()) {
			int len = q.size();
			for (i = 0; i < len; i++) {
				Integer[] tmp = q.poll();
				for (j = 0; j < 4; j++) {
					r = tmp[0] + dr[j];
					c = tmp[1] + dc[j];
					try {
						if (visit[r][c] || map[r][c] > size)
							continue;
						visit[r][c] = true;
						if (1 <= map[r][c] && map[r][c] < size)
							fish.add(new Integer[] { r, c });
						else if (fish.isEmpty())
							q.offer(new Integer[] { r, c });
					} catch (Exception e) {
					}
				}
			}
			if (fish.isEmpty()) {
				dis++;
				continue;
			}
			fish.sort((a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
			for (i = 0; i < N; i++)
				Arrays.fill(visit[i], false);
			visit[fish.get(0)[0]][fish.get(0)[1]] = true;
			map[fish.get(0)[0]][fish.get(0)[1]] = 0;
			q.clear();
			q.offer(fish.get(0));
			chk[map[fish.get(0)[0]][fish.get(0)[1]]]--;
			fish.clear();
			time += dis;
			dis = 1;
			if (++eat == size) {
				size = size == 7 ? 7 : size + 1;
				eat = 0;
			}
			int sum = 0;
			for (i = 1; i < size; i++)
				sum += chk[i];
			if (sum == 0)
				break;
		}
		System.out.print(time);
	}
}
