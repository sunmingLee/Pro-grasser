import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main_JO_1828_냉장고_신민아_98ms {
	static class Material implements Comparable<Material>{
		int min;
		int max;
		
		Material(int min, int max) {
			this.min = min;
			this.max = max;
		}

		@Override
		public int compareTo(Material o) {
			return this.max != o.max ? this.max - o.max : this.min - o.min;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int materialCount = Integer.parseInt(br.readLine());
		
		Material[] materials = new Material[materialCount];
		
		StringTokenizer st;
		for(int i=0;i<materialCount;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			materials[i] = new Material(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(materials);
		
		System.out.print(getFridges(materials));
		
	}
	
	private static int getFridges(Material[] materials) {
		List<Material> result = new ArrayList<Material>();
		
		result.add(materials[0]); // 첫 회의 추가 : 종료시간이 가장 빠른 회의
		
		for(int i=1,size=materials.length;i<size;i++) {
			// 직전 회의의 종료 시간과 현재 회의의 시작 시간 비교
			if(result.get(result.size() - 1).max < materials[i].min)
				result.add(materials[i]);
		}
		
		return result.size();
	}

}
