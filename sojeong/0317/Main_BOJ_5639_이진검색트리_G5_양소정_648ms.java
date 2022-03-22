package march0317;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main_BOJ_5639_이진검색트리_G5_양소정_648ms{
    static int[] tree = new int[10001];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int idx = 0;
        String input = null;
        while((input = br.readLine())!=null){
        	
        	tree[idx++] = Integer.parseInt(input);
        }

        postOrder(0, idx - 1);

    }

    static void postOrder(int n, int end) {
        if (n > end)
            return;

        int mid = n + 1;
        while (mid <= end && tree[mid] < tree[n])
            mid++;

        postOrder(n + 1, mid - 1);
        postOrder(mid, end);
        System.out.println(tree[n]);
    }
}
