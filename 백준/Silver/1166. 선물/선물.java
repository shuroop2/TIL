import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long n = Long.parseLong(st.nextToken());
		long l = Long.parseLong(st.nextToken());
		long w = Long.parseLong(st.nextToken());
		long h = Long.parseLong(st.nextToken());
		
		double low = 0, high = Math.max(l, Math.max(w, h));
		
		for(int i=0; i<10000; i++) {
			double mid = (low + high) / 2;
			if((long)(l / mid) * (long)(w / mid) * (long)(h / mid) < n)
				high = mid;
			else
				low = mid;
		}
		System.out.println(low);
		
		br.close();
	}
}