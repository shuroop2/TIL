import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int p = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		
		while(m-- > 1) {
			st = new StringTokenizer(br.readLine());
			p = Math.min(p, Integer.parseInt(st.nextToken()));
			s = Math.min(s, Integer.parseInt(st.nextToken()));
		}
		
		int price = n / 6 * p + Math.min(p, n % 6 * s);
		price = Math.min(price, n * s);
		
		System.out.println(price);
		
		br.close();
	}
}