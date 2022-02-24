import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_JO_1681_해밀턴순환회로_이재순_135ms {
	static Node[] nodes;
	private static int[] toCompany;
	static int ans= Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());//1≤N≤13
		StringTokenizer st;
		nodes = new Node[N];//회사와 배송지들을 저장하는 노드배열 (nodes[0] : 회사)
		toCompany = new int[N];//각 배송지에서 회사로 돌아오는 거리를 저장하는 배열 
		//배열 초기화
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0, temp; j < N; j++) {
				if ((temp = Integer.parseInt(st.nextToken()))!=0) {
					if (j==0) toCompany[i]=temp;//회사로 돌아오는 길이면 toCompany에 저장
					else nodes[i] = new Node(j, temp, nodes[i]);//회사로 오는 길이 아니면 node에 기록
				}
			}
		}
		//프로세스 진행
		findRoute(0, 0, (1<<N)-2, 0);
		//출력
		System.out.println(ans);
	}
	/**
	 * 최적루트의 이동거리를 ans에 저장해주는 메소드
	 * @param cur : 현재 위치(0:회사, 나머지:배송지)
	 * @param flag : 방문체크를 위한 flag
	 * @param endFlag : 모든 배송지를 방문했을때의 flag (cnt로 해줘도 되는데 cnt 안쓰려고 시도해봄)
	 * @param sumWeight : 이동한 누적 거리
	 */
	private static void findRoute(int cur, int flag, int endFlag, int sumWeight) {
		if (sumWeight>ans) return;//지금까지 최소 배송거리보다 이미 이동한 거리가 크다면 return(백트래킹)
		if (flag==endFlag&&toCompany[cur]!=0) {//모든 배송지를 돌았고 마지망 배송지에서 회사에 돌아갈수 있으면 진행
			ans = Math.min(ans, sumWeight+toCompany[cur]);//ans갱신
			return;
		}
		Node testnode = nodes[cur];
		do {
			if ((flag&1<<testnode.vertex)==0) {//이동한적이 없는 노드라면 진행
				findRoute(testnode.vertex, flag|1<<testnode.vertex, endFlag, sumWeight+testnode.weight);//재귀
			}
		}while((testnode = testnode.next)!=null);//더이상 이동할수 있는 곳이 없다면 나가기
	}
}
/**
 * 배송지와 회사의 정보를 기록하는 노드. head노드에서 vertex로 이동하는 거리가 weight이다.
 */
class Node {
	int vertex, weight;
	Node next;
	public Node(int vertex, int weight, Node next) {
		this.vertex = vertex;
		this.weight = weight;
		this.next = next;
	}
}
