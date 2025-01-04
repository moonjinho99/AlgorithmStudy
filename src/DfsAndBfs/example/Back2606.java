package DfsAndBfs.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//백준 2606번
public class Back2606 {

	static ArrayList<Integer>[] A;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		int E = Integer.parseInt(bf.readLine());
		A = new ArrayList[N+1];
		visited = new boolean[N+1];
	
		for(int i=1; i<N+1; i++) {
			A[i] = new ArrayList<>();
		}
		
		for(int i=0; i<E; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			A[u].add(v);
			A[v].add(u);
		}
		
		
		System.out.println(dfs(1)-1);
	}
	
	static int dfs(int node) {
		if(visited[node]) {
			return 0;
		}
		
		visited[node] = true;
		int count = 1;
		for(int i : A[node]) {
			if(visited[i] == false) {
				count += dfs(i);
			}
		}
		return count;
	}
	
}