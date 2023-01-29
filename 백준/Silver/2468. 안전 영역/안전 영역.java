import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static boolean[][] visited;
	static int[][] move = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	static int n;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		int max = 1;
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				map[i][j] = tmp;
				max = Math.max(max, tmp);
			}
		}
		
		int cnt1 = 0;
		for(int k=0; k<=max; k++) {
			int cnt2 = 0;
			visited = new boolean[n][n];
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(map[i][j] > k && !visited[i][j]) {
						dfs(i, j, k);
						cnt2++;
					}
				}
			}
			cnt1 = Math.max(cnt1, cnt2);
		}
		
		System.out.println(cnt1);
		
		br.close();
	}
	
	public static void dfs(int x, int y, int depth) {
		visited[x][y] = true;
		
		for(int i=0; i<4; i++) {
			int dx = x + move[i][0];
			int dy = y + move[i][1];
			
			if(dx >= 0 && dx < n && dy >= 0 && dy < n)
				if(map[dx][dy] > depth && !visited[dx][dy])
					dfs(dx, dy, depth);
		}
	}
}
