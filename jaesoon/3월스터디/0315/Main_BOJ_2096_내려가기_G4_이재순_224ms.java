import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BOJ_2096_내려가기_G4_이재순_224ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Node first = new Node();
		Node second = new Node();
		Node third = new Node();
		String line = br.readLine();
		first.max = first.min = line.charAt(0)-'0';
		second.max = second.min = line.charAt(2)-'0';
		third.max = third.min = line.charAt(4)-'0';
		for (int i = 1; i < N; i++) {
			line = br.readLine();
			int a = line.charAt(0)-'0', b = line.charAt(2)-'0', c = line.charAt(4)-'0';
			first.max = Math.max(first.max, second.max); 
			third.max = Math.max(second.max, third.max); 
			second.max = Math.max(first.max, third.max);
			first.max += a;
			second.max += b;
			third.max += c;
			first.min = Math.min(first.min, second.min);
			third.min = Math.min(second.min, third.min);
			second.min = Math.min(first.min, third.min);
			first.min += a;
			second.min += b;
			third.min += c;
		}
		StringBuilder sb = new StringBuilder();
		sb.append(Math.max(Math.max(first.max, second.max),third.max)).append(" ").append(Math.min(Math.min(first.min, second.min),third.min));
		System.out.println(sb);
	}
	static class Node{
		int max = 0, min = 0;
	}
}
