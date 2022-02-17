import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_JUNGOL_1828_냉장고_이승연_120ms {
	private static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		
		int[][] materials = new int[N][2]; // 최저보관온도, 최고보관온도  
				
		for(int i=0; i<N; i++) { // 입력받은 화학물질 저장 
			st = new StringTokenizer(br.readLine(), " ");
			materials[i] = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
		}
		
		// 최고보관온도 오름차순 
		Arrays.sort(materials, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[1], o2[1]); 
			}
		});
		
		int temp_max = materials[0][1]; // 현재 냉장고 온도: 첫번째 최고보관온도
		int refri_n = 1; // 냉장고 개수 
		
		for(int i=1; i<N; i++) {
			if(temp_max < materials[i][0]) { // 최저보관온도가 현재 냉장고 온도보다 클 때  
				refri_n++; // 냉장고 개수 늘리기 
				temp_max = materials[i][1]; // 현재 냉장고 온도에 해당 화학물질의 최고온도 넣기 
			}	
		}
		
		System.out.println(refri_n);
	}
}
