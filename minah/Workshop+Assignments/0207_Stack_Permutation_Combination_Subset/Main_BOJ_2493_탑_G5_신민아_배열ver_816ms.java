import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_BOJ_2493_탑_G5_신민아_배열ver_816ms  {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int towerCount = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		// 구글 선생님이 제시한 Stack에 배열넣기(이것만 구글 선생님의 도움을 받았습니다..)
		Stack<int[]> tower = new Stack<int[]>();
		
		for(int i=0;i<towerCount;i++) { // tower의 개수만큼 반복
			int last = Integer.parseInt(st.nextToken());
			
			if(!(tower.isEmpty())) { // tower가 비지 않았을 때
				if(tower.peek()[1] < last) {  // 새로 들어온 탑이 남아있는 탑들 중 가장 마지막 탑보다 클 때
					
					while(!(tower.isEmpty()) && (tower.peek()[1] < last)) {
						tower.pop(); // 중간에 닿을 수 없는 작은 탑들을 stack에서 제거
					}
					
					// tower가 비었으면 0리턴, 비지 않았으면 남아있는 탑들 중 가장 마지막에 있는 탑(남아있는 탑 중 가장 가까우면서 새로운 탑보다 큰 탑)의 index 표시
					sb.append(tower.isEmpty() ? 0 : tower.peek()[0]).append(" ");
					
					tower.push(new int[] {i+1, last}); // 새로운 탑 넣기

				} else { // 새로 들어온 탑이 남아있는 탑 중 가장 마지막 탑보다 작을 때
					sb.append(tower.peek()[0]).append(" "); // 그대로 마지막 탑의 index 출력
					tower.push(new int[] {i+1, last}); // 새로 들어온 탑 넣기
				}
			} else { // tower가 비었을 때
				sb.append(0).append(" ");
				tower.push(new int[] {i+1, last}); // 새로운 탑 넣기
			}
		}
		
		System.out.print(sb.toString());
	}

}