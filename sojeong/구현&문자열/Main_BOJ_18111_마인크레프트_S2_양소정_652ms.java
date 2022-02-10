import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_18111_마인크레프트_S2_양소정_652ms{
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N =Integer.parseInt(st.nextToken()); 
		int M =Integer.parseInt(st.nextToken()); 
		int B =Integer.parseInt(st.nextToken()); 
		int map[][] = new int[N][M] ;
		long sum=0;
	
		int max=0;
		int cnt=0;
		//map 배열 만들기
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()); 
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				sum += map[i][j];
			}
		}
		long avg = (sum+B)/(N*M);
		int maxHeight = (avg>256) ? 256 : (int)avg; //(모든 블록의 전체 개수/ 땅의 넓이) ->블록의 최대 높이
		int minTime = Integer.MAX_VALUE;
		int height = 0;
		for(int k=0; k<=maxHeight; k++) { //0층부터 최대높이 층 까지
			int time = 0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(map[i][j]>k) { //k층보다 크면   빼기
						time += (map[i][j]-k)*2; //   층 차이 *2
					} else if(map[i][j]<k) {  //k층보다 작으면 더하기
						time +=  k-map[i][j];     
					}
				}
			}
			if(minTime>=time) {   //최소시간일때 층
				minTime = time;
				height = k;
			}
		}
		System.out.println(minTime+" "+height);
	}
}
