import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int m, n;
	static int[][] map;
	static boolean[][] visited;
	static int[][] move = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		map = new int[m][n];
		visited = new boolean[m][n];
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		int cnt = 0;
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				if(map[i][j] == 1 && !visited[i][j]) {
					dfs(i, j);
					cnt++;
				}
			}
		}
		System.out.println(cnt);
		
		br.close();
	}
	
	public static void dfs(int x, int y) {
		visited[x][y] = true;
		
		for(int i=0; i<8; i++) {
			int dx = x + move[i][0];
			int dy = y + move[i][1];
			
			if(dx >= 0 && dx < m && dy >= 0 && dy < n)
				if(map[dx][dy] == 1 && !visited[dx][dy])
					dfs(dx, dy);
		}
	}
}