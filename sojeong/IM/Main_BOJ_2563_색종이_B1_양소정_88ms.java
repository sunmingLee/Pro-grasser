package IM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_2563_색종이_B1_양소정_88ms{
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int ans =0;
		int [][]map = new int[100][100];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int x =Integer.parseInt(st.nextToken());
			int y =Integer.parseInt(st.nextToken());
			
			for (int j = 0; j < 10; j++) {
				for (int k = 0; k <10; k++) {
					if(map[x+j][y+k]==0) {
						map[x+j][y+k] = 1;
						ans++;
					}			
				}
			}
		
		}
		System.out.println(ans);

	}
}
