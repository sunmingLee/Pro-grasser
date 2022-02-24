package backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BOJ_1759_암호만들기_G5_신민아_84ms {
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int passwordLength = Integer.parseInt(st.nextToken()); // 패스워드의 길이
		int totalCharCount = Integer.parseInt(st.nextToken()); // 전체 문자의 개수
		
		char[] alphabets = br.readLine().replaceAll(" ", "").toCharArray(); // 알파벳들 옮기기
		
		Arrays.sort(alphabets); // 정렬
		
		int lastMoumIndex = getLastMoumIndex(alphabets); // 마지막의 모음의 인덱스
		
		sb = new StringBuilder();
		
		getPasswordCombination(alphabets, 0, 0, new char[passwordLength], 0, lastMoumIndex); // 패스워드 별 조합
		
		System.out.print(sb.toString());
		
	}
	
	// alphabets : 주어진 알파벳, start : 조합에 넣을 문자의 시작 지점, curCount : 현재 몇개의 글자를 선택했는지, selection : 고른 글자를 저장한 배열
	// moumCount : 현재까지의 모음 개수, lastMoumIndex : 마지막에 위치한 모음 인덱스
	private static void getPasswordCombination(char[] alphabets, int start, int curCount, char[] selection, 
													int moumCount, int lastMoumIndex) {
		
		if(start > lastMoumIndex && moumCount == 0) { // 현재 시작하는 점이 모음의 마지막 인덱스를 지났고 모음 카운트가 0일때
			return;
		}
		
		if(curCount == selection.length) { // 글자가 할당된 개수만큼 채웠을 때
			if(selection.length - moumCount < 2 || moumCount == 0) { // 마지막에 모음으로 끝나는 경우는 위에 가지가 쳐지지 않아 여기서 필터링, 자음 2개 이하인 경우 출력 x
				return;
			}
			
			for(int i=0;i<selection.length;i++) { // stringbuilder에 붙이기
				sb.append(selection[i]);
			}
			
			sb.append("\n"); // 모든 문자 출력 완료 후 개행문자
			return;
		}
		
		for(int i=start;i<alphabets.length;i++) { // 글자를 start부터 마지막 글자까지 고르기
			selection[curCount] = alphabets[i]; // 저장 
			
			if(isMoum(selection[curCount])) { // 모음이면 moumCount를 1 증가시키고 call
				getPasswordCombination(alphabets, i+1, curCount+1, selection, moumCount+1, lastMoumIndex);
			} else { // 자음이면 moumCount를 증가시키지 않고 call
				getPasswordCombination(alphabets, i+1, curCount+1, selection, moumCount, lastMoumIndex);
			}
		}
	}
	
	// idea : 어차피 모음은 1개만 있으면 되므로 true false 처리도 가능 : 대신 이런 경우는 자음 개수를 체크해야 할듯?
	// idea2 : 모음이 몇 번 인덱스에 위치하는지 boolean 배열 사용!
	private static boolean isMoum(char alphabet) { // 현재 글자가 모음인지 아닌지 체크
		char[] moum = {'a', 'e', 'i', 'o', 'u'};
		
		for(int i=0;i<5;i++) {
			if(alphabet == moum[i]) {
				return true;
			}
		}
		return false;
	}
	
	private static int getLastMoumIndex(char[] alphabets) { // 마지막 모음의 인덱스를 찾음
		for(int i=alphabets.length-1;i>=0;i--) {
			if(alphabets[i] == 'u' || alphabets[i] == 'o' || alphabets[i] == 'i' || alphabets[i] == 'e' || alphabets[i] == 'a')
				return i;
		}
		
		return -1;
	}

}
