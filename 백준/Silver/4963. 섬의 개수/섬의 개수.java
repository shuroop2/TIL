import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static boolean[][] visited;
	static int[][] move = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		String tmp;
		
		while(!(tmp = br.readLine()).equals("0 0")) {
			st = new StringTokenizer(tmp);
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			map = new int[h][w];
			visited = new boolean[h][w];
			
			for(int i=0; i<h; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<w; j++)
					map[i][j] = Integer.parseInt(st.nextToken()); 
			}
			
			int cnt = 0;
			for(int i=0; i<h; i++) {
				for(int j=0; j<w; j++) {
					if(map[i][j] == 1 && !visited[i][j]) {
						cnt++;
						dfs(i, j);
					}
				}
			}
			sb.append(cnt + "\n");
		}
		System.out.println(sb);
		
		br.close();
	}
	
	public static void dfs(int x, int y) {
		visited[x][y] = true;
		
		for(int i=0; i<8; i++) {
			int dx = x + move[i][0];
			int dy = y + move[i][1];
			
			if(dx >= 0 && dx < map.length && dy >= 0 && dy < map[0].length)
				if(map[dx][dy] == 1 && !visited[dx][dy])
					dfs(dx, dy);
		}
	}
}
