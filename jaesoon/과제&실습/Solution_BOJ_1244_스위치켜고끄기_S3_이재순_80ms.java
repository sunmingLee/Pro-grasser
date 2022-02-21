import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_BOJ_1244_스위치켜고끄기_S3_이재순_80ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine())+1;
		int[] switches = new int[N];
		switches[0]=2;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i < N; i++) {
			switches[i] = Integer.parseInt(st.nextToken());
		}
		int std = Integer.parseInt(br.readLine());
		for (int i = 0; i < std; i++) {
			st = new StringTokenizer(br.readLine());
			switch (st.nextToken()) {
			case "1":
				int a = Integer.parseInt(st.nextToken());
				for (int j = a; j < N; j+=a) switches[j] = (switches[j]+1)%2; 
				break;
			case "2":
				int b = Integer.parseInt(st.nextToken());
				switches[b] = (switches[b]+1)%2;
				int c = b;
				try {
					while (true) {
						if (switches[--b]==switches[++c]) {
							switches[b] = (switches[b]+1)%2;
							switches[c] = switches[b];
						}else break;
					}
				} catch (Exception e) {}
				break;
			}
		}
		int cnt=0;
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < N; i++) {
			sb.append(switches[i]).append(" ");
			if (++cnt == 20) {
				sb.setLength(sb.length()-1);
				sb.append("\n");
				cnt = 0;
			}
		}
		System.out.println(sb);
	}
}
