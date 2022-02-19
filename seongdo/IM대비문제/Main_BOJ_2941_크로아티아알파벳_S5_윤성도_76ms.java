package com.ssafy.IM;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BOJ_2941_크로아티아알파벳_S5_윤성도_76ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
	    int num=0;
	    for(int i = s.length() - 1; i >= 0; i--){
	        if(s.charAt(i)=='='){
	            if(s.charAt(i-1)=='c'){
	                num++;
	                i--;
	                continue;
	            }
	            else if(s.charAt(i-1)=='s'){
	                num++;
	                i--;
	                continue;
	            }
	            else if(i>1 && s.charAt(i-1)=='z'&&s.charAt(i-2)=='d'){
	                num++;
	                i-=2;
	                continue;
	            }
	            else if(s.charAt(i-1)=='z'){
	                num++;
	                i--;
	                continue;
	            }
	        }
	        else if(s.charAt(i)=='-'){
	            if(s.charAt(i-1)=='c'){
	                num++;
	                i--;
	                continue;
	            }
	            else if(s.charAt(i-1)=='d'){
	                num++;
	                i--;
	                continue;
	            }
	        }
	        else if(s.charAt(i) == 'j' && i != 0){
	            if(s.charAt(i-1)=='l'){
	                num++;
	                i--;
	                continue;
	            }
	            else if(s.charAt(i-1)=='n'){
	                num++;
	                i--;
	                continue;
	            }
	        }
	        num++;
	    }
	    System.out.println(num);;
	}
}