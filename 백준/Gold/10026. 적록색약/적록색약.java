import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static char[][] map;
	static boolean[][] visited;
	static int[][] move = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		map = new char[n][n];
		visited = new boolean[n][n];
		
		for(int i=0; i<n; i++) {
			char[] tmp = br.readLine().toCharArray();
			for(int j=0; j<n; j++) {
				map[i][j] = tmp[j];
			}
		}
		
		int cnt1 = 0, cnt2 = 0;;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(!visited[i][j]) {
					dfs(i, j);
					cnt1++;
				}
			}
		}
		
		for(int i=0; i<n; i++)
			for(int j=0; j<n; j++)
				if(map[i][j] == 'R')
					map[i][j] = 'G';
		
		visited = new boolean[n][n];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(!visited[i][j]) {
					dfs(i, j);
					cnt2++;
				}
			}
		}
		
		System.out.println(cnt1 + " " + cnt2);
		
		br.close();
	}
	
	public static void dfs(int x, int y) {
		visited[x][y] = true;
		
		for(int i=0; i<4; i++) {
			int dx = x + move[i][0];
			int dy = y + move[i][1];
			
			if(dx >= 0 && dx < map.length && dy >= 0 && dy < map.length)
				if(map[dx][dy] == map[x][y] && !visited[dx][dy])
					dfs(dx, dy);
		}
	}
}