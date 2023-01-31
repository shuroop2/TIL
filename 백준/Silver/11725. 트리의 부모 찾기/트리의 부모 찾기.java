import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		
		for(int i=0; i<n; i++)
			list.add(new ArrayList<>());
		
		for(int i=0; i<n-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			list.get(a).add(b);
			list.get(b).add(a);
		}
		
		boolean[] visited = new boolean[n];
		int[] parent = new int[n];
		
		Queue<Integer> q = new LinkedList<>();
		q.add(0);
		while(!q.isEmpty()) {
			int tmp = q.poll();
			for(int node : list.get(tmp)) {
				if(!visited[node]) {
					visited[node] = true;
					q.add(node);
					parent[node] = tmp;
				}
			}
		}
		
		for(int i=1; i<n; i++)
			System.out.println(parent[i] + 1);
		
		br.close();
	}
}
