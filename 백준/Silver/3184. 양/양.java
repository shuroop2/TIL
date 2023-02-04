import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int r, c, sheep, wolf;
	static char[][] map;
	static boolean[][] visited;
	static int[][] move = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	static int[] result = new int[2];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		map = new char[r][c];
		visited = new boolean[r][c];
		
		for(int i=0; i<r; i++) {
			String tmp = br.readLine();
			for(int j=0; j<c; j++)
				map[i][j] = tmp.charAt(j);
		}
		
		for(int i=0; i<r; i++) {
			for(int j=0; j<c; j++) {
				wolf = sheep = 0;
				if(!visited[i][j] && map[i][j] != '#')
					dfs(i, j);
				
				if(sheep > wolf)
					wolf = 0;
				else
					sheep = 0;
				
				result[0] += sheep;
				result[1] += wolf;
			}
		}
		System.out.println(result[0] + " " + result[1]);
		
		br.close();
	}
	
	public static void dfs(int x, int y) {
		visited[x][y] = true;
		
		if(map[x][y] == 'o')
			sheep++;
		else if(map[x][y] == 'v')
			wolf++;
		
		for(int i=0; i<4; i++) {
			int dx = x + move[i][0];
			int dy = y + move[i][1];
			
			if(dx >= 0 && dx < r && dy >= 0 && dy < c)
				if(map[dx][dy] != '#' && !visited[dx][dy])
					dfs(dx, dy);
		}
	}
}