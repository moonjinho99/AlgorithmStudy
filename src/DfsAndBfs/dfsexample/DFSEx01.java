package DfsAndBfs.dfsexample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DFSEx01 {

	static int N,E; //N은 노드의 수 , E는 엣지(간선)의 수
	static int[][] Graph; // 그래프를 표현할 2D 배열
	static boolean[] Visited; // 각 노드의 방문 여부를 저장할 배열
	
	static void dfs(int node) {
		Visited[node] = true; //현재 노드 방문 표시
		System.out.println(node+" ");
		
		//인접 노드 순회
		for(int next=0; next<N; next++)
		{
			//아직 방문하지 않은 노드이먀, 간선이 존재한다면
			if(!Visited[next] && Graph[node][next] != 0)
			{
				dfs(next);
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		Graph = new int[N+1][N+1];
		Visited = new boolean[N+1];
		
		for(int i=0; i<E; i++)
		{
			st = new StringTokenizer(bf.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			Graph[u][v] = Graph[v][u] = 1;
		}
		
		dfs(0);
	}
	
}
