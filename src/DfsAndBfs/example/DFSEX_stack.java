package DfsAndBfs.example;

import java.util.ArrayList;
import java.util.Stack;

public class DFSEX_stack {
	
	static boolean[] visited = new boolean[7];
	static ArrayList<Integer>[] A = new ArrayList[7];
	static ArrayList<Integer> procedure = new ArrayList<>();

	public static void main(String[] args) {
		
		for(int i=1; i<=6; i++)
		{
			A[i] = new ArrayList<Integer>();
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
	
	public static void DFS(int v) {
		Stack<Integer> stack = new Stack<Integer>();
		
		stack.push(v);
		
		while(!stack.isEmpty()) {
			int cur = stack.pop();
			visited[cur] = true;
			procedure.add(cur);
			
			for(int i : A[cur]) {
				if(!visited[i]) {
					stack.push(i);
				}
			}
		}
	}

}
