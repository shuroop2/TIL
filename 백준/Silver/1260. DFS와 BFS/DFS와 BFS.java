import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static boolean[][] arr;
	static boolean[] visited1;
	static boolean[] visited2;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());
		arr = new boolean[n + 1][n + 1];
		visited1 = new boolean[n + 1];
		visited2 = new boolean[n + 1];
		
		while(m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			arr[a][b] = arr[b][a] = true;
		}
		
		dfs(v);
		sb.append("\n");
		bfs(v);
		
		System.out.println(sb);
		
		br.close();
	}
	
	public static void dfs(int start) {
		visited1[start] = true;
		sb.append(start + " ");
		
		for(int i=0; i<arr.length; i++)
			if(arr[start][i] && !visited1[i])
				dfs(i);
	}
	
	public static void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		visited2[start] = true;
		
		while(!q.isEmpty()) {
			start = q.poll();
			sb.append(start + " ");
			
			for(int i=1; i<arr.length; i++) {
				if(arr[start][i] && !visited2[i]) {
					q.add(i);
					visited2[i] = true;
				}
			}
		}
	}
}