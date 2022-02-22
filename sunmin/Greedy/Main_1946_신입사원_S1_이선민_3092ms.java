package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * 언제나 최고만을 지향하는 굴지의 대기업 진영 주식회사가 신규 사원 채용을 실시한다. 인재 선발 시험은 1차 서류심사와 2차 면접시험으로
 * 이루어진다. 최고만을 지향한다는 기업의 이념에 따라 그들은 최고의 인재들만을 사원으로 선발하고 싶어 한다.
 * 
 * 그래서 진영 주식회사는, 다른 모든 지원자와 비교했을 때 서류심사 성적과 면접시험 성적 중 적어도 하나가 다른 지원자보다 떨어지지 않는
 * 자만 선발한다는 원칙을 세웠다. 즉, 어떤 지원자 A의 성적이 다른 어떤 지원자 B의 성적에 비해 서류 심사 결과와 면접 성적이 모두
 * 떨어진다면 A는 결코 선발되지 않는다.
 * 
 * 이러한 조건을 만족시키면서, 진영 주식회사가 이번 신규 사원 채용에서 선발할 수 있는 신입사원의 최대 인원수를 구하는 프로그램을
 * 작성하시오.
 *
 */
public class Main_1946_신입사원_S1_이선민_3092ms {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine()); // 테스트케이스의 개수(1 ≤ T ≤ 20)
		int[][] grade;
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine()); // 지원자의 숫자(1 ≤ N ≤ 100,000)
			grade = new int[N][2]; // 지원자의 1차, 2차 성적
			for (int i = 0; i < grade.length; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				grade[i][0] = Integer.parseInt(st.nextToken()); // 1차 성적
				grade[i][1] = Integer.parseInt(st.nextToken()); // 2차 성적
			}

			Arrays.sort(grade, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					return Integer.compare(o1[0], o2[0]); // 1차 성적의 오름차순으로 정렬
				}
			});

			int ans = 1;	// 1차 성적 1등인 사람 미리 더해줌 
			int min = grade[0][1]; // 2차 성적 중 최소값
			for (int i = 1; i < grade.length; i++) {
				if (grade[i][1] < min) {
					ans++;
					min = grade[i][1];	// 최소값 갱신
				}
			}

			sb.append(ans).append("\n");
		} // end of testcase
		System.out.print(sb);

	} // end of main

} // end of class
