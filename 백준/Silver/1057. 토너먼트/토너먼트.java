import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int i = Integer.parseInt(st.nextToken());
		int round = 0;
		
		while(true) {
			k = k / 2 + k % 2;
			i = i / 2 + i % 2;
			round++;
			if(k == i) {
				System.out.println(round);
				return;
			}
		}
	}
}