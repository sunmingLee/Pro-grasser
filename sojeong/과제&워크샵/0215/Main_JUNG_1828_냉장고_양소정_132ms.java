import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main_JUNG_1828_냉장고_양소정_132ms{
	
	static class ref implements Comparable<ref>{
		int start, end; //최저, 최대온도

		public ref(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}
		//최대온도 기준 오름차순
		@Override
		public int compareTo(ref o) {
			return this.end - o.end ;
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine()); //화학 물질 수
		
		ref[] refs = new ref[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			refs[i] = new ref(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())); //냉장고 배열에 담기
		}
		
		List<ref> result = getSchedule(refs);
		
		StringBuilder sb = new StringBuilder();
		System.out.println(result.size());
		
	}
	
	public static List<ref> getSchedule(ref[] refs){
		ArrayList<ref> result = new ArrayList<ref>();
		//화학물질 목록을 최대온도 기준으로 오름차순, 최대온도 같다면 최저온도 기준으로 오름차순 정렬
		Arrays.sort(refs);
		result.add(refs[0]); //첫 물질 추가 , 최대가 가장 낮은
		
		for (int i = 1,size = refs.length; i < size; i++) { //size for문의 지역변수 만들어서 조금이나마 시간 줄이기
			//직전 화학물질 최대 현재회의의 최소온도 비교
			if(result.get(result.size()-1).end < refs[i].start) {
				result.add(refs[i]);
			}
		}
		return result;
	}
	
}
