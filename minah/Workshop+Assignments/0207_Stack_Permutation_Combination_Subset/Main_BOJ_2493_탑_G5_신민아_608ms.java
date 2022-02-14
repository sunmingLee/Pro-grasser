import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_BOJ_2493_탑_G5_신민아_608ms  {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int towerCount = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		// 배열을 넣기 싫어 만든 Tower class(구글선생님에게 굴복하지 않고 혼자 노력한 흔적입니다... 비효율적이지만요ㅠㅠ)
		Stack<Tower> tower = new Stack<Tower>();
		
		for(int i=0;i<towerCount;i++) { // tower의 개수만큼 반복
			int last = Integer.parseInt(st.nextToken());
			
			if(!(tower.isEmpty())) { // tower가 비지 않았을 때
				if(tower.peek().height < last) {  // 새로 들어온 탑이 남아있는 탑들 중 가장 마지막 탑보다 클 때
					
					while(!(tower.isEmpty()) && (tower.peek().height < last)) {
						tower.pop(); // 중간에 닿을 수 없는 작은 탑들을 stack에서 제거
					}
					
					// tower가 비었으면 0리턴, 비지 않았으면 남아있는 탑들 중 가장 마지막에 있는 탑(남아있는 탑 중 가장 가까우면서 새로운 탑보다 큰 탑)의 index 표시
					sb.append(tower.isEmpty() ? 0 : tower.peek().index).append(" ");
					
					tower.push(new Tower(i+1, last)); // 새로운 탑 넣기

				} else { // 새로 들어온 탑이 남아있는 탑 중 가장 마지막 탑보다 작을 때
					sb.append(tower.peek().index).append(" "); // 그대로 마지막 탑의 index 출력
					tower.push(new Tower(i+1, last)); // 새로 들어온 탑 넣기
				}
			} else { // tower가 비었을 때
				sb.append(0).append(" ");
				tower.push(new Tower(i+1, last)); // 새로운 탑 넣기
			}
		}
		
		System.out.print(sb.toString());
	}

}

// tower의 번호와 길이 보관 클래스
class Tower {
	int index;
	int height;
	
	Tower(int index, int height) {
		this.index = index;
		this.height = height;
	}
}