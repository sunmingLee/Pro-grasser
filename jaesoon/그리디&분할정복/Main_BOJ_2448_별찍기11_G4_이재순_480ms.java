import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_BOJ_2448_별찍기11_G4_이재순_480ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());//N = 3*2^k (1<=k<=10)
		//배열 생성(별찍을 도화지)
		char[][] arr = new char[N][2*N-1];
		for (int i = 0; i < N; i++) {
			Arrays.fill(arr[i], ' ');
		}
		//프로세스 진행
		divide(0, N-1, N, arr);
		
		//출력
		StringBuilder sb = new StringBuilder();
		for (char[] cs : arr) {
			for (char cs2 : cs) {
				sb.append(cs2);
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
	
	private static void divide(int row, int col , int n, char[][] arr) {
		if (n==3) {//n이 3일때 = 삼각형을 그려야 할때 진행
			arr[row++][col] = arr[row][col-1] = arr[row++][col+1] =
					arr[row][col-2] = arr[row][col-1] = arr[row][col] = arr[row][col+1] = arr[row][col+2] = '*';//*이 들어갈 자리에 넣어주기
			return;
		}
		int temp = n/2;
		divide(row		, col		, n/2, arr);//가운데 위
		divide(row+temp	, col-temp	, n/2, arr);//왼쪽 아래
		divide(row+temp	, col+temp	, n/2, arr);//오른쪽 아래
	}
}
