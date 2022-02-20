package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 회의실을 사용하려는 회의 목록을 받아 가장 많이 회의를 진행할 수 있는 경우를 뽑기
 * 받는 정보 : 시작, 종료시간
 *
 */
public class MeetingRoomGreedyTest {
	
	static class Meeting implements Comparable<Meeting> {
		int start, end;
		
		public Meeting(int start, int end) {
			this.start = start;
			this.end = end;
		}
		
		// 종료 시간 별로 오름차순 정렬, 종료 시간이 같다면 시작 시간이 빠른 것으로 오름차순
		@Override
		public int compareTo(Meeting o) {
			return this.end != o.end ? this.end - o.end : this.start - o.start;
		}
		
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int countOfMeeting = Integer.parseInt(br.readLine());
		Meeting[] meetings = new Meeting[countOfMeeting];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=0;i<countOfMeeting;i++) {
			meetings[i] = new Meeting(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		List<Meeting> result = getSchedule(meetings);
		
		StringBuilder sb = new StringBuilder();
		sb.append(result.size()).append("\n");
		
		for(Meeting meeting : result) {
			sb.append(meeting.start).append(" ").append(meeting.end).append("\n");
		}
		
		System.out.print(sb.toString());

	}
	
	private static List<Meeting> getSchedule(Meeting[] meetings) {
		List<Meeting> result = new ArrayList<Meeting>();
		
		// 회의 목록을 종료 시간 기준으로 오름차순, 종료 시간이 같다면 시작 시간 기준으로 오름차순 정렬
		Arrays.sort(meetings);
		result.add(meetings[0]); // 첫 회의 추가 : 종료시간이 가장 빠른 회의
		
		for(int i=1,size=meetings.length;i<size;i++) {
			// 직전 회의의 종료 시간과 현재 회의의 시작 시간 비교
			if(result.get(result.size() - 1).end <= meetings[i].start)
				result.add(meetings[i]);
		}
		
		return result;
	}
}
