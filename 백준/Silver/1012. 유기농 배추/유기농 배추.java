import java.util.Scanner;

public class Main {
	static boolean[][] visited;
	static boolean[][] field;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		
		while(T-- > 0) {
			int M = sc.nextInt();
			int N = sc.nextInt();
			int K = sc.nextInt();
			visited = new boolean[M][N];
			field = new boolean[M][N];
			
			while(K-- > 0) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				field[x][y] = true;
			}
			
			int cnt = 0;
			for(int i=0; i<M; i++) {
				for(int j=0; j<N; j++) {
					if(field[i][j] && !visited[i][j]) {
						dfs(i, j);
						cnt++;
					}
				}
			}
			sb.append(cnt + "\n");
		}
		
		System.out.println(sb);
		
		sc.close();
	}
	
	public static void dfs(int x, int y) {
		int[][] move = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
		visited[x][y] = true;
		
		for(int i=0; i<4; i++) {
			int dx = x + move[i][0];
			int dy = y + move[i][1];
			
			if(dx >= 0 && dx < visited.length && dy >= 0 && dy < visited[0].length)
				if(field[dx][dy] && !visited[dx][dy])
					dfs(dx, dy);
		}
		
	}
}