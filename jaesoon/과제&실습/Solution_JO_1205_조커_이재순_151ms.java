import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Solution_JO_1205_조커_이재순_151ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		boolean[] cards = new boolean[1000001];
		int jokers = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0, temp; i < N; i++) {
			if ((temp = Integer.parseInt(st.nextToken()))==0) jokers++;
			else cards[temp] = true;
		}
		ArrayDeque<Cardset> q = new ArrayDeque<Cardset>();
		for (int i = 1; i < 1000001; i++) {
			if (cards[i]) {
				int start = i;
				while (++i<1000001&&cards[i]) {}
				q.offer(new Cardset(start, i-start));
			}
		}
		if (q.isEmpty()) {
			System.out.println(jokers);
			System.exit(0);
		}
		
		ArrayDeque<Cardset> pickedQ = new ArrayDeque<Cardset>();
		int ans =0;
		int tempLength = 0;
		int remainJoker = jokers;
		Cardset a = q.poll();
		pickedQ.offer(a);
		while (!q.isEmpty()) {
			Cardset next = q.poll();
			if (next.start - (a.start + a.length) > remainJoker) {
				if ((tempLength = a.start - pickedQ.peek().start + a.length + remainJoker) > ans) {
					ans = tempLength;
				}
				while (next.start - (a.start + a.length) > remainJoker && !pickedQ.isEmpty()) {
					Cardset previous = pickedQ.poll();
					if(!pickedQ.isEmpty()) remainJoker += pickedQ.peek().start - (previous.start + previous.length);
				}
			}
			if (!pickedQ.isEmpty())
				remainJoker -= next.start - (a.start + a.length);
			a = next;
			pickedQ.offer(a);
		}
		if ((tempLength = pickedQ.peekLast().start - pickedQ.peek().start + pickedQ.peekLast().length + remainJoker) > ans) {
			ans = tempLength;
		}
		System.out.println(ans);
	}
	
	static class Cardset {
		int start, length;
		public Cardset(int start, int length) {
			this.start = start;
			this.length = length;
		}
	}
}
