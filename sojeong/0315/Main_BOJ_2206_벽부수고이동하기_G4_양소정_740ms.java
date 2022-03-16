
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_2206_벽부수고이동하기_G4_양소정_740ms{	

	static class Node{
		int x;
		int y;
		int cnt;
		boolean ch; //벽 부실 수 있는 기회
		
		public Node(int x, int y, int cnt, boolean ch) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.ch = ch;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N =Integer.parseInt(st.nextToken());// N(1 ≤ N ≤ 1,000)
		int M =Integer.parseInt(st.nextToken());// M(1 ≤ M ≤ 1,000)
		String str;
		int dx[] = {0,0,1,-1};
		int dy[] = {1,-1,0,0};
		char map[][]= new char [N][M];
		boolean v[][][]= new boolean [N][M][2]; //벽 부수고 큐에 넣은 것도 고려해야함.

		for(int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		int xx=0;
		int yy=0;
		Queue<Node> q = new LinkedList<>();
	    q.add(new Node(0, 0, 1,true));
	    while(!q.isEmpty()) {
	    	Node current =q.poll();
	    	if(current.x==N-1 && current.y==M-1) {
	    		System.out.println(current.cnt);
	    		return;
	    	}
	    	for (int i = 0; i < 4; i++) {
	    		xx = current.x+dx[i];
	    		yy = current.y+dy[i];
	    		if(xx<0||xx>=N || yy<0||yy>=M) continue;
	    		
	    		if(current.ch ) {//한번도 안부순 경우 
	    			if(map[xx][yy]=='0' &&!v[xx][yy][0] ) { //방문하지않았고 벽이 아니면
	    				v[xx][yy][0] =true;
	    				q.add(new Node(xx, yy, current.cnt+1,true));
	    			}
//	    			}else if (map[xx][yy]=='1') {//벽이면
//	    				v[xx][yy][1] =true;
//	    				q.add(new Node(xx, yy, current.cnt+1,false)); //이것만 날리면 됨.
//	    			} 
	    		
	    		}else if(!current.ch){ //벽을 부순 경우
	    			if(map[xx][yy]=='0' &&!v[xx][yy][0] &&!v[xx][yy][1]) { //
	    				
	    				v[xx][yy][1] =true;
	    				q.add(new Node(xx, yy, current.cnt+1,false));
	    			}
	    				
	    		}
			}	
	    }
		
		System.out.println("-1");
	}

}
