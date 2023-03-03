import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class Main {
	static int[] arr;
	static int n, s, cnt = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		arr = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		dfs(0, 0);
		
		System.out.println(s == 0 ? cnt - 1 : cnt);
		
		br.close();
	}
	
	public static void dfs(int depth, int sum) {
		if(depth == n) {
			if(sum == s)
				cnt++;
			return;
		}
		
		dfs(depth + 1, sum + arr[depth]);
		dfs(depth + 1, sum);
	}
}
