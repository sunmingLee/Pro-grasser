import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
임의의 점에서 시작하여 가장 먼 거리를 가지는 노드를 찾고,
그 노드에서 다시 한번 가장 먼 거리를 가지는 노드를 찾게 되면 트리의 지름
실이라고 생각하기!
*/

public class Main_BOJ_1167_트리의지름_G3_양소정_880ms {    
 
    static ArrayList<Node>[] list;
    static boolean[] visited;
    static int max = 0;
    static int node;
    
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        list = new ArrayList[n + 1]; 
        for(int i = 1; i < n + 1; i++) {
            list[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < n; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            while(true) {
                int e = Integer.parseInt(st.nextToken());
                if(e == -1) break;
                int cost = Integer.parseInt(st.nextToken());
                list[s].add(new Node(e, cost));
            }
        }
        
        //임의의 노드(1)에서 부터 가장 먼 노드를 찾는다. 이때 찾은 노드를 node에 저장한다.
        visited = new boolean[n + 1];
        dfs(1, 0);
        
        //node에서 부터 가장 먼 노트까지의 거리를 구한다.
        visited = new boolean[n + 1];
        dfs(node, 0);
        
        System.out.println(max);
    }
    
    public static void dfs(int x, int len) {
        if(len > max) {
            max = len;
            node = x;
        }
        visited[x] = true;
        
        for(int i = 0; i < list[x].size(); i++) { //마지막에 list사이즈가 0이면 for문 돌지않고 종료
            Node n = list[x].get(i);
            if(visited[n.e] == false) {
                dfs(n.e, n.cost + len);
                visited[n.e] = true;
            }
        }
        
    }
    
    public static class Node {
        int e;
        int cost;
        
        public Node(int e, int cost) {
            this.e = e;
            this.cost = cost;
        }
    }
}

