import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static boolean[][] map;
	static boolean[] visited;
	static int cnt = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		map = new boolean[n + 1][n + 1];
		visited = new boolean[n + 1];
		
		while(m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map[a][b] = map[b][a] = true;
		}
		dfs(1);
		
		System.out.println(cnt);
		
		br.close();
	}
	
	public static void dfs(int start) {
		visited[start] = true;
		
		for(int i=1; i<map.length; i++) {
			if(map[start][i] && !visited[i]) {
				cnt++;
				dfs(i);
			}
		}
	}
}
