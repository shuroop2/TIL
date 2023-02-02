import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int end, answer = -1;
	static List<List<Integer>> graph = new ArrayList<>();
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		visited = new boolean[n + 1];
		for(int i=0; i<=n; i++)
			graph.add(new ArrayList<>());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(br.readLine());
		
		while(m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			graph.get(x).add(y);
			graph.get(y).add(x);
		}	
		dfs(start, 0);
		
		System.out.println(answer);
		
		br.close();
	}
	
	public static void dfs(int start, int cnt) {
		visited[start] = true;
		
		for(int i : graph.get(start)) {
			if(!visited[i]) {
				if(i == end) {
					answer = cnt + 1;
					return;
				}
				dfs(i, cnt + 1);
			}
		}
	}
}