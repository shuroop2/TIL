import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println(solv(Integer.parseInt(br.readLine())));
		br.close();
	}
	
	public static int solv(int num) {
		int cnt = 99;
		
		if(num < 100)
			return num;
		else {
			for(int i=100; i<=num; i++) {
				int i3 = i / 100;
				int i2 = i / 10 % 10;
				int i1 = i % 10;
				
				if((i3 - i2) == (i2 - i1))
					cnt++;
			}
		}
		
		return cnt;
	}
}
