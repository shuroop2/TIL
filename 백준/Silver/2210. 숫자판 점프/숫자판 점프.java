import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static String[][] map = new String[5][5];
	static Set<String> set = new HashSet<>();
	static int[][] move = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i=0; i<5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<5; j++)
				map[i][j] = st.nextToken();
		}
		
		for(int i=0; i<5; i++)
			for(int j=0; j<5; j++)
				dfs(i, j, map[i][j]);
		
		System.out.println(set.size());
		
		br.close();
	}
	
	public static void dfs(int x, int y, String s) {
		if(s.length() == 6) {
			set.add(s);
			return;
		}
		
		for(int i=0; i<4; i++) {
			int dx = x + move[i][0];
			int dy = y + move[i][1];
			
			if(dx >= 0 && dx < 5 && dy >= 0 && dy < 5)
				dfs(dx, dy, s + map[dx][dy]);
		}
	}
}
