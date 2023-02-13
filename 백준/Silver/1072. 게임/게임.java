import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int z = (int) ((long) y * 100 / x);
		int answer = -1;
		int left = 0, right = 1000000000;
		
		while(left <= right) {
			int mid = (left + right) / 2;
			
			if((int) ((long) (y + mid) * 100 / (x + mid)) != z) {
				answer = mid;
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		System.out.println(answer);
		
		br.close();
	}
}
