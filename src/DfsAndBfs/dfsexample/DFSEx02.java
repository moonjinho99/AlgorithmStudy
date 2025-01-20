package DfsAndBfs.dfsexample;

import java.util.Scanner;

//N x M 크기의 얼음 틀이 있다. 구멍이 뚫려 있는 부분은 0, 칸막이가 존재하는 부분은 1로 표시된다. 
//구멍이 뚫려 있는 부분끼리 상,하,좌,우로 붙어 있는 경우 서로 연결되어 있는 것으로 간주한다. 
//이때 얼음 틀의 모양이 주어졌을 때 생성되는 총 아이스크림의 개수를 구하는 프로그램을 작성하시오.
//
//<입력예시>
//4 5
//00110
//00011
//11111
//00000
//
//<출력예시>
//3

public class DFSEx02 {
	
	public static int n,m;
	
	public static int[][]graph = new int[1000][1000];
	
	public static boolean dfs(int x, int y) {

		if(x <= -1 || x >= n || y <= -1 || y >= m)
		{
			return false;
		}
		
		if(graph[x][y] == 0) {
			graph[x][y] = 1;
			
			dfs(x - 1, y);
			dfs(x, y - 1);
			dfs(x + 1, y);
			dfs(x, y + 1);
			return true;
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		sc.nextLine();
		
		for(int i=0; i<n; i++) {
			String str = sc.nextLine();
			for(int j=0; j < m; j++) {
				graph[i][j] = str.charAt(j) - '0';
			}
		}
		
		int result = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(dfs(i,j)) {
					result += 1;
				}
			}
		}
		
		System.out.println(result);
	}
	

}
