import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, r, c;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		System.out.println(solution(0, 0, (int) Math.pow(2, n)));
		
		br.close();
	}
	
	public static int solution(int newR, int newC, int size) {
		if(size == 1)
			return 0;
		
		int newSize = size / 2;
		
		if(r < newR + newSize && c < newC + newSize)
			return solution(newR, newC, newSize);
		else if(r < newR + newSize && c >= newC + newSize)
			return solution(newR, newC + newSize, newSize) + (int) Math.pow(newSize, 2);
		else if(r >= newR + newSize && c < newC + newSize)
			return solution(newR + newSize, newC, newSize) + (int) Math.pow(newSize, 2) * 2;
		else
			return solution(newR + newSize, newC + newSize, newSize) + (int) Math.pow(newSize, 2) * 3;
	}
}
