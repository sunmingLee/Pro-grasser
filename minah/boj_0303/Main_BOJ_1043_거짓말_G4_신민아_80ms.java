package boj_0303;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 서로소집합으로 품
public class Main_BOJ_1043_거짓말_G4_신민아_80ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int human = Integer.parseInt(st.nextToken()); // 전체 참석자 수
		int parties = Integer.parseInt(st.nextToken()); // 전체 파티의 개수
		
		st = new StringTokenizer(br.readLine(), " ");
		int truthKnowCount = Integer.parseInt(st.nextToken()); // 진실을 아는 사람의 수
		
		if(truthKnowCount == 0) { // 진실을 아는 사람이 없다면, 바로 파티의 수 출력
			System.out.print(parties);
			return;
		}
		
		int truthKnow[] = new int[human + 1]; // 진실을 아는 사람의 무리(진실을 아는 사람 중 가장 먼저 위치한 사람을 가리킴)
		for(int i=1;i<truthKnow.length;i++) {
			truthKnow[i] = i; // 초기화 by 서로소집합
		}
		
		int knowRoot = Integer.parseInt(st.nextToken()); // 진실을 아는 사람 중 가장 먼저 위치한 사람
		while(st.hasMoreTokens()) {
			unionTruth(truthKnow, knowRoot, Integer.parseInt(st.nextToken())); // 진실을 아는 사람이 더 있다면 가장 먼저 위치한 사람으로 집합을 묶어줌
		}
		
		int[][] partyPeople = new int[parties][]; // 각 파티별 어떤 사람이 있는지 확인
		
		for(int i=0;i<parties;i++) { // 파티만큼 반복
			st = new StringTokenizer(br.readLine(), " ");
			
			int partyPeopleCount = Integer.parseInt(st.nextToken()); // 파티에 총 몇명이 있는지 확인
			partyPeople[i] = new int[partyPeopleCount]; // 배열 초기화
			
			boolean isKnown = false; // 이미 파티에 진실을 아는 사람이 있는지 flag
			
			for(int p=0;p<partyPeopleCount;p++) { // 각 파티별로 돌면서 진실을 아는 사람이 있는지 전수조사
				int pP = Integer.parseInt(st.nextToken());
				partyPeople[i][p] = pP; // 파티에 참석하는 사람의 정보 저장
				if(findRoot(truthKnow, pP) == knowRoot) // 파티에 건너건너 진실을 아는 사람이 있다면
					isKnown = true; // 이 파티는 진실을 알게 되므로 true
			}
			
			if(isKnown) { // 진실을 아는 파티일 경우
				for(int p=0;p<partyPeopleCount;p++) { // 진실을 바로 알기에 모든 사람들이 제일 먼저 진실을 아는 사람 저장
					unionTruth(truthKnow, knowRoot, partyPeople[i][p]);
				}
			} else { // 진실을 모르는 경우
				int newRoot = partyPeople[i][0]; // 각 파티에서 가장 먼저 있는 사람을 필두로 하여 집합을 만듬
				for(int p=1;p<partyPeopleCount;p++) {
					unionTruth(truthKnow, newRoot, partyPeople[i][p]);
				}
			}
		}
		
		int answer = parties;
		
		for(int i=0;i<partyPeople.length;i++) {
			for(int p=0;p<partyPeople[i].length;p++) {
				if(findRoot(truthKnow, partyPeople[i][p]) == knowRoot) { // 해당 파티에 진실을 아는 사람이 하나라도 있다면
					answer--; // 파티의 수를 줄이고
					break; // 다음 파티를 알아본다
				}
			}
		}
		
		System.out.print(answer);
		
	}
	
	// 가장 최상위의 부모 찾기
	private static int findRoot(int[] truth, int a) {
		if(a == truth[a]) {
			return a;
		}
		return truth[a] = findRoot(truth, truth[a]);
	}
	
	// 같은 집합일 경우 묶어주는 코드
	private static void unionTruth(int[] truth, int a, int b) {
		int aRoot = findRoot(truth, a);
		int bRoot = findRoot(truth, b);
		
		if(aRoot == bRoot) return;
		truth[bRoot] = aRoot;
	}
	
}
