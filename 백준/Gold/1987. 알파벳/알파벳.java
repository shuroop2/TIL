import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int r, c, max = 0;
	static int[][] map;
	static boolean[] visited = new boolean[26];
	static int[][] move = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		map = new int[r][c];
		
		for(int i=0; i<r; i++) {
			String tmp = br.readLine();
			for(int j=0; j<c; j++)
				map[i][j] = tmp.charAt(j) - 'A';
		}
		
		dfs(0, 0, 1);
		
		System.out.println(max);
		
		br.close();
	}
	
	public static void dfs(int x, int y, int cnt) {
		visited[map[x][y]] = true;
		max = Math.max(max, cnt);
		
		for(int i=0; i<4; i++) {
			int dx = x + move[i][0];
			int dy = y + move[i][1];
			
			if(dx >= 0 && dx < r && dy >= 0 && dy < c) {
				if(!visited[map[dx][dy]]) {
					dfs(dx, dy, cnt + 1);
					visited[map[dx][dy]] = false;
				}
			}
		}
	}
}
