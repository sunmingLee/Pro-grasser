package com.ssafy.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_BOJ_16935_배열돌리기3_S1_이재순_00ms {
	static String[][][] arr;
	static int N,M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken())/2; //배열의 row수/2, 2 ≤ N*2 ≤ 300
		M = Integer.parseInt(st.nextToken())/2; //배열의 col수/2, 2 ≤ M*2 ≤ 300
		int R = Integer.parseInt(st.nextToken());//회전 수, 1 ≤ R ≤ 1,000
		arr = new String[4][N][M]; // 입력된 배열 생성, 배열전체를 4개로 나눈다
		//0번배열과 1번배열 채우기
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[0][i][j] = st.nextToken();
			}
			for (int j = 0; j < M; j++) {
				arr[1][i][j] = st.nextToken();
			}
		}
		//2번배열과 3번배열 채우기
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[2][i][j] = st.nextToken();
			}
			for (int j = 0; j < M; j++) {
				arr[3][i][j] = st.nextToken();
			}
		}
		//명령을 입력 및 실행
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < R; i++) {
			switch (st.nextToken()) {
			case "1":
				upsideDown();
				break;
			case "2":
				switchSide();
				break;
			case "3":
				rotate(90);
				break;
			case "4":
				rotate(270);
				break;
			case "5":
				rotate(5);
				break;
			case "6":
				rotate(6);
				break;
			}
		}
		//0번, 1번 배열 출력
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(arr[0][i][j]).append(" ");
			}
			for (int j = 0; j < M; j++) {
				sb.append(arr[1][i][j]).append(" ");
			}
			sb.append("\n");
		}
		//2번, 3번 배열 출력
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(arr[2][i][j]).append(" ");
			}
			for (int j = 0; j < M; j++) {
				sb.append(arr[3][i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
	//상하 반전 메소드
	private static void upsideDown() {
		for (int k = 0; k < 4; k++) {
			for (int j = 0; j < arr[k][0].length; j++) {
				for (int i = 0; i < arr[k].length/2; i++) {
					String temp = arr[k][i][j];
					arr[k][i][j] = arr[k][arr[k].length-i-1][j];
					arr[k][arr[k].length-i-1][j] = temp;
				}
			}
		}
		String[][] temp = arr[0];
		arr[0] = arr[2];
		arr[2] = temp;
		temp = arr[1];
		arr[1]=arr[3];
		arr[3]=temp;
	}
	//좌우 반전 메소드
	private static void switchSide() {
		for (int k = 0; k < 4; k++) {
			for (int i = 0; i < arr[k].length; i++) {
				for (int j = 0; j < arr[k][i].length/2; j++) {
					String temp = arr[k][i][j];
					arr[k][i][j] = arr[k][i][arr[k][i].length-j-1];
					arr[k][i][arr[k][i].length-j-1] = temp;
				}
			}
		}
		String[][] temp = arr[0];
		arr[0] = arr[1];
		arr[1] = temp;
		temp = arr[3];
		arr[3]=arr[2];
		arr[2]=temp;
	}
	//90도, 270도 회전, 배열 4등분해서 시계방향, 반시계방향으로 회전하는 메소드
	private static void rotate(int degree) {
		String[][] temp;
		int tempInt;
		switch (degree) {
		case 90:
			tempInt = N; //90도 회전하게 되면 N과 M이 바뀜
			N = M;
			M = tempInt;
			temp = rotate(arr[0], degree);
			arr[0]=rotate(arr[2], degree);
			arr[2]=rotate(arr[3], degree);
			arr[3]=rotate(arr[1], degree);
			arr[1]=temp;
			break;
		case 270:
			tempInt = N; //90도 회전하게 되면 N과 M이 바뀜
			N = M;
			M = tempInt;
			temp = rotate(arr[0], degree);
			arr[0]=rotate(arr[1], degree);
			arr[1]=rotate(arr[3], degree);
			arr[3]=rotate(arr[2], degree);
			arr[2]=temp;
			break;
		case 5: //배열 4등분해서 시계방향으로 회전
			temp = arr[0];
			arr[0] = arr[2];
			arr[2] = arr[3];
			arr[3] = arr[1];
			arr[1] = temp;
			break;
		case 6: //배열 4등분해서 반시계방향으로 회전
			temp = arr[0];
			arr[0] = arr[1];
			arr[1] = arr[3];
			arr[3] = arr[2];
			arr[2] = temp;
			break;
		}

	}
	//입력받은 배열을 90도, 270도 회전시킨 배열을 반환하는 메소드
	private static String[][] rotate(String[][] arr, int degree) {
		String[][] rotateArr = new String[N][M]; 
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				switch (degree) {
				case 90:
					rotateArr[i][j] = arr[M-1-j][i];
					break;
				case 270:
					rotateArr[i][j] = arr[j][N-1-i];
					break;
				}
			}
		}
		return rotateArr;
	}
}
