import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BOJ_2437_저울_G3_이재순_2312ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] chu = new int[N];
		for (int i = 0; i < N; i++) {
			chu[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(chu);
		boolean[] possible = new boolean[104857600];
		possible[0]=true;
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(0);
		int start = 0;
		int ans=0;
		boolean flag = false;
loop:	for (int i = 0; i < N; i++) {
			int cur = chu[i];
			for (int j = start+1; j < cur; j++) {
				if (!possible[j]) {
					ans = j;
					flag = true;
					break loop;
				}
			}
			int listsize = list.size();
			for (int j = 0; j < listsize; j++) {
				int temp = list.get(j)+cur;
				if (!possible[temp]) {
					list.add(temp);
					possible[temp] = true;
				}
			}
			start = cur;
		}
		if (!flag) {
			int i=0;
			while (true) {
				if (possible[i]) {
					i++;
				}else {
					ans = i;
					break;
				}
			}
		}
		System.out.println(ans);
	}
}
