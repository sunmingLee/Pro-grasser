import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_1043_거짓말_G4_이재순_80ms {
	private static int[] parents;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		//선언 및 초기화
		int N = Integer.parseInt(st.nextToken());//사람 수, 1<=N<=50
		int M = Integer.parseInt(st.nextToken());//파티 수, 1<=M<=50
		parents = new int[N+1];//서로소집합을 만들기 위한 배열
		for (int i = 1; i <= N; i++) parents[i] = i;
		boolean[] knowTruth = new boolean[N+1];//진실을 아는사람 : true
		st = new StringTokenizer(br.readLine());//진실을 아는 사람의 수 0 <= x <= 50
		for (int i = 0, r = Integer.parseInt(st.nextToken()); i < r; i++) knowTruth[Integer.parseInt(st.nextToken())] = true;
		int[] head = new int[M]; //각 파티의 첫번째 사람을 저장하는 배열
		//프로세스 진행
		for (int i = 0; i < M; i++) {//파티 수만큼 반복
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken())-1; //파티에 오는 사람의 수 1 <= x <= 50
			head[i] = Integer.parseInt(st.nextToken());
			int bRoot = findset(head[i]);//파티에 참석한 첫번째 사람의 root
			for (int j = 0; j < r; j++) {
				unionset(Integer.parseInt(st.nextToken()), bRoot, knowTruth);//파티 구성원을 head[i]의 root에 모두 union
			}
		}
		//출력
		int ans = 0;
		for (int i = 0; i < M; i++) if (!knowTruth[findset(head[i])]) ans++;//각파티의 첫번째 사람이 속한 그룹이 진실을 모른다면 ans++
		System.out.println(ans);
	}
	
	/** a의 root를찾아서 리턴해주는 메소드 */
	private static int findset(int a) {
		if (a == parents[a]) {
			return a;
		}
		return parents[a] = findset(parents[a]);
	}
	
	/** a와 bRoot가 서로 다른 서로소집합에 포함되어있다면 두 집합을 합치고 진실을 알고있다면 knowTruth를 기록하는 메소드 */
	private static boolean unionset(int a, int bRoot, boolean[] knowTruth) {
		int aRoot = findset(a);
		if (aRoot == bRoot) {
			return false;
		}
		if (knowTruth[aRoot]) knowTruth[bRoot] = true;
		parents[aRoot] = bRoot;
		return true;
	}
}
