import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution_SWEA_4012_요리사_이승연_160ms{
    private static int N;
    private static boolean[] ingre;
    private static int[][] S;
    private static int min;
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
         
        int T = Integer.parseInt(br.readLine()); // 총 테스트 케이스 
         
        StringTokenizer st;
         
        for(int testCase=1; testCase<=T; testCase++) {
            N = Integer.parseInt(br.readLine()); // 식재료 수 (4 <= N <= 16)
            S = new int[N][N]; // 시너지 (1 <= S <= 20000)
             
            for(int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for(int j=0; j<N; j++) {
                    S[i][j] = Integer.parseInt(st.nextToken());
                }
            }
             
            ingre = new boolean[N]; // 일단 true,false로 A,B 구분 -> 나중에 따로 따로 저장 
            ingre[0] = true;
            min = Integer.MAX_VALUE;
             
            combination(1, 1);
             
            sb.append("#").append(testCase).append(" ").append(min).append("\n");
        } // end of testCase
         
        System.out.print(sb.toString());
    } // end of main
     
    public static void combination(int cnt, int start) {
        if(cnt == N/2) {
            int synergy_diff = calcSynergyDiff();
            if(min > synergy_diff) {
                min = synergy_diff;
            }
            return;
        }
         
        for(int i=start; i<N; i++) {
            ingre[i] = true;
            combination(cnt+1, i+1);
            ingre[i] = false; 
        }
    }
     
    public static int calcSynergyDiff() {
        int[] A = new int[N/2];
        int[] B = new int[N/2];
        int idx_a = 0;
        int idx_b = 0;
         
        for(int i=0; i<N; i++) {
            if(ingre[i] == true) { // A음식 
                A[idx_a++] = i;
            } else { // B음식
                B[idx_b++] = i;
            }
        }
         
        int a_synergy = 0;
        int b_synergy = 0;
 
        for(int i=0; i<N/2; i++) {
            for(int j=0; j<N/2; j++) {
                a_synergy += S[A[i]][A[j]];
                b_synergy += S[B[i]][B[j]];
            }
        }
         
        return Math.abs(a_synergy-b_synergy);
    }
} // end of class
