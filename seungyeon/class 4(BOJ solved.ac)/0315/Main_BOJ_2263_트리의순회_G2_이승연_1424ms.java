import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BOJ_2263_트리의순회_G2_이승연_1424ms {
	private static StringBuilder sb;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 1<=N<=100000
		String[] str_arr = br.readLine().split(" ");
		
		int[] inorder = new int[N];

		for(int i=0; i<str_arr.length; i++) {
			inorder[i] = Integer.parseInt(str_arr[i]);
		}
		
		str_arr = br.readLine().split(" ");
		
		int[] postorder = new int[N];

		for(int i=0; i<str_arr.length; i++) {
			postorder[i] = Integer.parseInt(str_arr[i]);
		}
		
		sb = new StringBuilder();
		
		findPreorder(0, N-1, 0, N-1, inorder, postorder);
		sb.setLength(sb.length()-1);
		
		System.out.print(sb.toString());
	}
	
	
	public static void findPreorder(int sp_i, int ep_i, int sp_p, int ep_p, int[] inorder, int[] postorder) {
		if(sp_i>ep_i || sp_p>ep_p) return;
		
		sb.append(postorder[ep_p]).append(" ");
		
		int root = sp_i;
		for(int i=sp_i; i<=ep_i; i++) {
			if(inorder[i] == postorder[ep_p]) {
				root = i;
				break;
			}
		}
		
		findPreorder(sp_i, root-1, sp_p, sp_p+root-sp_i-1, inorder, postorder);
		findPreorder(root+1, ep_i, sp_p+root-sp_i, ep_p-1, inorder, postorder);
	}
}
