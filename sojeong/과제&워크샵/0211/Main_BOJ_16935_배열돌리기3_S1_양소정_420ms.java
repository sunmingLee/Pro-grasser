import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_16935_배열돌리기3_S1_양소정_420ms {
	
	private static int M;
	private static int N;
	private static int R;
	private static int[][] arr;
	private static int[][] Tarr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		int cmd;
		arr =new int[N][M];


		//배열만들기
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//수행해야 하는 연산
		st = new StringTokenizer(br.readLine());
		while(st.hasMoreElements()) {
			cmd = Integer.valueOf(st.nextToken());
			
			switch (cmd) {
			case 1: //상하반전
				cal1();
				break;
			case 2: // 좌우반전
				cal2();
				break;
			case 3: // 오른쪽 90도
				cal3();
				break;
			case 4: // 왼쪽 90도
				cal4();
				break;
			case 5: // 4개 영역 시계방향 회전
				cal5();
				break;
			case 6: // 5개 영역 반시계방향 회전
				cal6();
				break;
			}
		}
		
	
		//출력
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				sb.append(arr[i][j] + " ");
			}
			sb.append("\n");
		}
		System.out.print(sb.toString());
	
	
	
	}//end of main

	public static void cal6() {
	Tarr = new int[N][M];
		
		int N_mid = N/2;
		int M_mid = M/2;
		
		//1->4
		for (int i = 0; i < N_mid; i++) {
			for (int j = 0; j < M_mid; j++) {
				Tarr[N_mid+i][j] = arr[i][j];
			}
			
		}
		
		//4->3
		for (int i = N_mid; i < N; i++) {
			for (int j = 0; j < M_mid; j++) {
				Tarr[i][M_mid+j] = arr[i][j];
			}
			
		}
		
		
		//3-2
		int Row =0;
		
		for (int i = N_mid; i < N; i++,Row++) {
			for (int j = M_mid; j < M; j++) {
				Tarr[Row][j] = arr[i][j];
			}
			
		}
		//2-1
		for (int i = 0; i < N_mid; i++) {
			int C =0;
			for (int j = M_mid; j < M; j++,C++) {
				Tarr[i][C] = arr[i][j];
			}
			
		}
	
		arr =Tarr; 
		
		
	}

	public static void cal5() {
		Tarr = new int[N][M];
		
		int N_mid = N/2;
		int M_mid = M/2;
		
		//1 -> 2
		for (int i = 0; i < N_mid; i++) {
			for (int j = 0; j < M_mid; j++) {
				Tarr[i][M_mid+j] = arr[i][j];
			}
			
		}
		//2->3
		for (int i = 0; i < N_mid; i++) {
			for (int j = M_mid; j < M; j++) {
				Tarr[N_mid+i][j] = arr[i][j];
			}
			
		}
		// 3->4
		
		for (int i = N_mid; i < N; i++) {
			int C =0;
			for (int j = M_mid; j < M; j++,C++) {
				Tarr[i][C] = arr[i][j];
			}
			
		}
		//4->1
		int Row =0;
		
		for (int i = N_mid; i < N; i++,Row++) {
			for (int j = 0; j < M_mid; j++) {
				Tarr[Row][j] = arr[i][j];
			}
			
		}
	
		arr =Tarr; 
		
		
	}

	public static void cal4() { //왼쪽 90도
		Tarr = new int[M][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				Tarr[M-1-j][i] = arr[i][j];
			}
			
		}
		//크기 변환
		int temp = N;
		N=M;
		M=temp;
		
		arr =Tarr; 
		
		
	}

	public static void cal3() { // 오른쪽 90도
		Tarr = new int[M][N];
		
		int c = N-1; 
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				Tarr[j][c] = arr[i][j];
			}
			c--;
		}
		//크기 변환
		int temp = N;
		N=M;
		M=temp;
		
		arr =Tarr; //행 열 달라도 체인지가 되네
		
	}

	public static void cal2() { //좌우반전
		Tarr = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				Tarr[i][M-j-1] = arr[i][j];
			}
		}
		arr =Tarr;
		
	}

	public static void cal1() { //상하반전
		Tarr = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				Tarr[N-i-1][j] = arr[i][j];
			}
		}
		arr =Tarr;
		
	}

	
}
