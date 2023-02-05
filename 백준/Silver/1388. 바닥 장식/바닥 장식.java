import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static char[][] map;
	static boolean[][] visited;
	static int[][] move = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new char[n][m];
		visited = new boolean[n][m];
		int result = 0;
		
		for(int i=0; i<n; i++) {
			String tmp = br.readLine();
			for(int j=0; j<m; j++)
				map[i][j] = tmp.charAt(j);
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(!visited[i][j]) {
					dfs(i, j);
					result++;
				}
			}
		}
		System.out.println(result);
		
		br.close();
	}
	
	public static void dfs(int x, int y) {
		visited[x][y] = true;
		
		for(int i=0; i<4; i++) {
			int dx = x + move[i][0];
			int dy = y + move[i][1];
			
			if(dx >= 0 && dx < n && dy >= 0 && dy < m) {
				if(map[x][y] == '-') {
					if(map[x][dy] == '-' && !visited[x][dy])
						dfs(x, dy);
				} else {
					if(map[dx][y] == '|' && !visited[dx][y])
						dfs(dx, y);
				}
			}
		}
	}
}