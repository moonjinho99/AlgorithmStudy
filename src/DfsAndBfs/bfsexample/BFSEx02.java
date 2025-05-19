package DfsAndBfs.bfsexample;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//동빈이는 N * M 크기의 직사각형 형태의 미로에 갇혔습니다. 미로에는 여러 마리의 괴물이 있어 이를 피해 탈출해야 합니다.
//동빈이의 위치는 (1, 1) 이며 미로의 출구는 (N, M)의 위치에 존재하며 한 번에 한 칸씩 이동할 수 있습니다. 이때 괴물이 있는 부분은 0으로 괴물이 없는 부분은 1로 표시되어 있습니다. 미로는 반드시 탈출할 수 있는 형태로 제시됩니다.
//이때 동빈이가 탈출하기 위해 움직여야 하는 최소 칸의 개수를 구하세요. 칸을 셀 때는 시작 칸과 마지막 칸을 모두 포함해서 계산합니다.
//
//<입력조건>
//첫째 줄에 두 정수 N, M(4<=N, M<=200)이 주어집니다. 다음 N개의 줄에는 각각 M개의 정수(0 혹은 1)로 미로의 정보가 주어집니다. 각각의 수들은 공백 없이 붙여서 입력으로 제시됩니다. 또한 시작 칸과 마지막 칸은 항상 1입니다.
//
//<출력조건>
//첫째 줄에 최소 이동 칸의 개수를 출력합니다.
//
//<입력예시>
//5 6
//101010
//111111
//000001
//111111
//111111
//
//<출력예시>
//10

class Node{
	
	private int x;
	private int y;
	
	public Node(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX()
	{
		return this.x;
	}
	
	public int getY()
	{
		return this.y;
	}
}

public class BFSEx02 {

	public static int n,m;
	
	public static int[][] graph = new int[200][200];
	
	public static int dx[] = {-1,1,0,0};
	public static int dy[] = {0,0,-1,1};
	
	
	public static int bfs(int x, int y) {
		
		Queue<Node> q = new LinkedList<Node>();
		q.offer(new Node(x,y));
		
		while(!q.isEmpty())
		{
			Node node = q.poll();
			x = node.getX();
			y = node.getY();
			
			for(int i=0; i<4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
				
				if(graph[nx][ny] == 0) continue;
				
				if(graph[nx][ny] == 1) {
					graph[nx][ny] = graph[x][y] + 1;
					q.offer(new Node(nx,ny));
				}
			}
		}
		
		return graph[n - 1][m - 1];
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		sc.nextLine();
		
		for(int i=0; i<n; i++) {
			String str = sc.nextLine();
			for(int j=0; j < m; j++)
			{
				graph[i][j] = str.charAt(j) - '0';
			}
		}
		
		System.out.println(bfs(0,0));
	}
}
