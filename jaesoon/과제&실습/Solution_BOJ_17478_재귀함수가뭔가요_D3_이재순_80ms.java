import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_BOJ_17478_재귀함수가뭔가요_D3_이재순_80ms {
	static StringBuilder str = new StringBuilder();
	static StringBuilder str1 = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		str1.append("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n");
		recursive(Integer.parseInt(br.readLine()));
		System.out.print(str1);
	}
	private static void recursive(int num) {
		str1.append(str);
		str1.append("\"재귀함수가 뭔가요?\"\n");
		str1.append(str);
		if (num!=0) {
			str1.append("\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n");
			str1.append(str);
			str1.append("마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n");
			str1.append(str);
			str1.append("그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n");
			str.append("____");
		}else {
			str1.append("\"재귀함수는 자기 자신을 호출하는 함수라네\"");
			str.append("____");
		}
		if (num>0) {
			recursive(num-1);
		}
		str.setLength(str.length()-4);
		str1.append("\n"+str);
		str1.append("라고 답변하였지.");
	}
}