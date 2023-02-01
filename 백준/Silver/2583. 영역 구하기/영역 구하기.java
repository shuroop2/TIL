import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int m, n, cnt;
	static boolean[][] map;
	static int[][] move = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		map = new boolean[m][n];
		
		while(k-- > 0) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			for(int i=y1; i<y2; i++)
				for(int j=x1; j<x2; j++)
					map[i][j] = true;
		}
		
		List<Integer> list = new ArrayList<>();
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				if(!map[i][j]) {
					cnt = 0;
					dfs(i, j);
					list.add(cnt);
				}
			}
		}
		
		Collections.sort(list);
		
		System.out.println(list.size());
		for(int i : list)
			System.out.print(i + " ");
		
		br.close();
	}
	
	public static void dfs(int x, int y) {
		map[x][y] = true;
		cnt++;
		
		for(int i=0; i<4; i++) {
			int dx = x + move[i][0];
			int dy = y + move[i][1];
			
			if(dx >= 0 && dx < m && dy >= 0 && dy < n)
				if(!map[dx][dy])
					dfs(dx, dy);
		}
	}
}
