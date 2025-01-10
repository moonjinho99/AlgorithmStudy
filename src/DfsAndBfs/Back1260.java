package DfsAndBfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class Back1260 {
	
	static boolean[] visited; 
	static int[][] graph;
	

	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		int node = Integer.parseInt(input[0]);
		int line = Integer.parseInt(input[1]);
		int start = Integer.parseInt(input[2]);
		
		visited = new boolean[node+1];
		graph = new int[node+1][node+1];
		
		for(int i=1; i<=line; i++)
		{
			String[] linked = br.readLine().split(" ");
			int link1 = Integer.parseInt(linked[0]);
			int link2 = Integer.parseInt(linked[1]);
			
			graph[link1][link2] = graph[link2][link1] = 1;
		}
		
		dfs(start);		
		
		visited = new boolean[node+1];
		System.out.println();
		
		bfs(start);
		
	}

	//재귀 
	public static void dfs(int start)
	{				
		visited[start] = true;
		
		System.out.print(start+" ");

		for(int i =0; i<graph.length; i++)
		{				
			if(!visited[i] && graph[start][i] != 0)
				dfs(i);
		}						
		
	}
	
	//stack
	public static void dfs_stack(int start)
	{			
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(start);	
		visited[start] = true;
		
		while(!stack.isEmpty())
		{	
			int c = stack.pop();
			System.out.print(c+" ");
			
			for(int i =0; i<graph.length; i++)
			{				
				if(!visited[i] && graph[c][i] != 0)
				{
					stack.push(i);
					visited[i] = true;
				}
			}	
		}							
	}

	
	public static void bfs(int start)
	{
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(start);
		visited[start] = true;
				
		while(!queue.isEmpty())
		{
			int now = queue.poll();
			System.out.print(now+" ");
			
			for(int i=0; i<graph.length; i++)
			{			
				if(!visited[i] && graph[now][i] != 0)
				{
					queue.offer(i);
					visited[i] = true;
				}
			}
		}
		
	}

}
