package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_14503_로봇청소기_양소정_132ms{
	static int map[][];
	static int N,M,r,c,d,cnt=1;	//첫째는 항상 청소, 청소기 있는 칸 상태 항상 빈칸
	static int[] dr = {-1,0,1,0}; //북 동 남 서
	static int[] dc = {0,1,0,-1};

	public static void dfs(int r,int c, int d) {

		map[r][c] =2; //청소했다는 의미
		for (int i = 0; i < 4; i++) { 
			d -= 1;//왼쪽 방향으로 회전하며 탐색
			if (d == -1) d =3; 

			int rr = r + dr[d]; //이동한 방향
			int cc = c + dc[d];	

			if(rr >=0 && rr<N && cc >=0 && cc <M ) {  	//map안에 있고
				if(map[rr][cc]==0){ //이미 청소한 곳도 아니라면
					cnt++;		
					dfs(rr,cc,d);
					return; 
						//일반적인 DFS와 다르게후진할 때만 이전 길을 되돌가니까  return
				}
			}
		}//4방향 반복문
		//반목문을 빠져 나왔단는 것은 주변에 더 이상 청소할 공간이 없다는 의미이다
		int back = (d + 2) % 4; //반대 방향으로 후진하기 위함.
		int br = r + dr[back];//후진
		int bc = c + dc[back];//후진
		if(br >= 0 && bc >= 0 && br < N && bc < M && map[br][bc] != 1) { //벽이아니거나  map안에있으면  2는 상관 없음
			dfs(br, bc, d); 
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N =Integer.parseInt(st.nextToken()); 
		M =Integer.parseInt(st.nextToken()); 
		st = new StringTokenizer(br.readLine());
		r =Integer.parseInt(st.nextToken()); 
		c =Integer.parseInt(st.nextToken()); 
		d =Integer.parseInt(st.nextToken()); 
		map = new int[N][M];


		//map 배열 만들기
		for (int i = 0; i <N; i++) {
			st = new StringTokenizer(br.readLine()); 
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());

			}
		}

		dfs(r,c,d); 
		System.out.println(cnt);


	} //end of main
}//end of class
