import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int x = Integer.parseInt(br.readLine());
		int cnt = 0, n = 0;
		
		while(cnt < x) {
			n++;
			cnt += n;
		}
		
		if(n % 2 == 0)
			System.out.println(x - cnt + n + "/" + (cnt - x + 1));
		else
			System.out.println(cnt - x + 1 + "/" + (x - cnt + n));
			
		br.close();
	}
}