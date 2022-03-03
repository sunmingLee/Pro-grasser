import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_BOJ_3040_백설공주와일곱난쟁이_B2_이재순_72ms {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int[] dwarfs = new int[9];//난쟁이의 숫자를 저장할 배열 선언
		boolean[] isNotDwarf = new boolean[9];//난쟁이가 맞는지 저장할 배열 선언
		int sum = 0;//숫자 합을 저장할 변수 
		for (int i = 0; i < 9; i++) { //난쟁이의 숫자 9만큼 반복
			dwarfs[i] = Integer.parseInt(br.readLine()); //난쟁이의 숫자 입력
			sum+=dwarfs[i]; //난쟁이의 숫자 누적
		}
		Arrays.sort(dwarfs);
		int target = sum -100;//합이 100인 7명이 진짜 난쟁이 이므로 (전체합-100) = (가짜난쟁이 두명의 합)= 타겟 합으로 설정함
		sum = 0; //가짜난쟁이 판별을 위한 누적합으로 재사용
loop:	for (int i = 0; i < 9; i++) {//난쟁이의 숫자 9만큼 반복
			sum += dwarfs[i];//첫번째 가짜 난쟁이(가정) 합 누적
			for (int j = i+1; j < 9; j++) {//i번째부터 9미만까지 반복하여 9명의 난쟁이중 2명을 뽑는 조합 구현
				sum+= dwarfs[j];//두번째 가짜 난쟁이(가정) 합 누적
				if (sum == target) {//가짜 난쟁이의 합이 타겟과 같으면 진행
					isNotDwarf[i] = true;
					isNotDwarf[j] = true;
					break loop;
				}
				sum -=dwarfs[j];//답이 아니므로 합 복원
			}
			sum -= dwarfs[i];//답이 아니므로 합 복원
		}
		//진짜 난쟁이 출력
		for (int i = 0; i < 9; i++) {
			if (!isNotDwarf[i]) {
				sb.append(dwarfs[i]).append("\n");
			}
		}
		System.out.print(sb);//출력
	}//end of main
}//end of class
