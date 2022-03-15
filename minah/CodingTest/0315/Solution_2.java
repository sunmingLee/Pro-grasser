import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution2 {
	static int answer;

	static class Loc {
		int r;
		int c;

		public Loc(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		for (int t = 1; t <= TC; t++) {
			answer = Integer.MAX_VALUE;

			int size = Integer.parseInt(br.readLine());
			int[][] map = new int[size][size];

			Loc[] monster = new Loc[5];
			Loc[] customer = new Loc[5];
			int count = 0;

			for (int i = 0; i < size; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < size; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] > 0) {
						monster[map[i][j]] = new Loc(i, j);
						count++;
					} else if (map[i][j] < 0) {
						customer[-map[i][j]] = new Loc(i, j);
					}
				}
			}

			int[] path = new int[count * 2];
			int number = 1;
			for (int i = 0; i < count * 2; i++) {
				path[i] = number;
				path[++i] = -(number);
				number++;
			}

			permutation(path, 0, monster, customer);
			
			sb.append("#").append(t).append(" ").append(answer).append("\n");
		}

		System.out.print(sb.toString());
	}

	static void permutation(int[] path, int l, Loc[] monster, Loc[] customer) {
		if (l == path.length) {
			
			if(isAvailable(path)) {
				Loc cur = new Loc(0, 0);
				int distance = 0;
				for(int i=0;i<path.length;i++) {
					Loc next;
					if(path[i] < 0)
						next = customer[-path[i]];
					else
						next = monster[path[i]];
					
					distance += Math.abs(cur.r - next.r) + Math.abs(cur.c - next.c);
					
					cur = next;
					
					if(distance >= answer)
						return;
				}
				if(distance < answer) {
					answer = distance;
				}
			}
			return;
		}

		for (int i = l; i < path.length; i++) {
			swap(path, l, i);
			permutation(path, l + 1, monster, customer);
			swap(path, l, i);
		}

	}

	private static boolean isAvailable(int path[]) {
		boolean[] check = new boolean[path.length / 2 + 1];
		for (int i = 0; i < path.length; i++) {
			if (path[i] > 0) {
				check[path[i]] = true;
			} else {
				if (!check[-path[i]])
					return false;
			}
		}
		return true;
	}

	static void swap(int[] path, int x, int y) {
		int temp = path[x];
		path[x] = path[y];
		path[y] = temp;
	}

}
