package IM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BOJ_2941_크로아티아알파벳_S5_양소정_84ms{
	public static void main(String[] args) throws Exception {
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String []cro = {"c=", "c-","dz=","d-","lj","nj","s=","z="};
	
		for (int i = 0; i < cro.length; i++) {
			if(str.contains(cro[i])) { // 크로아티에 있는 단어 포함한다면
				str = str.replace(cro[i], "!"); //그 단어를 전부 아무 한글자로 대체
			}
		}
		System.out.println(str.length());
	}

}
