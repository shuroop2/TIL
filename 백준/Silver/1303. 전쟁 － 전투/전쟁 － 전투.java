import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static String[][] map;
	static boolean[][] visited;
	static int[][] move = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}}; 
	static int cnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		map = new String[m][n];
		visited = new boolean[m][n];
		
		for(int i=0; i<m; i++) {
			String[] tmp = br.readLine().split("");
			for(int j=0, k=0; j<n; j++)
				map[i][j] = tmp[k++];
		}
		
		int cnt1 = 0, cnt2 = 0;
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				if(!visited[i][j]) {
					cnt = 1;
					dfs(i, j, map[i][j]);
					
					if(map[i][j].equals("W"))
						cnt1 += cnt * cnt;
					else
						cnt2 += cnt * cnt;
				}
			}
		}
		System.out.println(cnt1 + " " + cnt2);
		
		br.close();
	}
	
	public static void dfs(int x, int y, String color) {
		visited[x][y] = true;
		
		for(int i=0; i<4; i++) {
			int dx = x + move[i][0];
			int dy = y + move[i][1];
			
			if(dx >= 0 && dx < visited.length && dy >= 0 && dy < visited[0].length) {
				if(map[dx][dy].equals(color) && !visited[dx][dy]) {
					cnt++;
					dfs(dx, dy, color);
				}
			}
		}
	}
}
