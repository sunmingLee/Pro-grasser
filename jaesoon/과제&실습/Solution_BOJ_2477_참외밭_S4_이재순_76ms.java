import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_BOJ_2477_참외밭_S4_이재순_76ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		int[] arr = new int[5], a = new int[6];
		int temp;
		StringTokenizer st = new StringTokenizer(br.readLine());
		a[0] = Integer.parseInt(st.nextToken());
		arr[a[0]] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		a[1] = Integer.parseInt(st.nextToken());
		arr[a[1]] = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		a[2] = Integer.parseInt(st.nextToken());
		temp = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		a[3] = Integer.parseInt(st.nextToken());
		if (arr[a[2]]!=0) {
			if (arr[a[3]]!=0) arr[a[2]]=temp;
			else arr[a[3]] = Integer.parseInt(st.nextToken());
		}
		else {
			arr[a[2]] = temp;
			arr[a[3]] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		a[4] = Integer.parseInt(st.nextToken());
		temp = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		a[5] = Integer.parseInt(st.nextToken());
		if (arr[a[4]]==0) {
			arr[a[4]] = temp;
			if (arr[a[5]]==0) arr[a[5]] = Integer.parseInt(st.nextToken());
		}else {
			if (arr[a[5]]==0) arr[a[5]] = Integer.parseInt(st.nextToken());
			else {
				if (a[4]==a[2]) arr[a[4]] = temp;
				else if(a[5]==a[3]) {
					arr[a[4]] = temp;
					arr[a[5]] = Integer.parseInt(st.nextToken());
				}
				else arr[a[5]] = Integer.parseInt(st.nextToken());
			}
		}
		System.out.println(K*(Math.max(arr[1], arr[2])*Math.max(arr[3], arr[4])-Math.min(arr[1], arr[2])*Math.min(arr[3], arr[4])));
	}
}
