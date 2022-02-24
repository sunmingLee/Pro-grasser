package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * flat하게 생각 : 둘 중 한가지를 먼저 정렬해두고 시작하면 나머지 등수는 이전에 통과한 사람 보다 높아야 통과!
 */
public class Main_BOJ_1946_신입사원_S1_신민아_2660ms {
	static class Applicant implements Comparable<Applicant> {
		int documentRank;
		int interviewRank;
      
		public Applicant(int documentRank, int interviewRank) {
			this.documentRank = documentRank;
			this.interviewRank = interviewRank;
		}
      
		@Override
		public int compareTo(Applicant o) {
			return documentRank - o.documentRank;
		}
   }
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		for(int testCase=0;testCase<TC;testCase++) {
			int applicantCount = Integer.parseInt(br.readLine());
			
			Applicant[] applicants = new Applicant[applicantCount];
			
			for(int i=0;i<applicantCount;i++) {
				st = new StringTokenizer(br.readLine(), " ");
				applicants[i] = new Applicant(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			
			Arrays.sort(applicants);
			
			int answer = 1;
			int tempRank = applicants[0].interviewRank;
			
			for(int i=1;i<applicants.length;i++) {
				if(tempRank > applicants[i].interviewRank) {
					tempRank = applicants[i].interviewRank;
					answer++;
				}
			}
			
			sb.append(answer).append("\n");
		}
		
		System.out.print(sb.toString());
	}

}
