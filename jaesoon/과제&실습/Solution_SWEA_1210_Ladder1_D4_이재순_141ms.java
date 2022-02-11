import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution_SWEA_1210_Ladder1_D4_이재순_141ms {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		ArrayList<Integer> gidoong = new ArrayList<Integer>();
		Stack<Integer>[] stack; // = new Stack<Integer>[cnt+1];
		String[][] map = new String[100][100];
		int cnt = 0;
		for (int testcase = 0; testcase < 10; testcase++) {
			br.readLine();
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 100; i++) {
				map[0][i] = st.nextToken();
				if (map[0][i].equals("1")) {
					gidoong.add(i);
					cnt++;
				}
			}
			for (int i = 1; i < 99; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 100; j++) {
					map[i][j] = st.nextToken();
				}
			}
			String temp;
			int targetIdx=0;
			int curGidoongIdx=0;
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 100; i++) {
				if ((temp =st.nextToken()).equals("1")) {
					targetIdx++;
				}
				if(temp.equals("2")) curGidoongIdx = targetIdx;
				map[99][i] = temp;
			}
			stack = new Stack[cnt + 1];
			stack[0] = new Stack<Integer>();
			stack[cnt] = new Stack<Integer>();
			for (int i = 1; i < cnt; i++) {
				int tempidx = gidoong.get(i - 1) + 1;
				stack[i] = new Stack<>();
				for (int j = 0; j < 100; j++) {
					if (map[j][tempidx].equals("1")) {
						stack[i].push(j);
					}
				}
			}
			int height = 99;
			while (!stack[curGidoongIdx].isEmpty()||!stack[curGidoongIdx+1].isEmpty()) {
				int leftTemp=0, rightTemp=0;
				while (!stack[curGidoongIdx].isEmpty()) {
					if (stack[curGidoongIdx].peek()>height) {
						stack[curGidoongIdx].pop();
					}else {
						leftTemp = stack[curGidoongIdx].peek();
						break;
					}
				}
				while (!stack[curGidoongIdx+1].isEmpty()) {
					if (stack[curGidoongIdx+1].peek()>height) {
						stack[curGidoongIdx+1].pop();
					}else {
						rightTemp = stack[curGidoongIdx+1].peek();
						break;
					}
				}
				if (leftTemp>rightTemp) {
					height = leftTemp;
					stack[curGidoongIdx].pop();
					curGidoongIdx--;
				}
				else if (rightTemp>leftTemp) {
					height = rightTemp;
					stack[curGidoongIdx+1].pop();
					curGidoongIdx++;
				}
			}
			sb.append("#").append(testcase+1).append(" ").append(gidoong.get(curGidoongIdx)).append("\n");
			cnt = 0;
			gidoong.clear();
		}
		System.out.print(sb);
	}// end of main
}// end of class