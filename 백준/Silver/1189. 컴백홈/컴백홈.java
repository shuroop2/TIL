import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static char[][] map;
	static boolean[][] visited;
	static int[][] move = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	static int r, c, k, answer = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		map = new char[r][c];
		visited = new boolean[r][c];
		
		for(int i=0; i<r; i++) {
			String tmp = br.readLine();
			for(int j=0; j<c; j++)
				map[i][j] = tmp.charAt(j);
		}
		
		visited[r - 1][0] = true;
		dfs(r - 1, 0, 0);
		
		System.out.println(answer);
		
		br.close();
	}
	
	public static void dfs(int x, int y, int cnt) {
		if(cnt == k - 1) {
			if(x == 0 && y == c - 1)
				answer++;
			return;
		}
		
		for(int i=0; i<4; i++) {
			int dx = x + move[i][0];
			int dy = y + move[i][1];
			
			if(dx >= 0 && dx < r && dy >= 0 && dy < c) {
				if(map[dx][dy] != 'T' && !visited[dx][dy]) {
					visited[dx][dy] = true;
					dfs(dx, dy, cnt + 1);
					visited[dx][dy] = false;
				}
			}
		}
	}
}