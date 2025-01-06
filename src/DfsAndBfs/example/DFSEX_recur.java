package DfsAndBfs.example;

import java.util.ArrayList;

public class DFSEX_recur {
	
	static boolean[] visited = new boolean[7];
	static ArrayList<Integer>[] A = new ArrayList[7];
	static ArrayList<Integer> procedure = new ArrayList<Integer>();

	public static void main(String[] args) {
		
		for(int i=1; i<=6; i++) {
			A[i] = new ArrayList<>();
		}

		A[1].add(2);
		A[1].add(3);
		A[2].add(5);
		A[2].add(6);
		A[3].add(4);
		A[4].add(6);
		
		DFS(1);
		
		System.out.println(procedure.toString());
	}
	
	static void DFS(int v) {
		
		if(visited[v]) return;
		
		visited[v] = true;
		procedure.add(v);
		
		for(int i: A[v]) {
			if(!visited[i]) {
				DFS(i);
			}
		}
	}

}
