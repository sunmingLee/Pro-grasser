import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_BOJ_20299_3대측정_B2_이승연{
   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringBuilder sb = new StringBuilder();
      StringTokenizer st = new StringTokenizer(br.readLine()," ");
      
      int N = Integer.parseInt(st.nextToken()); // 신청한 동아리 수 
      int S = Integer.parseInt(st.nextToken()); // 스마트 클럽 가입 조건 (팀원 3명 능력 합)
      int M = Integer.parseInt(st.nextToken()); // 스마트 클럽 가입 조건  (개인 능력치)
      LinkedList<Integer> club_stu_list = new LinkedList<Integer>();
      int available_club_num = 0; // 스마트클럽 가입이 가능한 동아리 수 
      
      for(int i=0; i<N; i++) {
         st = new StringTokenizer(br.readLine(), " ");
         int stu1 = Integer.parseInt(st.nextToken()); // 첫번째 동아리원의 개인 능력치 
         int stu2 = Integer.parseInt(st.nextToken()); // 두번째 동아리원의 개인 능력치 
         int stu3 = Integer.parseInt(st.nextToken()); // 세번째 동아리원의 개인 능력치 
         if(stu1>=M && stu2>=M && stu3>=M && stu1+stu2+stu3 >= S) { // 스마트 클럽 가입 조건을 만족하면 
            available_club_num++; // 가입이 가능한 동아리 수 +1
            club_stu_list.add(stu1); // 가입한 학생의 능력치 추가
            club_stu_list.add(stu2); // 가입한 학생의 능력치 추가
            club_stu_list.add(stu3); // 가입한 학생의 능력치 추가
         }
      }
      
      sb.append(available_club_num).append("\n"); // 가입이 가능한 동아리 수 출력을 위해 
      for(int stu: club_stu_list) { // 가입한 학생들의 능력치 출력을 위해 
         sb.append(stu).append(" ");
      }
      
      sb.setLength(sb.length()-1);
      
      System.out.println(sb.toString()); // 출력 
   }
}
