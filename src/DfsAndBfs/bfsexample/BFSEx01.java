package DfsAndBfs.bfsexample;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFSEx01 {
	
	static boolean[] visited = new boolean[7];
	static Queue<Integer> queue = new LinkedList<>();
	static ArrayList<Integer>[] A = new ArrayList[7];
	static ArrayList<Integer> procedure = new ArrayList<Integer>();
	
	
	public static void main(String[] args) {
	
		for(int i=0; i<=6; i++)
		{
			A[i] = new ArrayList<Integer>();
		}
		
		A[1].add(2);
		A[1].add(3);
		A[2].add(5);
		A[2].add(6);
		A[3].add(4);
		A[4].add(6);
		
		BFS(1);
		
		System.out.println(procedure.toString());

	}
	
	private static void BFS(int start) {
		queue.offer(start);
		
		while(!queue.isEmpty())
		{
			int now = queue.poll();
			
			procedure.add(now);
			visited[now] = true;
			
			for(int i=0; i<A[now].size(); i++) {
				int node = A[now].get(i);
				
				if(!visited[node]) {
					queue.offer(node);
				}
			}
		}
	}

	
	
	
}
