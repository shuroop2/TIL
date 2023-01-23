import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int result = 0;
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		Queue<Integer> q = new LinkedList<>();
		
		for(int i=1; i<=N; i++)
			q.add(i);
		
		while(q.size() > N - M) {
			int num = Integer.parseInt(st.nextToken());
			int cnt = 0;
			
			while(q.peek() != num) {
				q.add(q.poll());
				cnt++;
			}
			
			result += Math.min(cnt, q.size() - cnt);
			q.poll();
		}
		
		System.out.println(result);
		
		br.close();
	}
}